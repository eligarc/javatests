package com.eliogrc.javastests.util;


import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeat_string_once() {
        /*assertEquals(StringUtil.repeat("Hola", 3), "HolaHolaHola");
        if (!result2.equals("Hola")) {
            throw new RuntimeException("Error");
        }
        assertEquals(StringUtil.repeat("Hola", 1), "Hola");*/

        Assert.assertEquals("Hola", StringUtil.repeat("Hola", 1));
    }

    /* private static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)) {
            throw new RuntimeException(actual + " is not equal to expected" + expected);
        }
        }*/
    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("HolaHolaHola", StringUtil.repeat("Hola", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("Hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("Hola", -1);
    }

    @Test
    public void repeat_string_negative_times2() {
        Exception exception  = Assert.assertThrows(IllegalArgumentException.class, () -> {
            StringUtil.repeat("hola", -1);
        });

        String expected = "negative times not allowed";

        Assert.assertEquals(expected, exception.getMessage());
    }
}
