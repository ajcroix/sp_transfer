package com.surepass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransferController {
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
}
