package com.eliogrc.javastests.util;

import org.junit.Test;

import static com.eliogrc.javastests.util.PasswordUtil.SecurityLevel.MEDIUM;
import static com.eliogrc.javastests.util.PasswordUtil.SecurityLevel.STRONG;
import static com.eliogrc.javastests.util.PasswordUtil.SecurityLevel.WEAK;
import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("12aa!!"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefghijklm"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcde12345"));
    }

    @Test
    public void strong_when_has_letters_numbers_symbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abcde12345!"));
    }
}