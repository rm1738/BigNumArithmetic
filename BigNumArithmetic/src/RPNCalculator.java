
@SuppressWarnings("rawtypes")
public class RPNCalculator extends LinkedList {

    // Takes a linkedlist as a parameter and returns a reversed linkedlist
    public static LinkedList<Integer> reverseLinkedList(
        LinkedList<Integer> n1) {
        LinkedList<Integer> revLinkedList = new LinkedList<Integer>();
        for (int i = n1.size() - 1; i >= 0; i--) {

            // Append the elements in reverse order
            revLinkedList.insert(n1.getObjectAtIndex(i));
        }
        // Return the reversed arraylist
        return revLinkedList;
    }


    public static LinkedList<Integer> add(
        LinkedList<Integer> num1,
        LinkedList<Integer> num2) {

        LinkedList<Integer> result = new LinkedList<Integer>();

        int size1 = num1.size();
        int size2 = num2.size();

        int lSize = size1;

        if (size2 > size1) {
            lSize = size2;
        }

        Integer n1;
        Integer n2;
        Integer r;
        Integer carry = 0;
        boolean carryN = false;
        int i = 0;
        
       

        while (i < lSize) {

            n1 = num1.getObjectAtIndex(i);
            n2 = num2.getObjectAtIndex(i);
            
            if (n1 == null) {

                r = n2 + carry;
                result.insert(r % 10);
                carry = 0;
                
                if(r>=10)
                {
                    carryN = true; 
                }

                if (carryN = true) {
                    carry = (r % 100) / 10;

                    if (i == lSize - 1) {
                        result.insert(carry);
                    }
                }

            }
            else if (n2 == null) {
                r = n1 + carry;
                result.insert(r % 10);
                carry = 0;

                if (r >= 10) {
                    carry = (r % 100) / 10;
                    if (i == lSize - 1) {
                        result.insert(carry);
                    }
                }
            }

            else {

                r = n1 + n2 + carry;

                result.insert(r % 10);
                carry = 0;

                if (r >= 10) {

                    carry = (r % 100) / 10;

                    if (i == lSize - 1) {
                        result.insert(carry);
                    }
                }
            }
            i++;

        }
        return result;

    }


    public static LinkedList<Integer> multi(
        LinkedList<Integer> n1,
        LinkedList<Integer> n2) {

        LinkedList<Integer> result = new LinkedList<Integer>();
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        LinkedList<Integer>.Node<Integer> first = n1.head();
        LinkedList<Integer>.Node<Integer> second = n2.head();

        while (first.next() != null || second.next() != null) {

            if (n1 != null) {
                num1 = num1 * 10 + first.getData();
                first = first.next();

            }

            if (n2 != null) {

                num2 = num2 * 10 + second.getData();
                second = second.next();

            }

            res = num1 * num2;
            result.insert(res % 10);
            res = res / 10;

        }
        return result;

    }

}
