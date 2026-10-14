package com.maadcoding.ubertrip

import org.junit.Assert
import org.junit.Test

class TripPriceTest {
    @Test
    fun calculateTripPrice_luckyTraffic() {
        //Base fare (8) + (km * 7.5) + time
        Assert.assertEquals(103, calculatePrice(10f, 20, 0.0f))
    }

    @Test
    fun calculateTripPrice_safeZoneTraffic() {
        //Base fare (8) + (km * 7.5) + time + (total (103) * 5 / 100)
        Assert.assertEquals(108, calculatePrice(10f, 20, 0.05f))
    }

    @Test
    fun calculateTripPrice_heavyTraffic() {
        //103 + (103 * 10 / 100)
        Assert.assertEquals(113, calculatePrice(10f, 20, 0.1f))
    }

    @Test
    fun calculateTripPrice_zeroKM() {
        //Fixed Price (60)
        Assert.assertEquals(60, calculatePrice(0.6f, 0, 0.1f))
    }
}