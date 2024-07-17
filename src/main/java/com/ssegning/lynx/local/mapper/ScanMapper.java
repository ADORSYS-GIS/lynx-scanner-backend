package com.ssegning.lynx.local.mapper;

import com.ssegning.lynx.local.domain.ScanEntity;
import com.ssegning.lynx.local.service.ScanFactory;
import com.ssegning.lynx.lynxbackend.model.Scan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UuidMapper.class, ScanFactory.class})
public interface ScanMapper {
    @Mapping(target = "id", ignore = true)
    ScanEntity map(Scan scan);

    Scan map(ScanEntity scan);
}
