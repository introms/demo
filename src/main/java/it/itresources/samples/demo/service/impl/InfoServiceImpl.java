package it.itresources.samples.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.itresources.samples.demo.model.ServiceInfo;
import it.itresources.samples.demo.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InfoServiceImpl.class);

	@Override
	public ServiceInfo getInfo() {
		LOGGER.info("---> request to get Info");
		ServiceInfo info = new ServiceInfo("demo-service-from-info-service", "v0.1.0");
		return info;
	}
	
}
