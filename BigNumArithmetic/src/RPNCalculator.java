
public class RPNCalculator extends LinkedList {
//
// public LinkedList<Integer> reverseList(LinkedList<Integer> head) {
// LinkedList<Integer> last = null;
// while (head != null) {
// // keep the next node
// LinkedList<Integer> tmp = head.next;
// // reverse the link
// head.next = last;
// // update the last node and the current node
// last = head;
// head = tmp;
// }
// return last;
// }

    @SuppressWarnings("unused")
    public static LinkedList<Integer> addition(
        LinkedList<Integer> n1,
        LinkedList<Integer> n2) {

        LinkedList<Integer> result = new LinkedList<Integer>();

        int sizeA = n1.size();
        int sizeB = n2.size();

        int lSize = n1.size();
        int sum = 0;
        int carry = 0;

        if (n2.size() > n1.size()) {
            lSize = n2.size();
        }

        int number1;
        int number2;
        int i = 0;
        while (i < lSize) {

            number1 = n1.getObjectAtIndex(i);
            number2 = n2.getObjectAtIndex(i);

            if (n1 == null) {
                sum = number2 + carry;
                result.insert(sum % 10);
                carry = 0;

            }

            else if (n2 == null) {

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

        }
        return result;

    }

}
