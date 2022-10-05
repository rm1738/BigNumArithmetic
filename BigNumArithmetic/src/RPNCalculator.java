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

                if (r > 9) {
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

                if (r > 9) {
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

                if (r > 9) {

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

