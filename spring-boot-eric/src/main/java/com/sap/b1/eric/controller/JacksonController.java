package com.sap.b1.eric.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sap.b1.eric.jackson.JacksonJsonService;
import com.sap.b1.eric.jackson.JacksonXmlService;


@RestController
@RequestMapping("/jackson/")
public class JacksonController {
	
	@Autowired
	JacksonJsonService jsonServ;
	@Autowired
	JacksonXmlService xmlServ;
	
	@GetMapping("/metadata")
	Object loadMetadata() {
		return xmlServ.loadMetadata();
	}
	
	@GetMapping("/json")
	Object loadJson() {
		try {
			return jsonServ.loadJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			// FIXME test
			// XXX test 
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error-no-message";
	}
}
