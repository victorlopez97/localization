package com.meli.localization.controller;

import com.meli.localization.entity.iplocation.ResponseIpLocation;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IIpLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/get/localization")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
public class InfoUbiIpController {
    @Autowired
    private IIpLocationService iIpLocationService;

    @GetMapping("/info-ip/{ip}")
    public ResponseIpLocation getInfoMonedaByCountries (@PathVariable  String ip) throws ConflicException {
        return iIpLocationService.getInfoLocationByIp(ip);
    }
}
