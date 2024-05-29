package com.meli.localization.services.impl.infomoneda;

import com.meli.localization.entity.infomoneda.ResponseMonedaInfo;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IInfoMonedaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class InfoMonedaService implements IInfoMonedaService {

    @Autowired
    @Qualifier("RestTemplateBasic")
    private RestTemplate restTemplate;
    private static final String URLMONEDA = "https://open.er-api.com/v6/latest/";
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoMonedaService.class);

    public ResponseMonedaInfo getInfoOfMoneda(String codeCountryMoney) throws ConflicException {
        LOGGER.info("Start service getInfoOfMoneda: {}" , codeCountryMoney);
        try{
            UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(URLMONEDA).pathSegment(codeCountryMoney);
            LOGGER.info("Url api moneda: {}", url);
            ResponseEntity<ResponseMonedaInfo> response = restTemplate.exchange(url.toUriString(), HttpMethod.GET, null, ResponseMonedaInfo.class);
            LOGGER.info("Response service information moneda by country: {}" , response.getBody());
            return response.getBody();
        }catch (Exception e){
            throw new ConflicException("Error al consumir el servicio"+ e.getMessage());
        }
    }
}
