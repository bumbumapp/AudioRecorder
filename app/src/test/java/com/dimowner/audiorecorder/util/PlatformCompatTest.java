package com.dimowner.audiorecorder.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlatformCompatTest {
	@Test
	public void legacyStoragePermissionOnlyUpToApi28() {
		assertTrue(PlatformCompat.needsLegacyStoragePermission(23));
		assertTrue(PlatformCompat.needsLegacyStoragePermission(28));
		// Regression: on 29+ the permission is never granted (maxSdkVersion=28) and blocked playback/download.
		assertFalse(PlatformCompat.needsLegacyStoragePermission(29));
		assertFalse(PlatformCompat.needsLegacyStoragePermission(35));
	}
}
