package com.surepass.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.surepass.domain.Transfer;
import com.surepass.service.TransferService;

@RequestMapping("/transfer")
@RestController
public class TransferResource {
	@Autowired
	TransferService service;
	
	@RequestMapping(value = "/saveTransfer",
	method = RequestMethod.POST)
	public void saveTransfer(@RequestBody Transfer transfer){
		service.saveTransfer(transfer);
	}
}
