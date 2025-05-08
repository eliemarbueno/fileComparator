package com.ebueno.filecomparator.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.ebueno.filecomparator.v1.functions.MemoryFunctions;
import com.ebueno.filecomparator.v1.repository.FileRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileComparatorHealthIndicator implements HealthIndicator{

	@Autowired
	FileRepository repository;

	@Override
	public Health health() {
		
		long freeMemory = Runtime.getRuntime().freeMemory();
		long totalMemory = Runtime.getRuntime().totalMemory();
		double freeMemoryPercent = ((double) freeMemory / (double) totalMemory) * 100;
		
		if(freeMemoryPercent > 25){
			// @formatter:off
			return Health.up()
				.withDetail("free_memory", MemoryFunctions.formatBytes(freeMemory)  + " (" + freeMemory + " bytes)")
				.withDetail("fotal_memory", MemoryFunctions.formatBytes(totalMemory)  + " (" + totalMemory + " bytes)")
				.withDetail("free_memory_percent", String.format("%.2f", freeMemoryPercent)  +  " %")
				.build();		
			// @formatter:on
		} else {
			// @formatter:off
			return Health.up()
				.withDetail("free_memory", freeMemory + " bytes")
				.withDetail("fotal_memory", totalMemory + " bytes")
				.withDetail("free_memory_percent", freeMemoryPercent + "%")
				.build();		
			// @formatter:on
		}
	}	
}
