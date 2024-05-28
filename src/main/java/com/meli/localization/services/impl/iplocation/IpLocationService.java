package com.meli.localization.services.impl.iplocation;

import com.meli.localization.entity.iplocation.ResponseIpLocation;
import com.meli.localization.exception.ConflicException;
import com.meli.localization.services.IIpLocationService;
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
public class IpLocationService implements IIpLocationService {
    @Autowired
    @Qualifier("RestTemplateBasic")
    private RestTemplate restTemplate;
    private static String URLIPSERVICE = "https://api.ip2location.io/?key=44928629EEFE27F27AA8B5BF6E14049C";
    private static final Logger LOGGER = LoggerFactory.getLogger(IpLocationService.class);


    public ResponseIpLocation getInfoLocationByIp(String ipPublic) throws ConflicException {
        LOGGER.info("Start service getInfoOfMoneda: {}" , ipPublic);
        try {
            UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(URLIPSERVICE).queryParam("ip",ipPublic);
            LOGGER.info("Url api ip location: {}" , url);
            ResponseEntity<ResponseIpLocation> response = restTemplate.exchange(url.toUriString(), HttpMethod.GET, null, ResponseIpLocation.class);
            LOGGER.info("Response service information ip location: {}" , response.getBody());
            return response.getBody();
        } catch (Exception e) {
            throw new ConflicException("Er"+e.getMessage());
        }
    }
}
