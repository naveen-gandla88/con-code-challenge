package com.app.coni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.coni.Service.CurrentTimeService;
import com.app.coni.model.CurrentTime;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/timeapi")
@Api(value = "Current Time API", description = "Retrive Current Time")
public class CurrentTimeController {

	@Autowired
	private CurrentTimeService timeService;

	@GetMapping(value = "/gettime")
	@ApiOperation(value = "Retrive Current Time", response = CurrentTime.class)
	public CurrentTime getCurrentTime() {
		
		CurrentTime localTime = timeService.getCurrentTime();
		return localTime;

	}

}
