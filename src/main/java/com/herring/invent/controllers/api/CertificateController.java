package com.herring.invent.controllers.api;

import com.herring.invent.services.CertificatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@CrossOrigin
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificatesService certificateService;

    @GetMapping("/list")
    public ResponseEntity<?> certList() {
        return ResponseEntity.ok(certificateService.getAllCertificates());
    }

    @GetMapping("/{SN}")
    public ResponseEntity<?> certBySN(@PathVariable String SN) {
        return ResponseEntity.ok(certificateService.getCertificate(SN));
    }
}
