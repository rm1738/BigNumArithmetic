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
    
    
    public void testAdd()
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
       l3 = RPN.reverseLinkedList(list);
       
       
        assertTrue(list.equals(l3));
        
    }
    
    
    
    
    
    
    
    

}
