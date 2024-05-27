package com.meli.localization.entity.infomoneda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMonedaInfo {
    private String base_code;
    private Map<String, String> rates;
}
