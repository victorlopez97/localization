package com.meli.localization.controller;

import com.meli.localization.dto.ResponseServiceGeolocation;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IGeolocationIpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
@RequestMapping("/get/localization")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
public class GeolocationController {
    @Autowired
    private IGeolocationIpService iGeolocationIpService;
    private static final Logger LOGGER = LoggerFactory.getLogger(GeolocationController.class);
    @GetMapping("/info-geolocation/{ip}")
    public ResponseServiceGeolocation getInfoCountries (@PathVariable  String ip) throws ConflicException, ParseException {
        LOGGER.info("Start Controller getInfoCountries");
        return iGeolocationIpService.buildResponseService(ip);
    }
}
