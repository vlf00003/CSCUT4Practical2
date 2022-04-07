import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FormatNamesm {

    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "inputm.txt"; // name for the input file
        String outputFileName = "outputm.txt"; // name for the output file
        File inputFile = new File(inputFileName);// creating a new file instance from the existing file
        File outputFile = new File(outputFileName);// print the formatted representation of objects to the text-output stream
        PrintWriter wr = new PrintWriter(outputFile);// creating a print writer that will write data to the specified file
        Scanner sc = new Scanner(inputFile);// load the inputFile into the scanner

        System.out.println("Generate all the letters into upper case ones? (yes/no):"); // ask whether the output must be in uppercase
        Scanner in = new Scanner(System.in); //initiate another for the user answer
        String u = in.nextLine(); // read the user's input
        boolean midNamePres = false; // set the 'middle name presented' to false

        while (sc.hasNextLine()) { // read each line until the end
            String name = sc.next(); // read the first input in the line
            String surname = sc.next(); // read the second input in the line
            String dob = sc.next(); // read the third input in the line
            String middleName = ""; // initiate the middleName string
            if(Character.isLetter(dob.charAt(0))) { // check whether the character of dob is a letter
                // if the third input is indeed a letter, we enter this 'if' statement
                middleName = surname; // middle name now is in the 2nd position, therefore we swap middle name with last name
                surname = dob; // last name in the 3rd position, therefore we swap last name and dob
                dob = sc.next(); // dob is in the 4th position, therefore we scan the next line and assign it to the dob
                midNamePres = true; // set 'middle name presented' to true
            }
            if (u.equalsIgnoreCase("yes")) { // if the user's input is 'yes', enter this 'if' statement
                name = name.toUpperCase();// make all the letter of 'name' uppercase
                middleName = middleName.toUpperCase(); // make all the letter of 'middleName' uppercase
                surname = surname.toUpperCase();// make all the letter of 'surname' uppercase
            }
            else if (u.equalsIgnoreCase("no")) { // if the user's input is 'no', enter this 'if' statement instead
                name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();// capitalize the 1st letter of name
                middleName = middleName.toUpperCase();// since middle name only contains 1 letter, we just capitalize the whole string
                surname = Character.toUpperCase(surname.charAt(0)) + surname.substring(1).toLowerCase();// capitalize the 1st letter of surname
            }
            else { // if the user typed something else, print the message and end the code execution
                System.out.println("Congratulations! You failed to follow the simplest instructions...");
                break;
            }

            try {
                Date dobObj = new SimpleDateFormat("ddMMyyyy").parse(dob);// convert date in string to date object
                String dobString = new SimpleDateFormat("dd/MM/YYYY").format(dobObj);// change it into the required format and convert to string
                if(midNamePres == true) { //if middle name is presented enter the 'if' statement
                    wr.printf("%s %s. %s %s \n", name, middleName, surname, dobString);// the output result with middleName
                }
                else {
                    wr.printf("%s %s %s \n", name, surname, dobString);// the output result without middleName
                }
                midNamePres = false; // reset the boolean variable
            } catch (ParseException e) {

                e.printStackTrace();

            }
        }
        in.close(); // close the scanner
        wr.close(); // close the writer
    } // main

} // FilesInOut