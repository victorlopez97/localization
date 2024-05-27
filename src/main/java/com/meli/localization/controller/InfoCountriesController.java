package com.meli.localization.controller;

import com.meli.localization.entity.infocountries.ResponseCountry;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IInfoCountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/get/localization")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
public class InfoCountriesController {
    @Autowired
    private IInfoCountriesService iInfoCountriesService;

    @GetMapping("/info-country/{country}")
    public List<ResponseCountry> getInfoCountries (@PathVariable  String country) throws ConflicException {
        return iInfoCountriesService.getInfoCountries(country);
    }
}
