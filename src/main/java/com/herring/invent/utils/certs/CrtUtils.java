package com.herring.invent.utils.certs;

import com.herring.invent.models.Certificate;
import com.herring.invent.models.ECertType;
import com.herring.invent.security.jwt.AuthEntryPointJwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CrtUtils {
    private CertificateFactory fac;

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    public CrtUtils() {
        try {
            fac = CertificateFactory.getInstance("X509");
        } catch (CertificateException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Certificate> getCerts(String folder) {
        ArrayList<Certificate> certs = new ArrayList<>();

        File dir = new File(folder);
        for (File file : getCertFiles(dir.listFiles())) {
            try {
                String SN;
                String owner = "";
                Date notAfter;
                ECertType type = ECertType.UNKNOWN;
                boolean isValid;

                FileInputStream is = new FileInputStream(file);
                X509Certificate cert = (X509Certificate) fac.generateCertificate(is);
                notAfter = cert.getNotAfter();
                SN = cert.getSerialNumber().toString();
                String subject = cert.getSubjectX500Principal().toString().replace("\\", "");
                String CN = subject.split("CN=")[1].split(",")[0];
                String O = subject.split("O=")[1].split(",")[0];

                if (CN.length() > 1) {
                    owner = CN;

                    if (subject.split("SURNAME=").length > 1) {

                        String SURNAME = subject.split("SURNAME=")[1].split(",")[0];
                        String GIVENNAME = subject.split("GIVENNAME=")[1].split(",")[0];

                        if (CN.equals(SURNAME + " " + GIVENNAME)) {
                            type = ECertType.INDIVIDUAL;
                        } else if (CN.equals(O)) {
                            type = ECertType.LEGAL;
                        }
                    } else if (subject.split("SURNAME=").length == 1
                            && subject.split("GIVENNAME=").length == 1) {
                        type = ECertType.ANON;
                    }
                }
                try {
                    cert.checkValidity();
                    isValid = true;
                } catch (CertificateExpiredException e) {
                    isValid = false;
                }

                certs.add(new Certificate(SN, owner, notAfter, type, isValid));

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (CertificateException e) {
                throw new RuntimeException(e);
            }

        }

        return certs;
    }

    private List<File> getCertFiles(File[] files) {
        List<File> certs = new ArrayList<>();
        for (File dir : files) {
            if (dir.isDirectory()) {
                for (File file : dir.listFiles()) {
                    if (!file.isDirectory()) {
                        certs.add(file);
                    }
                }
            }
        }
        return certs;
    }

}
