package com.module.crimelens.Services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.crimelens.Payloads.LocationDto;
import com.module.crimelens.Repositories.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LocationRepository locationRepository;

    public LocationDto getLocationById(Integer id) {

        LocationDto locationDto = modelMapper.map(locationRepository.findById(id), LocationDto.class);
        return locationDto;
    }
    
}
