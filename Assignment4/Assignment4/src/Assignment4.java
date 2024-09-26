public class Assignment4 {
    public static void main(String[] args) {

        //Initialize variables
        String flippedString = "", userInput = "";

        //Write args into an input
        for (int i = 0; i < args.length; i++) {
            userInput = userInput + args[i];
        }

        //Loop through each 
        for (int i = userInput.length() - 1; i > -1; i--) {

            flippedString = flippedString + userInput.charAt(i);
        }

        System.out.println("\n" + flippedString + "\n");
}
}
