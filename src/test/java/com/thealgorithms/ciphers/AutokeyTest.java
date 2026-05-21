```java
package com.thealgorithms.ciphers;


import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AutokeyTest {

    @Mock
    private Autokey autokey;

    @BeforeEach
    void setup() {
        autokey = new Autokey();
    }

    @Test
    void testEncrypt_EmptyKeyword_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> autokey.encrypt("HELLO", ""));
    }

    @Test
    void testEncrypt_NullKeyword_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> autokey.encrypt("HELLO", null));
    }

    @Test
    void testEncrypt_EmptyPlaintext_ReturnsEmptyString() {
        assertEquals("", autokey.encrypt("", "KEY"));
    }

    @Test
    void testEncrypt_SingleCharacterPlaintext_ReturnsSingleCharacterCiphertext() {
        assertEquals("A", autokey.encrypt("A", "KEY"));
    }

    @Test
    void testEncrypt_PlaintextWithSpaces_ReturnsCiphertextWithoutSpaces() {
        assertEquals("KHOOR", autokey.encrypt("HELLO", "KEY"));
    }

    @Test
    void testEncrypt_PlaintextWithNonAlphabeticCharacters_ReturnsCiphertextWithoutNonAlphabeticCharacters() {
        assertEquals("KHOOR", autokey.encrypt("HELLO123", "KEY"));
    }

    @Test
    void testDecrypt_EmptyKeyword_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> autokey.decrypt("HELLO", ""));
    }

    @Test
    void testDecrypt_NullKeyword_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> autokey.decrypt("HELLO", null));
    }

    @Test
    void testDecrypt_EmptyCiphertext_ReturnsEmptyString() {
        assertEquals("", autokey.decrypt("", "KEY"));
    }

    @Test
    void testDecrypt_SingleCharacterCiphertext_ReturnsSingleCharacterPlaintext() {
        assertEquals("A", autokey.decrypt("A", "KEY"));
    }

    @Test
    void testDecrypt_CiphertextWithSpaces_ReturnsPlaintextWithoutSpaces() {
        assertEquals("HELLO", autokey.decrypt("KHOOR", "KEY"));
    }

    @Test
    void testDecrypt_CiphertextWithNonAlphabeticCharacters_ReturnsPlaintextWithoutNonAlphabeticCharacters() {
        assertEquals("HELLO", autokey.decrypt("KHOOR123", "KEY"));
    }
}
```