package com.ssegning.lynx.local.repo;

import com.ssegning.lynx.local.domain.ScanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScanRepo extends JpaRepository<ScanEntity, UUID> {
}
