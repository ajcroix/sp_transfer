package com.surepass.resource;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.surepass.domain.Transfer;
import com.surepass.service.AS400Service;
import com.surepass.service.TransferService;


@RequestMapping("/transfer")
@RestController
public class TransferResource {
	@Autowired
	TransferService service;
	@Autowired
	private AS400Service as400Service;
	
	@RequestMapping(value = "/saveTransfer",
	method = RequestMethod.POST)
	public void saveTransfer(@RequestBody Transfer transfer){
		String amtStr = String.format("%015d", transfer.getAmount());
		String parmTfr = Long.toString(transfer.getFromAccount()) + 
				Long.toString(transfer.getToAccount()) + 
				amtStr + 
				transfer.getPurpose();
		as400Service.sendToAS400(parmTfr);
		service.saveTransfer(transfer);
	}
}
