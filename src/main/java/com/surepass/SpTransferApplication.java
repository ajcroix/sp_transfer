package com.surepass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.surepass.repository.TransferRepository;

@SpringBootApplication
public class SpTransferApplication {
	
	@Autowired
	TransferRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpTransferApplication.class, args);
	}
}
