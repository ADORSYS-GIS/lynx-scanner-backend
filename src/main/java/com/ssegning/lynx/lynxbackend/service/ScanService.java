package com.ssegning.lynx.lynxbackend.service;

import com.ssegning.lynx.lynxbackend.model.Scan;

import java.math.BigDecimal;
import java.util.List;

public interface ScanService {
    Scan createScan(Scan scan);

    Scan updateScan(String scanId, Scan scan);

    Scan getScan(String scanId);

    void deleteScan(String scanId);

    List<Scan> getScans(BigDecimal page, BigDecimal size);
}
