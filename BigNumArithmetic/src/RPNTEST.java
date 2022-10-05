import student.TestCase;



public class RPNTEST extends student.TestCase{
    private linkedlist<Integer> list;
    private linkedlist<Integer> list1;
    private linkedlist<Integer> list2;
    private RPN tester;
    
    
    public void setUp()
    {
        list = new linkedlist<Integer>();
        list1 = new linkedlist<Integer>();
        list2 = new linkedlist<Integer>();
        tester = new RPN();
        
        
        
    }
    
    
    public void testReverse()
    {
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list1.insert(5);
        list1.insert(6);
        list1.insert(7);
        list2.insert(4);
        list2.insert(3);
        list2.insert(2);
        linkedlist<Integer> l3 = new linkedlist<Integer>();
        linkedlist<Integer> l4 = new linkedlist<Integer>();
        l3 = tester.reverselinkedlist(list);
        
        // 234 567
        assertTrue(l3.equals(list2));   
        
    }
    /**
     * 
     */
    public void testAdd()
    {
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list1.insert(5);
        list1.insert(6);
        list1.insert(7);
        
        list2 = RPN.add(list, list1);
        
        linkedlist<Integer> list3 = new linkedlist<Integer>();
        list3.insert(7);
        list3.insert(9);
        list3.insert(1);
        list3.insert(1);
        assertTrue(list3.equals(list2));
        
    }
    public void testAdd2()
    {

        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        //2345 //123
        list2 = RPN.add(list, list1);
        linkedlist<Integer> list3 = new linkedlist<Integer>();
        list3.insert(2);
        list3.insert(4);
        list3.insert(6);
        list3.insert(8);
     
        //assertTrue(list3.equals(list2));
        assertEquals(list3, list2);
        
    }
    
    
    
    
    
    
    

}
