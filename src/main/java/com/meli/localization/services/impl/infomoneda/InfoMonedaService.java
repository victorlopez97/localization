package com.meli.localization.services.impl.infomoneda;

import com.meli.localization.entity.infocountries.ResponseCountry;
import com.meli.localization.entity.infomoneda.ResponseMonedaInfo;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IInfoMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class InfoMonedaService implements IInfoMonedaService {
    @Autowired
    @Qualifier("RestTemplateBasic")
    private RestTemplate restTemplate;
    private static final String URLMONEDA = "https://open.er-api.com/v6/latest/";
    public ResponseMonedaInfo getInfoOfMoneda(String codeCountryMoney) throws ConflicException {
        try{
            UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(URLMONEDA).pathSegment(codeCountryMoney);
            ResponseEntity<ResponseMonedaInfo> response = restTemplate.exchange(url.toUriString(), HttpMethod.GET, null, ResponseMonedaInfo.class);
            return response.getBody();
        }catch (Exception e){
            throw new ConflicException("Error al consumir el servicio"+ e.getMessage());
        }
    }
}
