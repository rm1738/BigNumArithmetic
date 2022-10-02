import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Better put the honor code here...

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


    public BigNumArithmetic() {
        // If I had any fields, I'd initialize them here
    }


    public void printCalculations(String filepath)
        throws FileNotFoundException {
        Scanner scanIn = new Scanner(new File(filepath));

        while (scanIn.hasNextLine()) {
            String line = scanIn.nextLine();
            System.out.println("Input Line: " + line);

            String[] words = line.split(" +");
            for (int i = 0; i < words.length; i++) {

                String word = words[i];
                System.out.println("Input word: " + word);
                // Something's not right here when the input has some tabs ...
                // Maybe we should change the Regular Expression that's used
                // for splitting the line into words?
                // And what happens when I have a blank line?
            }
        }
        scanIn.close();

    }

}
