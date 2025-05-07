package com.ebueno.filecomparator.v1.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebueno.filecomparator.v1.util.URLEndpoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "File Controller", description = "Controller for file operations")
@RestController
@RequestMapping(URLEndpoints.URL_FILES)
public class FileController {
	
	@Operation(summary = "Get files", description = "Retrieve files based on the provided parameters")
	@GetMapping
	public String getFiles() {
		return LocalDate.now().toString();
	}
	
}
