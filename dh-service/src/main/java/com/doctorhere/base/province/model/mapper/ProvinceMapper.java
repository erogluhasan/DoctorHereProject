package com.doctorhere.base.province.model.mapper;


import com.doctorhere.base.country.model.Country;
import com.doctorhere.base.country.model.dto.CountryResponseDto;
import com.doctorhere.base.province.model.Province;
import com.doctorhere.base.province.model.dto.ProvinceResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProvinceMapper {

    ProvinceResponseDto toDto(Province province);
    List<ProvinceResponseDto> toDto(List<Province> provinces);

}
