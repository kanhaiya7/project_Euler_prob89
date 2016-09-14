
package hfg;

//importing the classes required
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;


public class RomanNumerals89 {
public static int toDecimal(String roman_in) {
    int decimalValue = 0;
    int previousNum = 0;
    
    //Parsing the input roman string from last character to convert it into decimal value
        for (int x = roman_in.length() - 1; x >= 0 ; x--) {
        char roman_char = roman_in.charAt(x);
        // Getting the character at cursor position
        //depending on the current roman value doing the necessary actions
        switch (roman_char) {
            case 'M':
                decimalValue = findDecimal(1000, previousNum, decimalValue);
                previousNum = 1000;
                break;

            case 'D':
                decimalValue = findDecimal(500, previousNum, decimalValue);
                previousNum = 500;
                break;

            case 'C':
                decimalValue = findDecimal(100, previousNum, decimalValue);
                previousNum = 100;
                break;

            case 'L':
                decimalValue = findDecimal(50, previousNum, decimalValue);
                previousNum = 50;
                break;

            case 'X':
                decimalValue = findDecimal(10, previousNum, decimalValue);
                previousNum = 10;
                break;

            case 'V':
                decimalValue = findDecimal(5, previousNum, decimalValue);
                previousNum = 5;
                break;

            case 'I':
                decimalValue = findDecimal(1, previousNum, decimalValue);
                previousNum = 1;
                break;
        }
    }
    //System.out.println(decimal);
    return decimalValue;
    //returning the total value of integer conversion for given roman string
}

// checking the current value with last value and finding the total of decimal value
public static int findDecimal(int currentDecimal, int previousNum, int lastDecimal) {
    if (previousNum > currentDecimal) {
        return lastDecimal - currentDecimal;
        //if if previous is greater than current then subtract that
    } else {
        return lastDecimal + currentDecimal;
        //if previous value is smaller than current then add current to total
    }
}

//method to convert input decimal to roman string
public static String toRoman(int inputNum) {

    String roman_str = "";
    //string declared to store the roman conversion
    while (inputNum >= 1000) {
    	roman_str += "M";
        inputNum -= 1000;        //value for M is 1000
    }
    while (inputNum >= 900) {
    	roman_str += "CM";
        inputNum -= 900;		//value for CM is 900
    }
    while (inputNum >= 500) {
    	roman_str += "D";
        inputNum -= 500;		//value for D is 500
    }
    while (inputNum >= 400) {
    	roman_str += "CD";
        inputNum -= 400;		//value for CD is 400
    }
    while (inputNum >= 100) {
    	roman_str += "C";
        inputNum -= 100;		//value for C is 100
    }
    while (inputNum >= 90) {
    	roman_str += "XC";
        inputNum -= 90;			//value for XC is 90
    }
    while (inputNum >= 50) {
    	roman_str += "L";
        inputNum -= 50;			//value for L is 50
    }
    while (inputNum >= 40) {
    	roman_str += "XL";
        inputNum -= 40;			//value for XL is 40
    }
    while (inputNum >= 10) {
    	roman_str += "X";
        inputNum -= 10;			//value for X is 10
    }
    while (inputNum >= 9) {
    	roman_str += "IX";
        inputNum -= 9;			//value for IX is 9
    }
    while (inputNum >= 5) {
    	roman_str += "V";
        inputNum -= 5;			//value for V is 5
    }
    while (inputNum >= 4) {
    	roman_str += "IV";
        inputNum -= 4;			//value for IV is 4
    }
    while (inputNum >= 1) {
    	roman_str += "I";
        inputNum -= 1;			//value for I is 1
    }    
    return roman_str;
    //returning the string of minimal roman converted for the input decimal number
}
public static void main(String args[]) throws IOException {
   
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kanaiya\\Desktop\\p089_roman.txt"));
	// creating a object for given text file of roman strings
    try {
        String line = br.readLine();
        // declared variable line to get line by line input from text file
        FileWriter wr = null;
        wr = new FileWriter(new File("C:\\Users\\Prathibha\\Desktop\\output.txt"));
        // change the output file path as required
        int saved_char=0;
        int count=0;
		//Parsing the file till the last to get all line as input
        String formatStr = "%-4s %-1s %-25s %-20s %-20s %-20s%n";
        wr.write(String.format(formatStr, "S.No","|", "Input Roman String", "Decimal number", "Minimal Form", "No. of char saved"));
        wr.write("-----|--------------------------------------------------------------------------------------" + 
        		System.getProperty("line.separator"));
        while (line != null) {
            int num = toDecimal(line);
            //getting the decimal number for the given string of roman
        	String roman_out=null;
        	roman_out = toRoman(num);
        	//converting the decimal from out from above method into the minimal form
            count ++;
            int len = line.length() - roman_out.length();
            saved_char = saved_char + len;
            // checking the length of given roman string with the minimal form we obtained
            // getting the number of characters saved
            /*wr.write(System.getProperty("line.separator") + count + ") Input: " + line + 
            		"\tMinimal form: " + roman_out + "\tDecimal num: " + num + 
            		System.getProperty("line.separator") + "\tNumber of characters saved: " + 
            		len  + System.getProperty("line.separator"));*/
            
            wr.write(String.format(formatStr, count, "|", line, num, roman_out, len));
            line = br.readLine();
            // reading the next input of roman input from the file

        }
        wr.write(String.format(formatStr, "", "", "", "", "", "---------"));
        wr.write(String.format(formatStr, "", "", "", "", "Total", saved_char));
        wr.write("Total number of Roman strings checked : " + count);
        //writing the count of the roman numbers checked 
        wr.close();
        //closing the file writer
        System.out.println(" Total number of characters saved for given " + count 
        		+ " roman strings =" + saved_char + "\n\nThanks..:)");
        // output on console
    } finally {
        br.close();
    }
	
	
}
 }