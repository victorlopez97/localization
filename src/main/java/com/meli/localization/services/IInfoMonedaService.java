package com.meli.localization.services;

import com.meli.localization.entity.infomoneda.ResponseMonedaInfo;
import com.meli.localization.exception.ConflicException;

public interface IInfoMonedaService {
    ResponseMonedaInfo getInfoOfMoneda(String codeCountryMoney) throws ConflicException;
}
