package com.surepass.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surepass.domain.Transfer;
import com.surepass.repository.TransferRepository;
import com.surepass.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
	 @Autowired
	 TransferRepository transferRepository;
	 @Override
	 public void saveTransfer(Transfer transfer) {
		 transferRepository.save(transfer);
	 }
}
