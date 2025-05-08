package com.ebueno.filecomparator.v1.functions;

import java.text.DecimalFormat;

public class MemoryFunctions {

	private static final long KILO = 1024;
	private static final long MEGA = KILO * 1024;
	private static final long GIGA = MEGA * 1024;

	private static final DecimalFormat df = new DecimalFormat("#.##");

	public static String formatBytes(long bytes) {
		if (bytes >= GIGA) {
			return df.format((double) bytes / GIGA) + " GB";
		} else if (bytes >= MEGA) {
			return df.format((double) bytes / MEGA) + " MB";
		} else if (bytes >= KILO) {
			return df.format((double) bytes / KILO) + " KB";
		} else {
			return bytes + " Bytes";
		}
	}

}
