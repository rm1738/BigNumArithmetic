import student.TestCase;

public class RPNTEST extends student.TestCase {
    private LinkedList<Long> list;
    private LinkedList<Long> list1;
    private LinkedList<Long> list2;
    private RPNCalculator tester;

    public void setUp() {
        list = new LinkedList<Long>();
        list1 = new LinkedList<Long>();
        list2 = new LinkedList<Long>();
        tester = new RPNCalculator();

    }


    public void testReverse() {
        list.insert((long)2);
        list.insert((long)3);
        list.insert((long)4);

        list1.insert((long)5);
        list1.insert((long)6);
        list1.insert((long)7);

        list2.insert((long)4);
        list2.insert((long)3);
        list2.insert((long)2);

        LinkedList<Long> l3 = new LinkedList<Long>();
        l3 =  RPNCalculator.reverseLinkedList(list);

        assertTrue(list2.equals(l3));

    }


    public void testinsert() {

        list.insert((long)1);
        list.insert((long)2);
        list.insert((long)6);
        list.insert((long)1);
        list2.insert((long)9);
        list2.insert((long)9);
        list2.insert((long)9);
        LinkedList<Long> result2 = new LinkedList<Long>();
        result2.insert((long)0);
        result2.insert((long)2);
        result2.insert((long)6);
        result2.insert((long)2);
        assertEquals(result2, RPNCalculator.add(list, list2));

    }


    public void testadd2() {
        list.insert((long)1);
        list.insert((long)2);
        list.insert((long)3);
        list.insert((long)4);

        list1.insert((long)1);
        list1.insert((long)2);
        list1.insert((long)3);

        list2.insert((long)2);
        list2.insert((long)4);
        list2.insert((long)6);
        list2.insert((long)4);

        assertEquals(list2, RPNCalculator.add(list, list1));
    }


    public void testMulti() {

        list.insert((long)7);
        list.insert((long)7);
        list.insert((long)0);
        list.insert((long)0);
        list.insert((long)0);

        list1.insert((long)8);
        list1.insert((long)0);
        list1.insert((long)0);
        list1.insert((long)0);
        list1.insert((long)0);

        list2.insert((long)6);
        list2.insert((long)1);
        list2.insert((long)6);
        list2.insert((long)0);
        list2.insert((long)0);
        list2.insert((long)0);
        list2.insert((long)0);
        list2.insert((long)0);
        list2.insert((long)0);
        list2.insert((long)0);
        System.out.println(RPNCalculator.multi(list, list1));

        assertEquals(list2, RPNCalculator.multi(list, list1));

    }


    public void testMulti2() {

        list.insert((long)2);
        list.insert((long)0);
        list.insert((long)0);

        list1.insert((long)3);
        list1.insert((long)0);
        list1.insert((long)0);

        list2.insert((long)6);
        list2.insert((long)0);
        list2.insert((long)0);
        list2.insert((long)0);
        list2.insert((long)0);

        assertEquals(list2, RPNCalculator.multi(list, list1));

    }

}
