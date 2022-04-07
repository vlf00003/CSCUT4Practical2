import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.File;
import java.text.ParseException;


/**
 *
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "input.txt"; // name for the input file
        String outputFileName = "output.txt"; // name for the output file
        File inputFile = new File(inputFileName);// creating a new file instance from the existing file
        File outputFile = new File(outputFileName);// print the formatted representation of objects to the text-output stream
        PrintWriter wr = new PrintWriter(outputFile);// creating a print writer that will write data to the specified file
        Scanner sc = new Scanner(inputFile);// load the inputFile into the scanner

        System.out.println("Generate all the letters into upper case ones? (yes/no):"); // ask whether the output must be in uppercase
        Scanner in = new Scanner(System.in); //initiate another for the user answer
        String u = in.nextLine(); // read the user's input

        while (sc.hasNextLine()) { // read each line until the end
            String name = sc.next(); // read the first input in the line
            String surname = sc.next(); // read the second input in the line
            String dob = sc.next(); // read the third input in the line
            if (u.equalsIgnoreCase("yes")) { // if the user's input is 'yes', enter this 'if' statement
                name = name.toUpperCase(); // make all the letter of 'name' uppercase
                surname = surname.toUpperCase(); // make all the letter of 'surname' uppercase
            }
            else if (u.equalsIgnoreCase("no")) { // if the user's input is 'no', enter this 'if' statement instead
                name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();// capitalize the 1st letter of name
                surname = Character.toUpperCase(surname.charAt(0)) + surname.substring(1).toLowerCase();// capitalize the 1st letter of surname
            }
            else { // if the user typed something else, print the message and end the code execution
                System.out.println("Congratulations! You failed to follow the simplest instructions...");
                break;
            }

            try {

                Date dobObj = new SimpleDateFormat("ddMMyyyy").parse(dob);// convert date in string to date object
                String dobString = new SimpleDateFormat("dd/MM/YYYY").format(dobObj);// change it into the required format and convert to string
                wr.printf("%s %s %s \n", name, surname, dobString);// the output result

            } catch (ParseException e) {

                e.printStackTrace();

            }
        }
        in.close(); // close the scanner
        wr.close(); // close the writer
    } // main

} // FilesInOut