package com.dimowner.audiorecorder.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.os.Build;

import androidx.core.app.ServiceCompat;

/** Helpers for Android 12-16 behaviour changes. */
public final class PlatformCompat {

	private PlatformCompat() {
	}

	/** Flags for every PendingIntent (mutability flag is mandatory since API 31). */
	public static final int PENDING_INTENT_FLAGS = PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT;

	/**
	 * READ/WRITE_EXTERNAL_STORAGE are declared with maxSdkVersion=28; on newer versions they can never be
	 * granted, so asking for them would block the feature forever.
	 */
	public static boolean needsLegacyStoragePermission() {
		return needsLegacyStoragePermission(Build.VERSION.SDK_INT);
	}

	static boolean needsLegacyStoragePermission(int sdkInt) {
		return sdkInt >= Build.VERSION_CODES.M && sdkInt <= Build.VERSION_CODES.P;
	}

	/** startForeground with an explicit type (required when targeting API 34+). */
	public static void startForeground(Service service, int id, Notification notification, int type) {
		ServiceCompat.startForeground(service, id, notification, type);
	}
}
