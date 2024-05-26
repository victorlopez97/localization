package com.meli.localization.services;

import com.meli.localization.entity.iplocation.ResponseIpLocation;
import com.meli.localization.exception.ConflicException;

public interface IIpLocationService {
    ResponseIpLocation getInfoLocationByIp(String ipPublic) throws ConflicException;
}
