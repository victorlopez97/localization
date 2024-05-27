package com.meli.localization.entity.iplocation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseIpLocation {
    private String ip;
    private String country_code;
    private String country_name;
    private String region_name;
    private String district;
    private String city_name;
    private double latitude;
    private double longitude;
    private String zip_code;
    private String time_zone;
    private String asn;
    private String as;
    private String isp;
    private String domain;
    private String net_speed;
    private String idd_code;
    private String area_code;
    private String weather_station_code;
    private String weather_station_name;
    private String mcc;
    private String mnc;
    private String mobile_brand;
    private int elevation;
    private String usage_type;
    private String address_type;
    private String ads_category;
    private String ads_category_name;
    private TimeZoneInfo time_zone_info;

}
