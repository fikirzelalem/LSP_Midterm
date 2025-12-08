/**
 * @author Fikir Demeke
 * @date November 11 2025
 *
 * This is a JUnit 5 test class for the IntegerSet class.
 * Each test method verifies one or more public methods from the IntegerSet
 * implementation to ensure correct behavior for normal and edge cases.
 */
 */

package org.howard.edu.lsp.assignment6; 

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for IntegerSet class. Provides unit tests for every public method in the IntegerSet class.
 */

public class IntegerSetTest {

	/**
     * Verifies that add() prevents duplicates and that toString() 
     * returns a properly formatted representation.
     */
    @Test
    public void testAddAndToString() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2);  // duplicate ignored
        assertEquals("[1, 2]", set.toString());
    }
    
    /**
     * Ensures that clear() removes all elements and that isEmpty() returns true afterward.
     */

    @Test
    public void testClearAndIsEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.clear();
        assertTrue(set.isEmpty());
    }
    
    /**
     * Checks that length() correctly reports the number of unique elements.
     */

    @Test
    public void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);
        assertEquals(2, set.length());
    }
    
    /**
     * Validates equals() for both equal and non-equal sets.
     */

    @Test
    public void testEqualsTrueAndFalse() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); b.add(2); b.add(1);
        assertTrue(a.equals(b));
        b.add(3);
        assertFalse(a.equals(b));
    }
    
    /**
     * Tests contains() for both existing and missing elements.
     */

    @Test
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        assertTrue(set.contains(4));
        assertFalse(set.contains(7));
    }
    
    /**
     * Ensures largest() and smallest() return correct values for a non-empty set.
     */

    @Test
    public void testLargestAndSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(9); set.add(5);
        assertEquals(9, set.largest());
        assertEquals(1, set.smallest());
    }

    /**
     * Makes sure that largest() and smallest() throw exceptions when the set is empty.
     */
    
    @Test
    public void testLargestAndSmallestException() {
        IntegerSet empty = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> empty.largest());
        assertThrows(IllegalStateException.class, () -> empty.smallest());
    }
    
    /**
     * Tests remove() to ensure it correctly deletes elements.
     */

    @Test
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(4);
        set.remove(3);
        assertFalse(set.contains(3));
    }

    
    /**
     * Validates union() to ensure combined sets contain all unique elements.
     */
    
    @Test
    public void testUnion() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(3);
        a.union(b);
        assertEquals("[1, 2, 3]", a.toString());
    }
    
    /**
     * Confirms intersect() keeps only elements present in both sets.
     */

    @Test
    public void testIntersect() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2); b.add(3); b.add(4);
        a.intersect(b);
        assertEquals("[2, 3]", a.toString());
    }
    
    /**
     * Checks diff() removes all elements found in the other set.
     */

    @Test
    public void testDiff() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2);
        a.diff(b);
        assertEquals("[1, 3]", a.toString());
    }

    /**
     * Validates complement() to ensure this set becomes elements in the other but not in this.
     */
    
    @Test
    public void testComplement() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(3);
        a.complement(b);
        assertEquals("[3]", a.toString());
    }
    
    /**
     * Ensures largest() throws IllegalStateException for an empty set.
     */

    
    @Test
    public void testLargestThrowsException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, set::largest);
    }
    
    /**
     * Ensures smallest() throws IllegalStateException for an empty set.
     */

    @Test
    public void testSmallestThrowsException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, set::smallest);
    }

}
