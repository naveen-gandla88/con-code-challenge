package com.app.coni.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.coni.Service.ValidateVATNumService;
import com.app.coni.model.Country;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/vatapi")
@Api(value = "Validate VAT Number", description = "Validate VAT And Return Country Details")

public class ValidateVATController {

	@Autowired
	private ValidateVATNumService vatService;

	@ApiOperation(value = "Validate VAT and Return Country Details", response = Country.class)
	@GetMapping(value = "/validateVAT/{vatNumber}")
	public Country validateVAT(
			@ApiParam(value = "Vat Number", required = true) @Valid @PathVariable String vatNumber) {

		Country countryDtls = vatService.validateVATNumber(vatNumber);
		return countryDtls;

	}

}
