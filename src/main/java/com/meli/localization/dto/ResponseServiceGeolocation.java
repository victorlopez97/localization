package com.meli.localization.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseServiceGeolocation {
    @JsonProperty("Ip")
    private String ip;
    @JsonProperty("FechaActual")
    private String fechaactual;
    @JsonProperty("Pais")
    private String pais;
    @JsonProperty("Iso")
    private String iso;
    @JsonProperty("Idioma")
    private String idioma;
    @JsonProperty("Moneda")
    private String moneda;
    @JsonProperty("Hora")
    private String hora;
    @JsonProperty("DistaciaEstimada")
    private String distaciaestimada;


}
