
@SuppressWarnings("rawtypes")
public class RPNCalculator extends LinkedList {

    public static LinkedList<Long> reverseLinkedList(LinkedList<Long> result) {
        LinkedList<Long> revLinkedList = new LinkedList<Long>();
        for (int i = result.size() - 1; i >= 0; i--) {

            revLinkedList.insert(result.getObjectAtIndex(i));
        }

        return revLinkedList;
    }


    public static LinkedList<Long> add(
        LinkedList<Long> list,
        LinkedList<Long> list2) {

        LinkedList<Long> result = new LinkedList<Long>();

        int size1 = list.size();
        int size2 = list2.size();

        int lSize = size1;

        if (size2 > size1) {
            lSize = size2;
        }

        Long n1;
        Long n2;
        Long r;
        Long carry = (long)0;
        boolean carryN = false;
        boolean end = false;
        int i = 0;

        while (i < lSize) {

            n1 = list.getObjectAtIndex(i);
            n2 = list2.getObjectAtIndex(i);

            if (i == lSize - 1) {
                end = true;
            }

            if (n1 == null) {

                r = n2 + carry;
                result.insert(r % 10);
                carry = (long)0;

                if (r >= 10) {
                    carryN = true;
                }

                if (carryN == true) {
                    carry = (r % 100) / 10;

                    if (end == true) {
                        result.insert(carry);
                    }
                }

            }
            else if (n2 == null) {
                r = n1 + carry;
                result.insert(r % 10);
                carry = (long)0;

                if (r >= 10) {
                    carry = (r % 100) / 10;
                    if (end == true) {
                        result.insert(carry);
                    }
                }
            }

            else {

                r = n1 + n2 + carry;

                result.insert(r % 10);
                carry = (long)0;

                if (r >= 10) {

                    carry = (r % 100) / 10;

                    if (end == true) {
                        result.insert(carry);
                    }
                }
            }
            i++;

        }
        return result;

    }


    public static LinkedList<Long> multi(
        LinkedList<Long> n1,
        LinkedList<Long> n2) {

        LinkedList<Long> result = new LinkedList<Long>();
        long num1 = 0;
        long num2 = 0;
        long res = 0;
        long mod = 0;
        LinkedList<Long>.Node<Long> first = n1.head();
        LinkedList<Long>.Node<Long> second = n2.head();

        while (first != null) {

            if (n1 != null) {
                num1 = num1 * 10 + first.getData();
                first = first.next();

            }

        }

        while (second != null)
            if (n2 != null) {

                num2 = num2 * 10 + second.getData();
                second = second.next();
            }

        res = num1 * num2;

        while (res > 0) {
            mod = res % 10;
            result.insert(mod);
            res = res / 10;

        }

        LinkedList<Long> rev = RPNCalculator.reverseLinkedList(result);

        return rev;

    }


    public static LinkedList<Long> exp(
        LinkedList<Long> number,
        LinkedList<Long> power) {

        LinkedList<Long> result = new LinkedList<Long>();

        for (int i = 0; i < power.size(); i++) {
            Long num = power.getObjectAtIndex(i);

            if (num == 0) {
                result.insert((long)1);
            }

            if (num == 1) {
                return number;
            }

            if (num == 2) {

                return multi(number, number);

            }

            if (num % 2 == 0) {
                LinkedList<Long> newNumber1 = multi(number, number);
                num = num / 2;
                LinkedList<Long> newNumber2 = multi(number, number);

                for (int j = 0; i < num - 1; j++) {

                    LinkedList<Long> newNumber3 = multi(newNumber1, newNumber2);
                    result = newNumber3;

                }

                if (num % 2 != 0) {

                    LinkedList<Long> newNumber11 = multi(number, number);
                    num = num - 1 / 2;
                    LinkedList<Long> newNumber21 = multi(number, number);

                    for (int j = 0; i < num - 1; j++) {

                        LinkedList<Long> newNumber3 = multi(newNumber11,
                            newNumber21);
                        result = newNumber3;

                    }

                }

            }

        }
        return result;

    }

}
