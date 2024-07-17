package com.ssegning.lynx.local.service;

import com.ssegning.lynx.local.repo.ScanRepo;
import com.ssegning.lynx.local.mapper.UuidMapper;
import com.ssegning.lynx.local.domain.ScanEntity;
import com.ssegning.lynx.lynxbackend.model.Scan;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScanFactory {
    private final ScanRepo repo;
    private final UuidMapper uuidMapper;

    @ObjectFactory
    public ScanEntity factory(Scan scan) {
        var id = uuidMapper.map(scan.getId());
        if (id == null) {
            return new ScanEntity();
        }

        return repo.getReferenceById(id);
    }
}
