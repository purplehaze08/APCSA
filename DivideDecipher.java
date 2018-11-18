public class DivideDecipher{
    private String userInput;
    private int indLen;
    private int sizeHalf;
    private int numShift;
    
    public DivideDecipher(String input, int shifts) {
        userInput = input;
        indLen = input.length();   
        numShift = shifts;
    }
    
    public void DecryptEven() {
        sizeHalf = indLen / 2;
        char[] clist = new char[indLen];
        char[] flist = new char[indLen];
        for (int x = 0; x < indLen; x++) {
            clist[x] = userInput.charAt(x);
        } //convert decryword into a character array and store it 
        int ascii1 = (int) clist[0]; 
            //cast and find the ASCII value of first element
        int ascii2 = (int) clist[sizeHalf];
            //cast and find the ASCII value of first element in 2nd half
        if ((ascii1 > ascii2 || ascii1 == ascii2) && DivideCipher.status == 1) {
            int[] ascL = new int[indLen];
            char[] temp = new char[sizeHalf]; 
            System.out.println("printing ascii");
            for (int x = 0; x < indLen; x++) {
                ascL[x] = (int) clist[x] - numShift; 
                System.out.println(ascL[x]);
                // decrypt given number of rotations
            }
            System.out.println("printing reversed word");
            for (int x = 0; x < indLen; x++) {
                flist[x] = (char)(ascL[x]); //cast ASCII int back to char and store the chars
                System.out.print(flist[x]); //Print out the reversed word
            }
            
            for (int x = 0; x < sizeHalf; x++) {
                temp[x] = flist[x];
            }
            
            for (int x = 0, j = sizeHalf; x < sizeHalf; x++, j++) {
                flist[x] = flist[j];
            }
            System.out.println("\nprinting decrypted word");
            for (int x = sizeHalf, j = 0; x < indLen; x++, j++) {
                flist[x] = temp[j];
            }
            
            for (int x = 0; x < indLen; x++){
                System.out.print(flist[x]);
            }
        }
        else {
            int[] ascL = new int[indLen];
            for (int x = 0; x < indLen; x++) {
                ascL[x] = (int) clist[x] - numShift; 
                System.out.println(ascL[x]);
                // decrypt given number of rotations
            }
            System.out.println("printing decrypted word");
            for (int x = 0; x < indLen; x++) {
                flist[x] = (char)(ascL[x]); //cast ASCII int back to char and store the chars
                System.out.print(flist[x]); //Print out the reversed word
            }
        }
    }
    
    public void DecryptOdd() {
        int breakInd = (indLen - 1) / 2;
        char[] clist = new char[indLen];
        char[] flist = new char[indLen];
        for (int x = 0; x < indLen; x++) {
            clist[x] = userInput.charAt(x);
        } //convert decryword into a character array and store it 
        int ascii1 = (int) clist[breakInd-1]; 
            //cast and find the ASCII value of the element to the left of breakInd
        int ascii2 = (int) clist[breakInd+1];
            //cast and find the ASCII value of the element to the right of breakInd
        
        if ((ascii1 > ascii2 || ascii1 == ascii2) && DivideCipher.status == 1) { //if ascii1 > ascii2, the order is reversed
            int[] ascL = new int[indLen];
            char[] temp = new char[breakInd]; 
            System.out.println("printing ascii");
            for (int x = 0; x < indLen; x++) {
                ascL[x] = (int) clist[x] - numShift; 
                System.out.println(ascL[x]);
                // decrypt given number of rotations
            }
            System.out.println("printing reversed word");
            for (int x = 0; x < indLen; x++) {
                flist[x] = (char)(ascL[x]); //cast ASCII int back to char and store the chars
                System.out.print(flist[x]); //Print out the reversed word
            }
            
            for (int x = 0; x < breakInd; x++) {
                temp[x] = flist[x];
            }
            
            for (int x = 0, j = breakInd + 1; x < breakInd; x++, j++) {
                flist[x] = flist[j]; //make 1st half equal to 2nd half
            } 
            System.out.println("\nprinting decrypted word");
            for (int x = breakInd+1, j = 0; x < indLen; x++, j++) {
                flist[x] = temp[j];
            }
            for (int x = 0; x < indLen; x++) {
                System.out.print(flist[x]);
            }
        }
        else {
            int[] ascL = new int[indLen];
            System.out.println("printing ascii values");
            for (int x = 0; x < indLen; x++) {
                ascL[x] = (int) clist[x] - numShift; 
                System.out.println(ascL[x]);
                // decrypt given number of rotations
            }
            System.out.println("printing decrypted word");
            for (int x = 0; x < indLen; x++) {
                flist[x] = (char)(ascL[x]); //cast ASCII int back to char and store the chars
                System.out.print(flist[x]); //Print out the reversed word
            }
        }
    }
    
}