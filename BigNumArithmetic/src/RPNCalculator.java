
@SuppressWarnings("rawtypes")
public class RPNCalculator extends LinkedList {

    // Takes a linkedlist as a parameter and returns a reversed linkedlist
    public static LinkedList<Integer> reverseLinkedList(
        LinkedList<Integer> n1) {
        LinkedList<Integer> revLinkedList = new LinkedList<Integer>();
        for (int i = n1.size() - 1; i >= 0; i--) {

            // Append the elements in reverse order
            revLinkedList.insert(n1.get(i));
        }
        // Return the reversed arraylist
        return revLinkedList;
    }


    @SuppressWarnings("unused")
    public static LinkedList<Integer> addition(
        LinkedList<Integer> n1,
        LinkedList<Integer> n2) {

        LinkedList<Integer> p1 = reverseLinkedList(n1);
        LinkedList<Integer> p2 = reverseLinkedList(n2);
        LinkedList<Integer> result = new LinkedList<Integer>();

        int sizeA = p1.size();
        int sizeB = p2.size();
        int lSize = p1.size();
        int sum = 0;
        int carry = 0;

        if (p2.size() > p1.size()) {
            lSize = p2.size();
        }
        int number1;
        int number2;
        int i = 0;
        while (i < lSize) {
            number1 = p1.getObjectAtIndex(i);
            number2 = p2.getObjectAtIndex(i);

            if (p1 == null) {
                sum = number2 + carry;
                result.insert(sum % 10);
                carry = 0;

            }
            else if (p2 == null) {
                sum = number1 + carry;
                result.insert(sum % 10);
                carry = 0;
            }
            else {
                sum = number1 + number2 + carry;
                result.insert(sum % 10);
                carry = 0;
            }

            if (sum >= 10) {
                carry = (sum % 100) / 10;
            }
            if (i == lSize - 1) {
                result.insert(carry);
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
