package com.gyuzero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GyuzeroJniTest {

    GyuzeroJni gyuzeroJni = new GyuzeroJni();

    GyuzeroJniTest() throws GyuzeroException {
    }

    @Test
    void 이메일_마스킹() throws GyuzeroException {
        assertEquals("te**@test.com", gyuzeroJni.maskEmail("test@test.com"));
        assertEquals("te*******@gmail.com", gyuzeroJni.maskEmail("test12345@gmail.com"));
        assertEquals("****************", gyuzeroJni.maskEmail("abcdef^gmail.com"));
        assertEquals("******", gyuzeroJni.maskEmail("123456"));
        assertEquals("*******", gyuzeroJni.maskEmail("abcdefg"));
        assertEquals("", gyuzeroJni.maskEmail(null));
        assertEquals("", gyuzeroJni.maskEmail(""));
    }
}