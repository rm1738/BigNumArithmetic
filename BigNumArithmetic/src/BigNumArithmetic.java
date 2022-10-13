import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BigNumArithmetic {

    /* Operater Object to be used when computing the expressions. */
    private static RPNCalculator op = new RPNCalculator();

    /**
     * main method : Checks to
     * see if a argument is passed to
     * be used as the input
     * file name.
     * 
     * 
     * @param args
     *            arguments needed for input file name.
     * @throws FileNotFoundException
     *             This exception is thrown if the fileName given
     *             in args[0] is not a valid file name.
     */
    @SuppressWarnings({ "static-access" })
    public static void main(String[] args) throws FileNotFoundException {
        /* No argument passed */
        if (args[0] == null) {

            System.out.println("No Argument Given");
        }
        /*
         * Call the readFile method with the passed
         * input file which contains
         * the
         * expressions to be calculated
         */
        else {
            readFile(args[0]);
        }

    } // end main


    /**
     * This method opens a file using the
     * String parameter passed and loops
     * through
     * each line in the file to send it to be processed.
     * 
     * @param inputFileName
     *            The name of the input file
     *            from which the expressions
     *            will be read.
     * @throws FileNotFoundException
     *             This exception is thrown if the given
     *             inputFileName does not exist.
     */
    @SuppressWarnings({ "unchecked", "static-access" })
    public static void readFile(String inputFileName)
        throws FileNotFoundException {
        /* File Object which will be used to scan the given file */
        File file = new File(inputFileName);
        /* Scanner Object which will be used to scan the opened file */
        Scanner scanner = new Scanner(file);

        /* Loop through the opened file to read each line */
        while (scanner.hasNextLine()) {
            /*
             * Scan the next line in the file and store it into the String
             * fileLine
             */
            String fileLine = scanner.nextLine();

            /*
             * If the fileLine scanned with its whitespace's trimmed out is not
             * empty we
             * process the line
             */
            if (!fileLine.trim().isEmpty()) {
                /* Send the fileLine to be processed */
                processLine(fileLine);
            } // end if

        } // end while
        /* Close our scanner after scanning our file */
        scanner.close();
    } // end main helper


    /**
     * This method processes its String
     * parameter passed to call the necessary
     * methods to perform the
     * arithmetic specified in the fileLine.
     * 
     * @param fileLine
     *            String which contains a
     *            line scanned from the input file
     * 
     */
    @SuppressWarnings({ "unchecked", "static-access" })
    public static void processLine(String fileLine) {

        /*
         * numStack will hold LinkedLists of Integer numbers.
         * This Stack will benecessary for proper
         * implementation of the Reverse Polish Notation
         * arithmetic
         */
        @SuppressWarnings("rawtypes")
        ArrayBasedStack<LinkedList> numStack = new ArrayBasedStack<LinkedList>();

        /*
         * First replace all whitespace
         * found in the beginning and ends of the
         * fileLine.
         * Then split the fileLine
         * into an array of individual strings.
         * These Strings
         * are split with reference to
         * white space found between each string
         */
        String[] splitFileLine = fileLine.replaceAll("(^\\s+|\\s+$)", "").split(
            "\\s+");

        /*
         * This boolean will be set to true
         * if an error in syntax is found in
         * the
         * FileLine It is initially
         * set to false as it is assumed there are no
         * errors at
         * first.
         */
        boolean errorFound = false;

        /*
         * If the splitFileLine only has less
         * then 2 Strings there are not
         * enough
         * numbers or operands for an arithmetic expressin.
         * There fore error found will
         * be set to true.
         */
        if (splitFileLine.length < 2) {
            errorFound = true;
        }

        /* If no error has been found continue to process the line */
        if (!errorFound) {
            /*
             * Loop through the splitFileLine Array to process each String in it
             */
            for (int i = 0; i < splitFileLine.length; i++) {

                /*
                 * Each Arithmetic expression needs two operands to produce a
                 * result
                 */
                /* num1 will represent the first operand */
                LinkedList<Integer> num1 = new LinkedList<Integer>();
                /* num2 will represent the second operand */
                LinkedList<Integer> num2 = new LinkedList<Integer>();
                /*
                 * result will represent the result obtained from performing the
                 * operation
                 */
                LinkedList<Integer> result = new LinkedList<Integer>();

                /***************************
                 * START OPERATION BLOCK
                 ****************************/
                /*
                 * For each operator found the numStack must contain at least 2
                 * numbers(represented as a LinkedList) to perform the operation
                 */

                /*
                 * If the Multiply operator is found try performing a multiply
                 * operation
                 */
                if (splitFileLine[i].equals("*")) {
                    /*
                     * The numStack must contain at least 2 numbers to perform
                     * the operation
                     */
                    if (numStack.size() < 2) {
                        /*
                         * If the size of the numStack is less then 2 then a
                         * syntax error has been found
                         */
                        errorFound = true;
                    }
                    /*
                     * If no error has been found continue to perform the
                     * operation
                     */
                    if (!errorFound) {
                        /* Pop from the stack to obtain num1 and num2 */
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        /*
                         * Call the multi method found in the Operator Class to
                         * perform the operation on
                         * num1 and num2. Store the LinkedList obtained from the
                         * method into result
                         */
                        result = op.multiply(num1, num2);
                        /* Push the Result back on to the stack */
                        numStack.push(result);
                    }
                } /*
                   * If the Addition operator is found try performing a multiply
                   * operation
                   */
                else if (splitFileLine[i].equals("+")) {
                    /*
                     * The numStack must contain at least 2 numbers to perform
                     * the operation
                     */
                    if (numStack.size() < 2) {
                        /*
                         * If the size of the numStack is less then 2 then a
                         * syntax error has been found
                         */
                        errorFound = true;
                    }
                    /*
                     * If no error has been found continue to perform the
                     * operation
                     */
                    if (!errorFound) {
                        /* Pop from the stack to obtain num1 and num2 */
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        /*
                         * Call the addition method found in the Operator Class
                         * to perform the operation
                         * on num1 and num2. Store the LinkedList obtained from
                         * the method into result
                         */
                        result = op.add(num1, num2);
                        /* Push the Result back on to the stack */
                        numStack.push(result);
                    }

                } /*
                   * If the Power operator is found try performing a multiply
                   * operation
                   */
                else if (splitFileLine[i].equals("^")) {
                    /*
                     * The numStack must contain at least 2 numbers to perform
                     * the operation
                     */
                    if (numStack.size() < 2) {
                        /*
                         * If the size of the numStack is less then 2 then a
                         * syntax error has been found
                         */
                        errorFound = true;
                    }
                    /*
                     * If no error has been found continue to perform the
                     * operation
                     */
                    if (!errorFound) {
                        /* Pop from the stack to obtain num1 and num2 */
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        /*
                         * Call the exp method found in the Operator Class to
                         * perform the operation on
                         * num1 and num2. Store the LinkedList obtained from the
                         * method into result
                         */
                        result = op.exponentiate(num2, num1);
                        /* Push the Result back on to the stack */
                        numStack.push(result);
                    }

                }
                /**************************
                 * END OPERATION BLOCK
                 ******************************/

                /*
                 * If the string is not a operation then push it into numStack
                 * as an Linkedlist
                 * of Integers
                 */
                else {
                    /* Linked List which will hold our number */
                    LinkedList<Integer> numList = new LinkedList<Integer>();

                    /* Check if the String contains a number. */
                    if (splitFileLine[i].matches("[-+]?\\d*\\.?\\d+")) {
                        /* Obtain a character array from the String */
                        char[] stringArr = splitFileLine[i].toCharArray();

                        /*
                         * For each character convert in to a Int and add it to
                         * the numList
                         */
                        for (int j = stringArr.length - 1; j >= 0; j--) {
                            int n = Integer.parseInt(String.valueOf(
                                stringArr[j]));
                            numList.insert(n);
                        }

                        /*
                         * Push our numList (the list which contains the entire
                         * number separated) to the
                         * stack
                         */
                        numStack.push(numList);
                    }
                    /*
                     * If the String is not a number then the a sytax error has
                     * been found
                     */
                    else {
                        /* Set error found to true */
                        errorFound = true;
                    }

                }

            }
        } // End For loop

        /*
         * Call the print result method to print results after the fileLine has
         * been
         * processed
         */
        printResult(fileLine, numStack, errorFound);
    }


    /**
     * 
     * @param fileLine
     *            String which contains the original line that was processed.
     * @param numStack
     *            The numStack which contains the remaining numbers after all
     *            operations with correct syntax have been performed.
     * @param errorFound
     *            Boolean which determined weather an error was found while
     *            Processing the line.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void printResult(
        String fileLine,
        ArrayBasedStack<LinkedList> numStack,
        boolean errorFound) {
        /*
         * If the syntax of fileLine was correct to Reverse Polish Notation, the
         * numStack after performing all operations should contain only one
         * number.
         * Therefore if the size is greater then 1 of an error was found go into
         * the if.
         */
        if (numStack.size() > 1 || errorFound) {
            /*
             * The original fileLine is printed by calling the splitAndPrint
             * method in the
             * Operator Class. The fileLine will be refined to remove
             * unnecessary characters
             * before printing.
             */
            op.splitAndPrint(fileLine);
            /* Print an equal sign */
            System.out.println("= ");
        }
        /* If all operations were performed correctly go into the else block */
        else {
            /*
             * This linked List will hold our final result obtained from the
             * calculations
             */
            LinkedList<Integer> finalResult = new LinkedList<Integer>();
            /*
             * Pop the last item in numStack and store it into the finalResult
             * list
             */
            finalResult = numStack.pop();
            /*
             * The original fileLine is printed by calling the splitAndPrint
             * method in the
             * Operator Class. The fileLine will be refined to remove
             * unnecessary characters
             * before printing.
             */
            op.splitAndPrint(fileLine);
            /* Print an equal sign */
            System.out.print("= ");

            /*
             * This boolean will be used to removed leading zeros in the number
             */
            boolean foundFirstNum = false;
            /*
             * Loop through the finalResult to print it as a number without
             * leading zeros
             */
            for (int i = finalResult.size() - 1; i >= 0; i--) {
                if (finalResult.getObjectAtIndex(i) != 0) {
                    foundFirstNum = true;
                }
                if (foundFirstNum || i == 0) {
                    System.out.print(finalResult.getObjectAtIndex(i));
                }
            }
            System.out.println("");
        } // end else
        // end method

    }
} // end class
