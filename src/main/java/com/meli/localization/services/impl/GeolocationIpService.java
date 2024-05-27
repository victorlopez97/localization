package com.meli.localization.services.impl;

import com.meli.localization.dto.ResponseServiceGeolocation;
import com.meli.localization.entity.infocountries.ResponseCountry;
import com.meli.localization.entity.infomoneda.ResponseMonedaInfo;
import com.meli.localization.entity.iplocation.ResponseIpLocation;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IGeolocationIpService;
import com.meli.localization.services.IInfoCountriesService;
import com.meli.localization.services.IInfoMonedaService;
import com.meli.localization.services.IIpLocationService;
import com.meli.localization.util.ValuesHomologationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeolocationIpService implements IGeolocationIpService {
    @Autowired
    private IIpLocationService iIpLocationService;
    @Autowired
    private IInfoCountriesService iInfoCountriesService;
    @Autowired
    private IInfoMonedaService iInfoMonedaService;

    public ResponseServiceGeolocation buildResponseService (String ip) throws ConflicException {
        ResponseIpLocation responseIpService = iIpLocationService.getInfoLocationByIp(ip);
        List<ResponseCountry> responseCountryService = iInfoCountriesService.getInfoCountries(responseIpService.getCountry_code());
        ResponseCountry getInfoCountry = responseCountryService.get(0);
        ResponseMonedaInfo responseMoneda = iInfoMonedaService.getInfoOfMoneda(getInfoCountry.getCurrencies().keySet().iterator().next());
        return  ResponseServiceGeolocation.builder()
                .ip(responseIpService.getIp())
                .fechaactual(responseIpService.getTime_zone_info().getCurrent_time())
                .hora(responseIpService.getTime_zone_info().getCurrent_time())
                .pais(responseIpService.getDistrict()+" "+"("+responseIpService.getCountry_name()+")")
                .iso(responseIpService.getCountry_code())
                .idioma(ValuesHomologationUtil.getLanguagesAsString(getInfoCountry.getLanguages()))
                .moneda(getInfoCountry.getCurrencies().keySet().iterator().next())
                .distaciaestimada("")
                .build();
    }

}
