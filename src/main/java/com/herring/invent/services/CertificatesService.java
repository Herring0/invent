package com.herring.invent.services;

import com.herring.invent.models.Certificate;
import com.herring.invent.utils.certs.CrtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CertificatesService {

    @Value("${invent.app.certsPath}")
    private String path;

    @Autowired
    private CrtUtils crtUtils;

    public List<Certificate> getAllCertificates() {
        return crtUtils.getCerts(path);
    }

    public Certificate getCertificate(String SN) {
        return crtUtils.getCerts(path).stream()
                .filter(certificate -> SN.equals(certificate.getSN()))
                .findAny().orElse(null);
    }
}
