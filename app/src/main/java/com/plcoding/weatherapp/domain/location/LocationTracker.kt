package com.plcoding.weatherapp.domain.location

import android.location.Location
import android.provider.CallLog.Locations

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}