```java
package com.thealgorithms.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AllPathsFromSourceToTargetTest {

    @Mock
    private AllPathsFromSourceToTarget allPathsFromSourceToTarget;

    @BeforeEach
    void setup() {
        allPathsFromSourceToTarget = new AllPathsFromSourceToTarget(5);
    }

    @Test
    void testStoreAllPaths_SimplePath() {
        // Given
        allPathsFromSourceToTarget.addEdge(0, 1);
        allPathsFromSourceToTarget.addEdge(1, 2);
        allPathsFromSourceToTarget.addEdge(2, 3);

        // When
        allPathsFromSourceToTarget.storeAllPaths(0, 3);

        // Then
        assertEquals(1, allPathsFromSourceToTarget.nm.size());
        assertEquals(List.of(0, 1, 2, 3), allPathsFromSourceToTarget.nm.get(0));
    }

    @Test
    void testStoreAllPaths_NoPath() {
        // Given
        allPathsFromSourceToTarget.addEdge(0, 1);
        allPathsFromSourceToTarget.addEdge(1, 2);

        // When
        allPathsFromSourceToTarget.storeAllPaths(0, 3);

        // Then
        assertEquals(0, allPathsFromSourceToTarget.nm.size());
    }

    @Test
    void testStoreAllPaths_NullSource() {
        // Given
        allPathsFromSourceToTarget.addEdge(0, 1);
        allPathsFromSourceToTarget.addEdge(1, 2);

        // When
        assertThrows(NullPointerException.class, () -> allPathsFromSourceToTarget.storeAllPaths(null, 3));

        // Then
        verify(allPathsFromSourceToTarget, never()).storeAllPathsUtil(anyInt(), anyInt(), anyBooleanArray(), anyList());
    }

    @Test
    void testStoreAllPaths_NullDestination() {
        // Given
        allPathsFromSourceToTarget.addEdge(0, 1);
        allPathsFromSourceToTarget.addEdge(1, 2);

        // When
        assertThrows(NullPointerException.class, () -> allPathsFromSourceToTarget.storeAllPaths(0, null));

        // Then
        verify(allPathsFromSourceToTarget, never()).storeAllPathsUtil(anyInt(), anyInt(), anyBooleanArray(), anyList());
    }

    @Test
    void testAllPathsFromSourceToTarget_SimplePath() {
        // Given
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        int source = 0;
        int destination = 3;

        // When
        List<List<Integer>> paths = AllPathsFromSourceToTarget.allPathsFromSourceToTarget(4, edges, source, destination);

        // Then
        assertEquals(1, paths.size());
        assertEquals(List.of(0, 1, 2, 3), paths.get(0));
    }

    @Test
    void testAllPathsFromSourceToTarget_NoPath() {
        // Given
        int[][] edges = {{0, 1}, {1, 2}};
        int source = 0;
        int destination = 3;

        // When
        List<List<Integer>> paths = AllPathsFromSourceToTarget.allPathsFromSourceToTarget(4, edges, source, destination);

        // Then
        assertEquals(0, paths.size());
    }

    @Test
    void testAllPathsFromSourceToTarget_NullEdges() {
        // Given
        int source = 0;
        int destination = 3;

        // When
        assertThrows(NullPointerException.class, () -> AllPathsFromSourceToTarget.allPathsFromSourceToTarget(4, null, source, destination));

        // Then
        verify(allPathsFromSourceToTarget, never()).storeAllPathsUtil(anyInt(), anyInt(), anyBooleanArray(), anyList());
    }

    @Test
    void testAllPathsFromSourceToTarget_NullSource() {
        // Given
        int[][] edges = {{0, 1}, {1, 2}};
        int destination = 3;

        // When
        assertThrows(NullPointerException.class, () -> AllPathsFromSourceToTarget.allPathsFromSourceToTarget(4, edges, null, destination));

        // Then
        verify(allPathsFromSourceToTarget, never()).storeAllPathsUtil(anyInt(), anyInt(), anyBooleanArray(), anyList());
    }

    @Test
    void testAllPathsFromSourceToTarget_NullDestination() {
        // Given
        int[][] edges = {{0, 1}, {1, 2}};
        int source = 0;

        // When
        assertThrows(NullPointerException.class, () -> AllPathsFromSourceToTarget.allPathsFromSourceToTarget(4, edges, source, null));

        // Then
        verify(allPathsFromSourceToTarget, never()).storeAllPathsUtil(anyInt(), anyInt(), anyBooleanArray(), anyList());
    }
}
```