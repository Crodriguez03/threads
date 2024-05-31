package com.example.threads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadsApplication {

	public static void main(String[] args) {
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","10");
		SpringApplication.run(ThreadsApplication.class, args);
	}

}
