package com.alok.aws.s3.refresher.demo.submitter;

import com.alok.aws.s3.refresh.submitter.S3RefreshSubmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S3RefreshSubmitterUser {

    @Autowired
    private S3RefreshSubmitter s3RefreshSubmitter;

    public void refresh() {
        s3RefreshSubmitter.submitRefresh();
    }
}
