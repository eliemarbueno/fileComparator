package com.ebueno.filecomparator.v1.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "file_bean")
public class FileEntity {
    @Id
    @Column(name = "file_key", length = 512)
    private String fileKey;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "file_hash", length = 64)
    private String fileHash;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @Column(name = "is_priority", nullable = false)
    private boolean priority = false;

    @Column(name = "source_id", length = 100)
    private String sourceId;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "logical_path")
    private String logical_path;
}
