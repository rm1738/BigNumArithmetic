// On my honor:

// - I have not used source code obtained from another student,

// or any other unauthorized source, either modified or

// unmodified.

// - All source code and documentation used in my program is

// either my original work, or was derived by me from the

// source code published in the textbook for this course.

// - I have not discussed coding details about this project

// with anyone other than my partner (in the case of a joint

// submission), instructor, ACM/UPE tutors or the TAs assigned

// to this course. I understand that I may discuss the concepts

// of this program with other students, and that another student

// may help me debug my program so long as neither of us writes

// anything during the discussion or modifies any computer file

// during the discussion. I have violated neither the spirit nor

// letter of this restriction

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class BigNumArithmetic {

    private static RPNCalculator op = new RPNCalculator();

    @SuppressWarnings({})

    public static void main(String[] args) throws FileNotFoundException {
    

        if (args[0] == null) {

            String r = "No Argument Given";

            System.out.println(r);

        }

        else

        {

            readFile(args[0]);

        }

    }


    public static void readFile(String inputFileName)

        throws FileNotFoundException {

        File file = new File(inputFileName);

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String fileL = scanner.nextLine();

            boolean g = !fileL.trim().isEmpty();

            if (g) {
                processFile(fileL);
            }
        }
        scanner.close();

    }


    @SuppressWarnings({ "unchecked", "static-access" })

    public static void processFile(String fileL) {

        @SuppressWarnings("rawtypes")

        ArrayBasedStack<LinkedList> stackOfNumbers =
            new ArrayBasedStack<LinkedList>();

        String regex = "\\s+|\t";
        String[] strArray = fileL.trim().split(regex);
        Boolean valid = true;

        if (!(strArray.length < 2)) {

            for (int i = 0; i < strArray.length; i++) {

                LinkedList<Integer> num1 = new LinkedList<Integer>();
                LinkedList<Integer> num2 = new LinkedList<Integer>();
                LinkedList<Integer> result = new LinkedList<Integer>();
                String w = strArray[i];

                if (Character.getNumericValue(w.charAt(0)) >= 0) {

                    stackOfNumbers.push(convertBN(w));
                }

                if (checkValid(stackOfNumbers)) {
                    if (strArray[i].equals("*")) {

                        num1 = stackOfNumbers.pop();
                        num2 = stackOfNumbers.pop();
                        result = op.multiply(num1, num2);
                        stackOfNumbers.push(result);

                    }

                    else if (strArray[i].equals("+")) {

                        num1 = stackOfNumbers.pop();
                        num2 = stackOfNumbers.pop();
                        result = op.add(num1, num2);
                        stackOfNumbers.push(result);

                    }

                    else if (strArray[i].equals("^")) {

                        num1 = stackOfNumbers.pop();
                        num2 = stackOfNumbers.pop();
                        stackOfNumbers.push(result);
                        result = op.exp(num1, num2);
                        System.out.print(result);
                        stackOfNumbers.push(result);

                    }
                    else {
                        valid = false;

                    }

                }

            }

            if (valid == false) {

                splitAndPrint(fileL);
                System.out.println("= ");

            }
            else {

                @SuppressWarnings("unused")
                LinkedList<Integer> finalResult = new LinkedList<Integer>();

                finalResult = stackOfNumbers.pop();

                splitAndPrint(fileL);
                System.out.print("= ");

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
        }
    }

    

    static void splitAndPrint(String fileL) {

        String[] splited = fileL.replaceAll("(^\\s+|\\s+$)", "").split("\\s+");

        for (int k = 0; k < splited.length; k++) {

            int i = 0;
            while (i < splited[k].length() && splited[k].charAt(i) == '0'
                && splited[k].length() != 1 && !splited[k].matches("^[0]+$")) {
                i++;
            }

            StringBuffer sb = new StringBuffer(splited[k]);

            sb.replace(0, i, "");

            if (splited[k].matches("^[0]+$")) {
                System.out.print("0 ");
            }

            else {
                System.out.print(sb + " ");
            }
        }
    }


    private static LinkedList<Integer> convertBN(String num) {
        LinkedList<Integer> r = new LinkedList<Integer>();
        for (int i = 0; i < num.length(); i++) {
            r.insert(Character.getNumericValue(num.charAt(i)));
        }
        return r;
    }


    private static boolean checkValid(
        @SuppressWarnings("rawtypes") ArrayBasedStack stackOfNumbers) {
        return (stackOfNumbers.size() < 2);
    }

}
