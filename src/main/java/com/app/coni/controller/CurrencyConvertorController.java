package com.app.coni.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.coni.Service.CurrencyConvertorService;
import com.app.coni.model.TargetCurrency;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Currency Convertor", description = "Currency Convertor api")
public class CurrencyConvertorController {

	@Autowired
	private CurrencyConvertorService convertorService;

	@GetMapping(value = "/currency/convert/{amount}")
	@ApiOperation(value = "Get Converted Currency", response = TargetCurrency.class)
	public TargetCurrency getConvertedCurrency(@RequestParam("from") @Valid String from,
			@RequestParam("to") @Valid String to, @PathVariable("amount") @Valid BigDecimal amount) {

		TargetCurrency cur = convertorService.getConvertedCurrency(from, to, amount);
		return cur;

	}
}
