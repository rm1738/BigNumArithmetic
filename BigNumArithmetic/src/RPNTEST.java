import student.TestCase;

public class RPNTEST extends student.TestCase {
    private LinkedList<Integer> list;
    private LinkedList<Integer> list1;
    private LinkedList<Integer> list2;
    @SuppressWarnings("unused")
    private RPNCalculator tester;

    public void setUp() {
        list = new LinkedList<Integer>();
        list1 = new LinkedList<Integer>();
        list2 = new LinkedList<Integer>();
        tester = new RPNCalculator();

    }


    public void testReverse() {
        list.insert((Integer)2);
        list.insert((Integer)3);
        list.insert((Integer)4);

        list1.insert((Integer)5);
        list1.insert((Integer)6);
        list1.insert((Integer)7);

        list2.insert((Integer)4);
        list2.insert((Integer)3);
        list2.insert((Integer)2);

        LinkedList<Integer> l3 = new LinkedList<Integer>();
        l3 = RPNCalculator.reverseLinkedList(list);

        assertTrue(list2.equals(l3));

    }


    public void testinsert() {

        list.insert((Integer)1);
        list.insert((Integer)2);
        list.insert((Integer)6);
        list.insert((Integer)1);
        list2.insert((Integer)9);
        list2.insert((Integer)9);
        list2.insert((Integer)9);
        LinkedList<Integer> result2 = new LinkedList<Integer>();
        result2.insert((Integer)0);
        result2.insert((Integer)2);
        result2.insert((Integer)6);
        result2.insert((Integer)2);
        assertEquals(result2, RPNCalculator.add(list, list2));

    }


    public void testadd2() {
        list.insert((Integer)1);
        list.insert((Integer)2);
        list.insert((Integer)3);
        list.insert((Integer)4);

        list1.insert((Integer)1);
        list1.insert((Integer)2);
        list1.insert((Integer)3);

        list2.insert((Integer)2);
        list2.insert((Integer)4);
        list2.insert((Integer)6);
        list2.insert((Integer)4);

        assertEquals(list2, RPNCalculator.add(list, list1));
    }


    public void testMulti() {

        list.insert((Integer)7);
        list.insert((Integer)7);
        list.insert((Integer)0);
        list.insert((Integer)0);
        list.insert((Integer)0);

        list1.insert((Integer)8);
        list1.insert((Integer)0);
        list1.insert((Integer)0);
        list1.insert((Integer)0);
        list1.insert((Integer)0);

        list2.insert((Integer)6);
        list2.insert((Integer)1);
        list2.insert((Integer)6);
        list2.insert((Integer)0);
        list2.insert((Integer)0);
        list2.insert((Integer)0);
        list2.insert((Integer)0);
        list2.insert((Integer)0);
        list2.insert((Integer)0);
        list2.insert((Integer)0);
        System.out.println(RPNCalculator.multiply(list, list1));

        assertEquals(list2, RPNCalculator.multiply(list, list1));

    }


    public void testMulti2() {

        list.insert((Integer)2);
        list.insert((Integer)0);
        list.insert((Integer)0);

        list1.insert((Integer)3);
        list1.insert((Integer)0);
        list1.insert((Integer)0);

        list2.insert((Integer)6);
        list2.insert((Integer)0);
        list2.insert((Integer)0);
        list2.insert((Integer)0);
        list2.insert((Integer)0);

        assertEquals(list2, RPNCalculator.multiply(list, list1));

    }


    public void testExponent() {

        list.insert((Integer)2);
        list1.insert((Integer)3);

        list2.insert((Integer)8);
   
       

        assertEquals(list2, RPNCalculator.exponentiate(list, list1));

    }


    public void testExponent2() {

        // 0 case
        list.insert((Integer)2);
        list.insert((Integer)2);
        list1.insert((Integer)0);
        list2.insert((Integer)1);

        assertEquals(list2, RPNCalculator.exponentiate(list, list1));

    }
    
    
    

}
