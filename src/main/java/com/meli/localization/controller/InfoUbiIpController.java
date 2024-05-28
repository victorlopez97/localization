package com.meli.localization.controller;

import com.meli.localization.entity.iplocation.ResponseIpLocation;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IIpLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/get/localization")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
public class InfoUbiIpController {
    @Autowired
    private IIpLocationService iIpLocationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoUbiIpController.class);
    @GetMapping("/info-ip/{ip}")
    public ResponseIpLocation getInfoMonedaByCountries (@PathVariable  String ip) throws ConflicException {
        LOGGER.info("Start Controller getInfoMonedaByCountries");
        return iIpLocationService.getInfoLocationByIp(ip);
    }
}
