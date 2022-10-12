@SuppressWarnings("rawtypes")
public class RPNCalculator extends LinkedList {

    public static LinkedList<Integer> reverseLinkedList(
        LinkedList<Integer> l3) {
        LinkedList<Integer> revLinkedList = new LinkedList<Integer>();
        for (int i = l3.size() - 1; i >= 0; i--) {

            revLinkedList.insert(l3.getObjectAtIndex(i));
        }

        return revLinkedList;
    }


    public static LinkedList<Integer> add(
        LinkedList<Integer> list,
        LinkedList<Integer> list2) {

        LinkedList<Integer> result = new LinkedList<Integer>();

        int size1 = list.size();
        int size2 = list2.size();

        int lSize = size1;

        if (size2 > size1) {
            lSize = size2;
        }

        Integer n1;
        Integer n2;
        Integer r;
        Integer carry = 0;
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
                carry = 0;

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
                carry = 0;

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
                carry = 0;

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


    public static LinkedList<Integer> multiply(
        LinkedList<Integer> list1,
        LinkedList<Integer> list2) {
        // adds extra 0s to the end of the shorter list for easier
        // multiplication and addition
        if (list1.size() > list2.size()) {
            int diff = list1.size() - list2.size();
            for (int i = 0; i < diff; i++) {
                list2.insert(0);
            }
        }
        else if (list1.size() < list2.size()) {
            int diff = list2.size() - list1.size();
            for (int i = 0; i < diff; i++) {
                list1.insert(0);
            }
        }

        LinkedList<Integer> sum1 = new LinkedList<Integer>();
        LinkedList<Integer> sum2 = new LinkedList<Integer>();
        LinkedList<Integer> totalSum = new LinkedList<Integer>();
        int currSum;
        int carry = 0;
        for (int i = 0; i < list1.size(); i++) {
            totalSum.clear();
            LinkedList<Integer> currSumList = new LinkedList<Integer>();
            Integer num1 = list1.getObjectAtIndex(i);

            for (int j = 0; j < i; j++) {
                currSumList.insert(0); // adds extra 0s depending on how far
                                       // into the multiplication the program is
            }
            // multiplies the "top" list by j's element in the "bottom" list
            for (int j = 0; j < list2.size(); j++) {
                int num2 = list2.getObjectAtIndex(i);
                currSum = num1 * num2 + carry;
                carry = currSum / 10;
                currSumList.insert(currSum % 10);
            }
            // this if else chain is for copying the contents of one list into
            // another based on the current sum
            if (i == 0) {
                for (int j = 0; j < currSumList.size(); j++) {
                    sum1.insert(currSumList.getObjectAtIndex(j));

                }
            }
            else {
                for (int j = 0; j < currSumList.size(); j++) {
                    sum2.insert(currSumList.getObjectAtIndex(j));

                }
            }
            totalSum = add(sum1, sum2);
            sum1.clear();
            // copies the result of the addition into sum1 for the next
            // iteration
            for (int j = 0; j < totalSum.size(); j++) {
                sum1.insert(totalSum.getObjectAtIndex(j));

            }
            
            list2.moveToStart();
            sum2.clear();
        }
        return totalSum;
    }


    public static LinkedList<Integer> exponentiate(
        LinkedList<Integer> list1,
        LinkedList<Integer> newList2) {

        LinkedList<Integer> result = new LinkedList<Integer>();

        int i = 0;
        while (i < newList2.size()) {
            Integer num = newList2.getObjectAtIndex(i);

            if (num == 0) {
                result.insert(1);
                return result;
            }
            else if (num % 2 == 0) {
                LinkedList<Integer> newList = new LinkedList<Integer>();
                newList.insert(num / 2);
                return exponentiate(multiply(list1, list1), newList);
            }
            else {
                LinkedList<Integer> newList = new LinkedList<Integer>();
                newList.insert((num - 1) / 2);
                return multiply(list1, exponentiate(multiply(list1, list1),
                    newList));
            }
        }
        return result;
    }

}
