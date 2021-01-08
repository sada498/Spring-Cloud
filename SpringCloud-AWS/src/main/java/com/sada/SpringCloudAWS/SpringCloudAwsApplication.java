package com.sada.SpringCloudAWS;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = ContextInstanceDataAutoConfiguration.class)
public class SpringCloudAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAwsApplication.class, args);
		//System.out.println("hello");
	}
	@Bean
	ApplicationRunner applicationRunner(AmazonS3 ) {
		return args -> {
			amazonS3.listBuckets().forEach(bucket -> System.out.println(bucket.getName()));
		};
	}

}

