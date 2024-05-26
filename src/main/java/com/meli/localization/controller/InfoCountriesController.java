package com.meli.localization.controller;

import com.meli.localization.entity.infocountries.ResponseCountry;
import com.meli.localization.entity.infomoneda.ResponseMonedaInfo;
import com.meli.localization.entity.iplocation.ResponseIpLocation;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IInfoCountriesService;
import com.meli.localization.services.IInfoMonedaService;
import com.meli.localization.services.IIpLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/get/localization")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT})
public class InfoCountriesController {
    @Autowired
    private IIpLocationService iIpLocationService;

    @GetMapping("/ip/{country}")
    public ResponseIpLocation getInfoCountries (@PathVariable  String country) throws ConflicException {
        return iIpLocationService.getInfoLocationByIp(country);
    }
}
