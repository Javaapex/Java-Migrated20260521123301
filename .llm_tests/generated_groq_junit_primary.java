```java
package com.thealgorithms.audiofilters;


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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EMAFilterTest {

    @Mock
    private EMAFilter emaFilter;

    @BeforeEach
    public void setup() {
        emaFilter = new EMAFilter(0.5);
    }

    @Test
    public void testApply_EmptyArray_ReturnsEmptyArray() {
        double[] audioSignal = new double[0];
        double[] result = emaFilter.apply(audioSignal);
        assertArrayEquals(new double[0], result);
    }

    @Test
    public void testApply_NullArray_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> emaFilter.apply(null));
    }

    @Test
    public void testApply_SingleElementArray_ReturnsSingleElementArray() {
        double[] audioSignal = new double[] {1.0};
        double[] result = emaFilter.apply(audioSignal);
        assertArrayEquals(new double[] {1.0}, result);
    }

    @Test
    public void testApply_MultipleElementArray_ReturnsSmoothedArray() {
        double[] audioSignal = new double[] {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] result = emaFilter.apply(audioSignal);
        assertArrayEquals(new double[] {1.0, 1.5, 2.25, 3.0, 3.75}, result, 0.01);
    }

    @Test
    public void testApply_AlphaZero_ReturnsOriginalArray() {
        double[] audioSignal = new double[] {1.0, 2.0, 3.0, 4.0, 5.0};
        emaFilter = new EMAFilter(0.0);
        double[] result = emaFilter.apply(audioSignal);
        assertArrayEquals(audioSignal, result);
    }

    @Test
    public void testApply_AlphaOne_ReturnsSingleElementArray() {
        double[] audioSignal = new double[] {1.0, 2.0, 3.0, 4.0, 5.0};
        emaFilter = new EMAFilter(1.0);
        double[] result = emaFilter.apply(audioSignal);
        assertArrayEquals(new double[] {1.0}, result);
    }
}
```