package it.itresources.samples.demo.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.itresources.samples.demo.model.ServiceInfo;
import it.itresources.samples.demo.service.InfoService;

@RestController
@RequestMapping("/api/v1")
public class InfoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InfoController.class);
	
	private final InfoService infoService;
	
	@Autowired
	public InfoController(InfoService infoService) {
		Assert.notNull(infoService, "InfoService instance cannot be null");
		this.infoService = infoService;
	}
	
	//@RequestMapping("/mgmt/info")
	//@RequestMapping(value = "/mgmt/info", method = RequestMethod.GET)
	@GetMapping("/mgmt/info")
	public ResponseEntity<ServiceInfo> info() {
		LOGGER.info("/info Request");
		
		ServiceInfo body = this.infoService.getInfo();
		LOGGER.info("info: {}", body);
		return new ResponseEntity<ServiceInfo>(body, HttpStatus.CREATED);
	}

}
