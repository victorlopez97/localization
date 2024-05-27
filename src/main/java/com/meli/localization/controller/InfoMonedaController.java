package com.meli.localization.controller;

import com.meli.localization.entity.infomoneda.ResponseMonedaInfo;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IInfoMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/get/localization")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
public class InfoMonedaController {

    @Autowired
    private IInfoMonedaService iInfoMonedaService;

    @GetMapping("/info-moneda/{codeCountryMoney}")
    public ResponseMonedaInfo getInfoMonedaByCountries (@PathVariable  String codeCountryMoney) throws ConflicException {
        return iInfoMonedaService.getInfoOfMoneda(codeCountryMoney);
    }
}
