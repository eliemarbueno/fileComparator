package com.ebueno.filecomparator.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebueno.filecomparator.v1.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, String> {
    
}
