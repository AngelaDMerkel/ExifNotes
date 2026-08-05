/*
 * Exif Notes
 * Copyright (C) 2024  Tommi Hirvonen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.tommihirvonen.exifnotes

import com.tommihirvonen.exifnotes.di.export.apertureValue
import com.tommihirvonen.exifnotes.di.export.shutterSpeedValue
import com.tommihirvonen.exifnotes.di.export.toDecimalOrNull
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ExifToolCommandsBuilderTest {

    @Test
    fun exifValues_followApexFormulas() {
        assertEquals(2.0, apertureValue(2.0), 1e-9)
        assertEquals(7.0, shutterSpeedValue("1/128".toDecimalOrNull()!!), 1e-9)
        assertEquals(-4.0, shutterSpeedValue("16\"".toDecimalOrNull()!!), 1e-9)
        assertEquals(-4.0 / 3, "-1 1/3".toDecimalOrNull()!!, 1e-9)
        assertNull("B".toDecimalOrNull())
    }
}
