package com.meli.localization.services;

import com.meli.localization.entity.infocountries.ResponseCountry;
import com.meli.localization.exception.ConflicException;

import java.util.List;

public interface IInfoCountriesService {
    List<ResponseCountry> getInfoCountries(String country) throws ConflicException;
}
