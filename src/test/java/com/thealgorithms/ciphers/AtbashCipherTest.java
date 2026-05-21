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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AtbashCipherTest {

    @Mock
    private AtbashCipher atbashCipher;

    @BeforeEach
    void setup() {
        atbashCipher = new AtbashCipher();
    }

    @Test
    void testConvert_EmptyString_ReturnsEmptyString() {
        // Given
        atbashCipher.setString("");

        // When
        String result = atbashCipher.convert();

        // Then
        assertThat(result).isEqualTo("");
    }

    @Test
    void testConvert_NullString_ThrowsNullPointerException() {
        // Given
        atbashCipher.setString(null);

        // When
        // Then
        assertThatThrownBy(atbashCipher::convert).isInstanceOf(NullPointerException.class);
    }

    @Test
    void testConvert_SingleCharacter_ReturnsConvertedCharacter() {
        // Given
        atbashCipher.setString("a");

        // When
        String result = atbashCipher.convert();

        // Then
        assertThat(result).isEqualTo("z");
    }

    @Test
    void testConvert_UpperCaseCharacter_ReturnsConvertedCharacter() {
        // Given
        atbashCipher.setString("A");

        // When
        String result = atbashCipher.convert();

        // Then
        assertThat(result).isEqualTo("Z");
    }

    @Test
    void testConvert_MixedCaseCharacters_ReturnsConvertedCharacters() {
        // Given
        atbashCipher.setString("AbC");

        // When
        String result = atbashCipher.convert();

        // Then
        assertThat(result).isEqualTo("ZyX");
    }

    @Test
    void testConvert_NonAlphabeticCharacters_ReturnsOriginalCharacters() {
        // Given
        atbashCipher.setString("Hello, World!");

        // When
        String result = atbashCipher.convert();

        // Then
        assertThat(result).isEqualTo("Svool, Dliow!");
    }

    @Test
    void testConvert_WholeAlphabet_ReturnsConvertedAlphabet() {
        // Given
        atbashCipher.setString("abcdefghijklmnopqrstuvwxyz");

        // When
        String result = atbashCipher.convert();

        // Then
        assertThat(result).isEqualTo("zyxwvutsrqponmlkjihgfedcba");
    }

    @Test
    void testConvert_WholeAlphabet_UpperCase_ReturnsConvertedAlphabet() {
        // Given
        atbashCipher.setString("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        // When
        String result = atbashCipher.convert();

        // Then
        assertThat(result).isEqualTo("ZYXWVUTSRQPONMLKJIHGFEDCBA");
    }
}
```