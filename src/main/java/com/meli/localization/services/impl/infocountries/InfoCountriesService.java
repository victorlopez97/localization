package com.meli.localization.services.impl.infocountries;

import com.meli.localization.entity.infocountries.ResponseCountry;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IInfoCountriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class InfoCountriesService implements IInfoCountriesService {

    @Autowired
    @Qualifier("RestTemplateBasic")
    private RestTemplate restTemplate;

    private static final String URLCOUNTRY = "https://restcountries.com/v3.1/alpha/";
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoCountriesService.class);

    @Override
    public List<ResponseCountry> getInfoCountries(String country) throws ConflicException {
        LOGGER.info("Start service getInfoCountries: {}" , country);
        try {
            UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(URLCOUNTRY).pathSegment(country);
            LOGGER.info("Url api info country: {}" , url);
            ResponseEntity<List<ResponseCountry>> response = restTemplate.exchange(url.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<ResponseCountry>>() {});
            LOGGER.info("Response service information country: {}" , response.getBody());
            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new ConflicException("Error al consumir el servicio" + e.getMessage());
        } catch (Exception e) {
            throw new ConflicException("Error al consumir el servicio: " + e.getMessage());
        }
    }
}
