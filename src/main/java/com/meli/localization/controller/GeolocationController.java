package com.meli.localization.controller;

import com.meli.localization.dto.ResponseServiceGeolocation;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IGeolocationIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/get/localization")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
public class GeolocationController {
    @Autowired
    private IGeolocationIpService iGeolocationIpService;
    @GetMapping("/info-geolocation/{ip}")
    public ResponseServiceGeolocation getInfoCountries (@PathVariable  String ip) throws ConflicException {
        return iGeolocationIpService.buildResponseService(ip);
    }
}