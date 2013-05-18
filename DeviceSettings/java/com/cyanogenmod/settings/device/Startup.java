/*
 * Copyright (c) 2013, Rudolf Tammekivi.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 and
 * only version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 */

package com.cyanogenmod.settings.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Startup extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        restore(context);
    }

    /**
     * Restore the settings.
     */
    public static void restore(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean value;

        /**
         * No need to write the host setting when the default value is set (peripheral).
         */
        value = prefs.getBoolean(DeviceSettings.USB_MODE_STATE, false);
        if (value)
            USBSettings.writeMode(value);

        value = prefs.getBoolean(DeviceSettings.AUDIO_INTERNALMIC_STATE, false);
        AudioSettings.writeInternalmicForced(value);
    }
}
