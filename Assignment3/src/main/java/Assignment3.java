import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {

        //Initialize variables
        String userInput = "", conversion;
        String[] inputLine;
        float theNumber = 0.0f, conversionRate = 0f, answer;
        boolean validConversion;
        
        System.out.println("Welcome to the unit conversion tool. Please type an option from the list below.");

        //Scan for input from user
        try (Scanner scan = new Scanner(System.in)) {
            
            //Loop while user doesn't enter "EXIT"
            while(userInput.equalsIgnoreCase("Exit") != true) {

                //Communication to user about how to use conversion tool.
                System.out.println("Available units for mass: lbs, kg, grams");
                System.out.println("Available units for length: feet, inch, meter, cm");
                System.out.println("Type in format of 1 kg = grams.");
                System.out.println("If you are done converting, type EXIT");

                //Get input and split into array
                userInput = scan.nextLine();
                inputLine = userInput.split(" ");
                validConversion = true;
                
                //Run only if the user input 4 tokens
                if(inputLine.length == 4) {

                    //Create String variable to be used in switch statement
                    conversion = inputLine[1] + " = " + inputLine[3];

                    //Try to parse number input to a float value
                    try {
                    theNumber = Float.parseFloat(inputLine[0]);
                    } catch (NumberFormatException e) {
                        conversion = "Invalid input. Conversion must start with a number.";
                        //System.err.println(conversion);
                    }
                    
                    //Switch to set conversion rate
                    switch (conversion) {
                        case "lbs = kg":
                            conversionRate = 0.454f;
                            break;
                        case "lbs = grams":
                            conversionRate = 454f;
                            break;
                        case "kg = lbs":
                            conversionRate = 2.2f;
                            break;
                        case "kg = grams":
                            conversionRate = 1000f;
                            break;
                        case "grams = lbs":
                            conversionRate = 0.0022f;
                            break;
                        case "grams = kg":
                            conversionRate = 0.001f;
                            break;
                        case "feet = inch":
                            conversionRate = 12f;
                            break;
                        case "feet = meter":
                            conversionRate = 0.305f;
                            break;
                        case "feet = cm":
                            conversionRate = 30.5f;
                            break;
                        case "inch = feet":
                            conversionRate = 0.083f;
                            break;
                        case "inch = meter":
                            conversionRate = 0.024f;
                            break;
                        case "inch = cm":
                            conversionRate = 2.54f;
                            break;
                        case "meter = feet":
                            conversionRate = 3.28f;
                            break;
                        case "meter = inch":
                            conversionRate = 39.4f;
                            break;
                        case "meter = cm":
                            conversionRate = 100f;
                            break;
                        case "cm = feet":
                            conversionRate = 0.033f;
                            break;
                        case "cm = inch":
                            conversionRate = 0.394f;
                            break;
                        case "cm = meter":
                            conversionRate = 0.01f;
                            break;
                        default:
                            System.out.println("\nInvalid input. This conversion may not be handled by this program.\n");
                            validConversion = false;
                        }

                    //If a valid conversion was entered, output converted number
                    if (validConversion) {
                        answer = conversionRate * theNumber;
                        System.out.println(theNumber + " " + inputLine[1] + " converts to " + answer + " " + inputLine[3]);
                        System.out.println("\n\nConvert again.");
                    }
                }
                //Message to user if they type "exit"
                else if (userInput.equalsIgnoreCase("Exit")){
                    System.out.println("Thank you for converting!\n\n");
                }
                //Message if user inputs something with too many spaces
                else if (inputLine.length > 4){
                    System.out.println("Invalid input. Input may have too many spaces or words");
                }
                //If user input had more or less than 4 tokens, meaning invalid input
                else {
                        System.out.println("\nInvalid input. Check spacing and try again.\n");
                }
            }
        }
    }
}
