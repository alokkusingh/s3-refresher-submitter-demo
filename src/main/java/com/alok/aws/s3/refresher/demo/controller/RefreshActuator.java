package com.alok.aws.s3.refresher.demo.controller;


import com.alok.aws.s3.refresh.AppType;
import com.alok.aws.s3.refresh.submitter.S3RefreshSubmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "refresh-downstream")
public class RefreshActuator {

    @Autowired
    private S3RefreshSubmitter s3RefreshSubmitter;

    @ReadOperation
    public Boolean refreshAll() {
        s3RefreshSubmitter.submitRefresh();
        return true;
    }

    @ReadOperation
    public Boolean refreshOne(@Selector AppType system) {
        switch (system) {
            case APPA: {
                s3RefreshSubmitter.submitRefresh(AppType.APPA);
                break;
            }
            case APPB: {
                s3RefreshSubmitter.submitRefresh(AppType.APPB);
                break;
            }
            default:
                System.out.println("Unknown refresh");
        }

        return true;
    }
}
