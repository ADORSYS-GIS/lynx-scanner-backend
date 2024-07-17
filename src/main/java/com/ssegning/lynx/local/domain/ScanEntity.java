package com.ssegning.lynx.local.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Map;
import java.util.UUID;

@Data
@Entity
@Table(name = "scans")
public class ScanEntity {

    @Id
    @Column
    private UUID id;

    @Column(name = "created_at")
    @CreatedDate
    private String createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private String updatedAt;

    @Column(name = "title")
    private String title;

    @ElementCollection
    @CollectionTable(name = "scan_meta_data", joinColumns = @JoinColumn(name = "scan_id"))
    private Map<String, String> metaData;
}
