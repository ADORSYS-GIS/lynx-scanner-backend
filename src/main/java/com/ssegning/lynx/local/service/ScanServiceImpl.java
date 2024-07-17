package com.ssegning.lynx.local.service;

import com.ssegning.lynx.local.mapper.ScanMapper;
import com.ssegning.lynx.local.repo.ScanRepo;
import com.ssegning.lynx.local.mapper.UuidMapper;
import com.ssegning.lynx.lynxbackend.model.Scan;
import com.ssegning.lynx.lynxbackend.service.ScanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScanServiceImpl implements ScanService {
    private final ScanRepo repo;
    private final ScanMapper mapper;
    private final UuidMapper uuidMapper;

    @Override
    public Scan createScan(Scan scan) {
        var entity = mapper.map(scan);
        var saved = repo.save(entity);
        return mapper.map(saved);
    }

    @Override
    public Scan updateScan(String scanId, Scan scan) {
        scan.setId(scanId);
        var entity = mapper.map(scan);
        var saved = repo.save(entity);
        return mapper.map(saved);
    }

    @Override
    public Scan getScan(String scanId) {
        var id = uuidMapper.map(scanId);
        var saved = repo.getReferenceById(id);
        return mapper.map(saved);
    }

    @Override
    public void deleteScan(String scanId) {
        var id = uuidMapper.map(scanId);
        repo.deleteById(id);
    }

    @Override
    public List<Scan> getScans(BigDecimal page, BigDecimal size) {
        var pageRequest = PageRequest.of(page.intValue(), size.intValue());
        var entities = repo.findAll(pageRequest).getContent();
        return entities.stream().map(mapper::map).toList();
    }
}
