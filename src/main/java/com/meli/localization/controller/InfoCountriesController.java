package com.meli.localization.controller;

import com.meli.localization.entity.infocountries.ResponseCountry;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IInfoCountriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/get/localization")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
public class InfoCountriesController {
    @Autowired
    private IInfoCountriesService iInfoCountriesService;
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoCountriesController.class);
    @GetMapping("/info-country/{country}")
    public List<ResponseCountry> getInfoCountries (@PathVariable  String country) throws ConflicException {
        LOGGER.info("Start Controller getInfoCountries");
        return iInfoCountriesService.getInfoCountries(country);
    }
}
