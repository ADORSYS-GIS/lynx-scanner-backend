package com.ssegning.lynx.lynxbackend.controller;

import com.ssegning.lynx.lynxbackend.api.ScanApi;
import com.ssegning.lynx.lynxbackend.model.Scan;
import com.ssegning.lynx.lynxbackend.service.ScanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ScanApiImpl implements ScanApi {
    private final ScanService scanService;

    @Override
    public Scan createScan(Scan scan) {
        return scanService.createScan(scan);
    }

    @Override
    public void deleteScan(String scanId) {
        scanService.deleteScan(scanId);
    }

    @Override
    public Scan getScan(String scanId) {
        return scanService.getScan(scanId);
    }

    @Override
    public List<Scan> getScans(Optional<BigDecimal> page, Optional<BigDecimal> size) {
        return scanService.getScans(page.orElse(BigDecimal.ZERO), size.orElse(BigDecimal.TEN));
    }

    @Override
    public Scan updateScan(String scanId, Scan scan) {
        return scanService.updateScan(scanId, scan);
    }
}
