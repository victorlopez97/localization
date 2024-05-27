package com.meli.localization.entity.infocountries;

import com.meli.localization.entity.infocountries.currency.Currencies;
import com.meli.localization.entity.infocountries.name.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCountry {
    private Name name;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private Map<String, String> languages;
    private Map<String, Currencies> currencies;
    private List<String> timezones;
    private List<String> latlng;
}
