import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// On my honor:
// - I have not used source code obtained from another student,
//   or any other unauthorized source, either modified or
//   unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
//   with anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.
/**
 * @version BIGNUMARITHMETIC 
 * @author abdurrehmannauman
 * 
 */
public class BigNumArithmetic {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                "Exactly one argument needed: file-input");
        }
        String inputFilePath = args[0];
        // We could do all this in a static way, but then we would
        // need to reset our static variables for every test!
        // Let's avoid that by using the object approach like so: 
        BigNumArithmetic superCalc = new BigNumArithmetic();
        superCalc.printCalculations(inputFilePath);
    }
    /**
     * 
     */
    public BigNumArithmetic()
    {
        // If I had any fields, I'd initialize them here
    }
    /**
     * 
     * @param filepath
     * @throws FileNotFoundException
     */
    public void printCalculations(String filepath) throws FileNotFoundException 
    {
        
        
        
    }  
    public void ReadFile(String nameOfFile) throws FileNotFoundException
    {
        File file = new File(nameOfFile);
        Scanner scan = new Scanner(nameOfFile);
        while(scan.hasNext())
        {
            if(!scan.nextLine().trim().isEmpty())
            {
                process(scan.nextLine());
            }
        }
        scan.close();
                
        
    }
    
    public void process(String nameOfFile)
    {
        
        @SuppressWarnings("rawtypes")
        
        ArrayBasedStack<linkedlist> numStack = new ArrayBasedStack<linkedlist>();

        String[] splitFileLine = nameOfFile.replaceAll("(^\\s+|\\s+$)", "").split(
            "\\s+");

        boolean errorFound = false;

        if (splitFileLine.length < 2) {
            errorFound = true;
        }

        if (!errorFound) {
            for (int i = 0; i < splitFileLine.length; i++) {
                linkedlist<Integer> num1 = new linkedlist<Integer>();
                linkedlist<Integer> num2 = new linkedlist<Integer>();
                linkedlist<Integer> result = new linkedlist<Integer>();
                if (splitFileLine[i].equals("*")) {
                    if (numStack.size() < 2) {
                        errorFound = true;
                    }
                    if (!errorFound) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        result = op.multi(num1, num2);
                        numStack.push(result);
                    }
                } 
                else if (splitFileLine[i].equals("+")) {
                        errorFound = true;
                    }
                    if (!errorFound) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        result = op.addition(num1, num2);
                        numStack.push(result);
                    }

                
                else if (splitFileLine[i].equals("^")) {
                   
                    if (numStack.size() < 2) {
                       
                        errorFound = true;
                    }
               
                    if (!errorFound) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                     
                        result = op.exp(num2, num1);
                       
                        numStack.push(result);
                    }

                }
           

                else {
                   
                    linkedlist<Integer> numList = new linkedlist<Integer>();

                 
                    if (splitFileLine[i].matches("[-+]?\\d*\\.?\\d+")) {
                    
                        char[] stringArr = splitFileLine[i].toCharArray();

                        for (int j = stringArr.length - 1; j >= 0; j--) {
                            int n = Integer.parseInt(String.valueOf(
                                stringArr[j]));
                            numList.insert(n);
                        }

                        numStack.push(numList);
                    }
                    else {
                        errorFound = true;
                    }

                }

            }
        } 

        
        printResult(fileLine, numStack, errorFound);
        
    }
        
        
}