/**
 * @author Fikir Demeke
 * @date November 11 2025
 */

package org.howard.edu.lsp.assignment6; 

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for IntegerSet class.
 */
public class IntegerSetTest {

    @Test
    public void testAddAndToString() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2);  // duplicate ignored
        assertEquals("[1, 2]", set.toString());
    }

    @Test
    public void testClearAndIsEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);
        assertEquals(2, set.length());
    }

    @Test
    public void testEqualsTrueAndFalse() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); b.add(2); b.add(1);
        assertTrue(a.equals(b));
        b.add(3);
        assertFalse(a.equals(b));
    }

    @Test
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        assertTrue(set.contains(4));
        assertFalse(set.contains(7));
    }

    @Test
    public void testLargestAndSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(9); set.add(5);
        assertEquals(9, set.largest());
        assertEquals(1, set.smallest());
    }

    @Test
    public void testLargestAndSmallestException() {
        IntegerSet empty = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> empty.largest());
        assertThrows(IllegalStateException.class, () -> empty.smallest());
    }

    @Test
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(4);
        set.remove(3);
        assertFalse(set.contains(3));
    }

    @Test
    public void testUnion() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(3);
        a.union(b);
        assertEquals("[1, 2, 3]", a.toString());
    }

    @Test
    public void testIntersect() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2); b.add(3); b.add(4);
        a.intersect(b);
        assertEquals("[2, 3]", a.toString());
    }

    @Test
    public void testDiff() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2);
        a.diff(b);
        assertEquals("[1, 3]", a.toString());
    }

    @Test
    public void testComplement() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(3);
        a.complement(b);
        assertEquals("[3]", a.toString());
    }
    
    @Test
    public void testLargestThrowsException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, set::largest);
    }

    @Test
    public void testSmallestThrowsException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, set::smallest);
    }

}
