public class Assignment8 {

    public static void main(String[] args) {

        //Declare and initialize variable
        int sequenceLength = -1;
        
        //read in integer value
        try {
            sequenceLength = Integer.parseInt(args[0]);
        }
        catch (Exception e) {
            System.out.println("Enter only a single integer.");
        }
    
        //Print calculated number to terminal
        System.out.println(fibSeq(sequenceLength));
    }

    //Calculate fibinocci sequence over n iterations using recursion
    public static int fibSeq(int n) {

        //Base cases
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }

        //Recursive call
        return fibSeq(n - 1) + fibSeq(n - 2);
    }
}