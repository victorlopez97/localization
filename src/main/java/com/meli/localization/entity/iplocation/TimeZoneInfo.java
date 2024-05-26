package com.meli.localization.entity.iplocation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeZoneInfo {
        private String olson;
        private String current_time;
        private int gmt_offset;
        private boolean is_dst;
        private String sunrise;
        private String sunset;
}
