package com.meli.localization.services;

import com.meli.localization.dto.ResponseServiceGeolocation;
import com.meli.localization.exception.ConflicException;

import java.text.ParseException;

public interface IGeolocationIpService {
    ResponseServiceGeolocation buildResponseService (String ip) throws ConflicException, ParseException;
}
