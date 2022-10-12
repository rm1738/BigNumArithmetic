import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.apache.commons.collections.ArrayStack;

public class BigNumArithmetic {

    private static RPNCalculator RPN = new RPNCalculator();

    @SuppressWarnings({ "static-access" })
    public static void main(String[] args) throws FileNotFoundException {

        if (args[0] == null) {

            System.out.println("No Argument Given");
        }

        readFile(args[0]);
    }


    @SuppressWarnings({ "unchecked", "static-access" })
    public static void readFile(String inputFileName)
        throws FileNotFoundException {

        File file = new File(inputFileName);

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String fileLine = scanner.nextLine();

            if (!fileLine.trim().isEmpty()) {

                @SuppressWarnings("rawtypes")
                ArrayBasedStack<LinkedList> numberStack =
                    new ArrayBasedStack<LinkedList>();

                String[] splitFileLine = fileLine.replaceAll("(^\\s+|\\s+$)",
                    "").split("\\s+");

                if (!(splitFileLine.length < 2)) {
                    /*
                     * Loop through the splitFileLine Array to process each
                     * String in it
                     */
                    for (int i = 0; i < splitFileLine.length; i++) {

                        LinkedList<Integer> op1 = new LinkedList<Integer>();

                        LinkedList<Integer> op2 = new LinkedList<Integer>();

                        LinkedList<Integer> result = new LinkedList<Integer>();

                        if (splitFileLine[i].equals("+")) {
                            if (numberStack.size() < 2) {

                            }
                            else {

                                op1 = numberStack.pop();
                                op2 = numberStack.pop();

                                result = RPN.add(op1, op2);
                                numberStack.push(result);

                            }
                        }

                        if (splitFileLine[i].equals("*")) {
                            if (numberStack.size() < 2) {

                            }
                            else {

                                op1 = numberStack.pop();
                                op2 = numberStack.pop();

                                result = RPN.multiply(op1, op2);
                                numberStack.push(result);

                            }
                        }
                        if (splitFileLine[i].equals("^")) {
                            if (numberStack.size() < 2) {

                                op1 = numberStack.pop();
                                op2 = numberStack.pop();

                                result = RPN.exponentiate(op1, op2);
                                numberStack.push(result);

                            }
                            else {

                            }
                        }

                    }
                }

            }

        }
        scanner.close();
    }

}
