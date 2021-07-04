package com.ua.soccerManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransferController {
	@RequestMapping("/transfer")
	public String transfer() {
		return "transfer";
	}
}
