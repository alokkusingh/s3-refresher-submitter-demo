package com.alok.aws.s3.refresher.demo;

import com.alok.aws.s3.refresher.demo.submitter.S3RefreshSubmitterUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class S3RefreshPollerLibApplication implements ApplicationRunner {

	@Autowired
	private S3RefreshSubmitterUser s3RefreshSubmitterUser;

	public static void main(String[] args) {
		SpringApplication.run(S3RefreshPollerLibApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Application Started!!!");
		System.out.println("Application Started!!!");
		s3RefreshSubmitterUser.refresh();
	}

}
