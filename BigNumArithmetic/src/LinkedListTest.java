import java.util.NoSuchElementException;
import student.TestCase;

@SuppressWarnings("unused")
public class LinkedListTest extends TestCase {

    private linkedlist<Integer> list;

    /**
     * Initializes test objects.
     */
    public void setUp() {
        list = new linkedlist<Integer>();
    }


    /**
     * Tests the add method. Ensures that it adds the object is added
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.insert(1);
        assertEquals(1, list.size());
        list.insert(2);
        assertEquals(2, list.size());
        // assertEquals("B", list.get(1));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.insert(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.exists(1));
        list.insert(1);
        assertTrue(list.exists(1));
        assertFalse(list.exists(2));
        list.insert(2);
        assertTrue(list.exists(2));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.insert(1);
        assertFalse(list.isEmpty());
    }


    public void testGetObjectAtIndex() {
        
       list.insert(1);
       assertEquals(0,list.getObjectAtIndex(0));

    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.insert(1);
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.exists(1));
    }


    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("{}", list.toString());
        list.insert(1);
        assertEquals("{1}", list.toString());
        list.insert(2);
        assertEquals("{1, 2}", list.toString());
    }

}
