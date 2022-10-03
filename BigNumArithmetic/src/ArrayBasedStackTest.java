
import java.util.EmptyStackException;
import student.TestCase;

/**
 * Array Based Stack Test
 * 
 * @author Rahul Menon (rahulmenon)
 * @version 2022.02.21
 */

public class ArrayBasedStackTest extends TestCase {
    // ~ Fields ................................................................
    private ArrayBasedStack<String> arr;
    private ArrayBasedStack<String> arr2;
    private ArrayBasedStack<String> arrL;

    /**
     * set up
     */

    public void setUp() {
        arr = new ArrayBasedStack<String>();
        arr2 = new ArrayBasedStack<String>(3);
        arrL = new ArrayBasedStack<String>();
        arrL.push("1");
        arrL.push("2");
        arrL.push("3");
        arrL.push("4");

    }


    /**
     * test
     */
    public void testPeekException() {
        ArrayBasedStack<String> arr0 = new ArrayBasedStack<String>(4);
        Exception thrown = null;
        try {
            // call your method here that will throw the exception
            arr0.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * test
     */
    public void testPopException() {
        ArrayBasedStack<String> arr20 = new ArrayBasedStack<String>(4);
        Exception thrown = null;
        try {
            // call your method here that will throw the exception
            arr20.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * test
     */

    public void testisEmpty() {
        ArrayBasedStack<String> arr3 = new ArrayBasedStack<String>(4);
        assertTrue(arr3.isEmpty());
        arr3.push("p");
        assertFalse(arr3.isEmpty());

    }


    /**
     * test 1
     */

    public void testPush() {
        arr.push("p");
        arr.push("u");
        arr.push("s");
        arr.push("h");
        arr.push("i");
        arr.push("n");
        arr.push("p");
        assertEquals("p", arr.peek());
        assertEquals(7, arr.size());

    }


    /**
     * test 2
     */

    public void testPushExpand() {
        ArrayBasedStack<String> arr3 = new ArrayBasedStack<String>(7);
        arr3.push("p");
        arr3.push("u");
        arr3.push("s");
        arr3.push("h");
        arr3.push("i");
        arr3.push("n");
        arr3.push("p");
        assertEquals(7, arr3.size());

        arr3.push("!");
        assertEquals(8, arr3.size());

    }


    /**
     * test 3
     */
    public void testContains() {
        arr.push("p");
        assertTrue(arr.contains("p"));
        assertFalse(arr.contains("u"));
    }


    /**
     * test 4
     */
    public void testClear() {
        arr2.push("a");
        assertTrue(arr2.contains("a"));
        arr2.clear();
        assertFalse(arr2.contains("a"));
        assertEquals(0, arr2.size());

    }


    /**
     * test 5
     */
    public void testSize() {
        ArrayBasedStack<String> arr4 = new ArrayBasedStack<String>(3);
        arr4.push("a");
        assertEquals(1, arr4.size());
    }


    /**
     * test 6
     */
    public void testToArray() {

        int arraySize = arr2.toArray().length;
        assertEquals(0, arraySize);

    }


    /**
     * test 7
     */
    public void testToString() {

        ArrayBasedStack<String> arr7 = new ArrayBasedStack<String>(3);
        assertEquals("[]", arr7.toString());
        assertEquals("[1, 2, 3, 4]", arrL.toString());
    }


    /**
     * test 8
     */
    public void testEqualsA()

    {
        ArrayBasedStack<String> arrA = new ArrayBasedStack<String>(3);
        assertTrue(arrA.equals(arrA));

    }


    /**
     * test 9
     */
    public void testEqualsB()

    {
        ArrayBasedStack<String> arrB = new ArrayBasedStack<String>(3);
        arrB.push("a");
        ArrayBasedStack<String> arrC = new ArrayBasedStack<String>(5);
        arrC.push("p");
        arrC.push("c");
        assertFalse(arrB.equals(arrC));
        assertEquals(1, arrB.size());
        assertEquals(2, arrC.size());

    }


    /**
     * test 10
     */

    public void testEqualsC() {
        Object nuLL = null;
        assertFalse(arr.equals(nuLL));

    }


    /**
     * test 11
     */

    public void testEqualsD() {

        ArrayBasedStack<String> arrC = new ArrayBasedStack<String>(3);
        arrC.push("a");
        arrC.push("b");
        ArrayBasedStack<String> arrD = new ArrayBasedStack<String>(3);
        arrD.push("p");
        arrD.push("c");
        assertFalse(arrC.equals(arrD));
        assertEquals(2, arrD.size());
        assertEquals(2, arrC.size());

    }


    /**
     * test 11
     */

    public void testEqualsE() {

        ArrayBasedStack<String> arrC = new ArrayBasedStack<String>(3);
        arrC.push("a");
        arrC.push("b");
        ArrayBasedStack<String> arrD = new ArrayBasedStack<String>(3);
        arrD.push("a");
        arrD.push("b");
        assertTrue(arrC.equals(arrD));

    }


    /**
     * test 12
     */

    public void testEqualsF() {

        ArrayBasedStack<String> arrC = new ArrayBasedStack<String>(3);
        arrC.push("b");
        arrC.push("a");

        ArrayBasedStack<String> arrD = new ArrayBasedStack<String>(3);
        arrD.push("a");
        arrD.push("b");
        assertFalse(arrC.equals(arrD));

    }


    /**
     * test 13
     */

    public void testEqualsG() {

        ArrayBasedStack<String> arrC = new ArrayBasedStack<String>(3);
        arrC.push("b");
        arrC.push("a");
        String hello = "hi";
        assertFalse(arrC.equals(hello));
    }

}
