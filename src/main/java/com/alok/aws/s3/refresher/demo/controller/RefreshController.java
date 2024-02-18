package com.alok.aws.s3.refresher.demo.controller;

import com.alok.aws.s3.refresh.AppType;
import com.alok.aws.s3.refresh.submitter.S3RefreshSubmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/refresh")
public class RefreshController {

    @Autowired
    private S3RefreshSubmitter s3RefreshSubmitter;

    @GetMapping
    ResponseEntity<String> refreshAll() {

        s3RefreshSubmitter.submitRefresh();
        return ResponseEntity
                .accepted()
                .body("{\"data\": \"Refresh accepted\"}");
    }

    @GetMapping("/serviceA")
    ResponseEntity<String> refreshA() {

        s3RefreshSubmitter.submitRefresh(AppType.APPA);
        return ResponseEntity
                .accepted()
                .body("{\"data\": \"Refresh accepted\"}");
    }

    @GetMapping("/serviceB")
    ResponseEntity<String> refreshB() {

        s3RefreshSubmitter.submitRefresh(AppType.APPB);
        return ResponseEntity
                .accepted()
                .body("{\"data\": \"Refresh accepted\"}");
    }
}
