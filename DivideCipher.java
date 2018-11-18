public class DivideCipher {
    private String userInput;
    private int indLen;
    private int sizeHalf;
    private int numShift;
    public static int status;
    
    public DivideCipher(String input, int shifts) {
        userInput = input;
        indLen = input.length();   
        numShift = shifts;
    }
    
    public void EncryptEven() {
        sizeHalf = indLen / 2;
        char[] clist = new char[indLen];
        char[] flist = new char[indLen];
        for (int x = 0; x < indLen; x++) {
            clist[x] = userInput.charAt(x);
        } //convert string into a character array and store it 
        int ascii1 = (int) clist[0]; 
            //cast and find the ASCII value of first element
        int ascii2 = (int) clist[sizeHalf];
            //cast and find the ASCII value of first element in 2nd half
        if(ascii2 > ascii1 || ascii2 == ascii1) {
            char[] temp = new char[sizeHalf];
            for (int x = 0; x < sizeHalf; x++) {
                temp[x] = clist[x];
            } //storing the 1st half that needs to be reversed temporarily 
            for (int x = 0, j = sizeHalf; x < sizeHalf; x++, j++) {
                clist[x] = clist[j]; //make 1st half equal to 2nd half
            }
            for (int x = sizeHalf, j = 0; x < indLen; x++, j++) {
                clist[x] = temp[j];
                //reaplce the 2nd half with 1st half temp
            }
            
            System.out.println("Printing reversed");
            for (int x = 0; x < indLen; x++) {
                System.out.print(clist[x]);
            }
            System.out.println();
            System.out.println("printing ascii");
            int[] ascL = new int[indLen]; //create a new int array
            for (int x = 0; x < indLen; x++) {
                ascL[x] = (int) clist[x] + numShift; 
                System.out.println(ascL[x]);
                //rotate givne user inputs
            }
            System.out.println("printing reversed word");
            for (int x = 0; x < indLen; x++) {
                flist[x] = (char)(ascL[x]); //cast ASCII int back to char and store the chars
                System.out.print(flist[x]); //Print out the encrypted word
            }
            status = 1;
        }
        else {
            int[] ascL = new int[indLen];
            System.out.println("printing ascii \n");
            for (int x = 0; x < indLen; x++) {
                ascL[x] = (int) clist[x] + numShift; 
                System.out.println(ascL[x]);
                //rotate givne user inputs
            }
            System.out.println("printing reversed word");
            for (int x = 0; x < indLen; x++) {
                flist[x] = (char)(ascL[x]); //cast ASCII int back to char and store the chars
                System.out.print(flist[x]); //Print out the encrypted word
            }
            status = 0;
        }
    }
    
    public void EncryptOdd() {
        int breakInd = (indLen - 1) / 2;
        char[] clist = new char[indLen];
        char[] flist = new char[indLen];
        for (int x = 0; x < indLen; x++) {
            clist[x] = userInput.charAt(x);
        } //convert string into a character array and store it 
        int ascii1 = (int) clist[breakInd-1]; 
        int ascii2 = (int) clist[breakInd+1];
        //cast and find the ASCII values of elements around the middle element
        if (ascii2 > ascii1 || ascii2 == ascii1) {
            char[] temp = new char[breakInd];
            for (int x = 0; x < breakInd; x++) {
                temp[x] = clist[x]; //store all the elements on the left of the middle index temporarily
            }
            
            for (int x = 0, j = breakInd + 1; x < breakInd; x++, j++) {
                clist[x] = clist[j]; //make 1st half equal to 2nd half
            } 
            //checked
            for (int x = breakInd + 1, j = 0; x < indLen; x++, j++) {
                clist[x] = temp[j];
            } //replace the 2nd half with 1st half, as presented in the original array
            System.out.println("Printing reversed");
            for (int x = 0; x < indLen; x++) {
                System.out.print(clist[x]);
            }
            int[] ascL = new int[indLen];
            System.out.print("\nprinting ascii values after shifts\n");
            for (int x = 0; x < indLen; x++) {
                ascL[x] = (int) clist[x] + numShift; 
                System.out.println(ascL[x]);
                //rotate given user inputs
            }
            System.out.println("printing encrypted word");
            for (int x = 0; x < indLen; x++) {
                flist[x] = (char)(ascL[x]); //cast ASCII int back to char and store the chars
                System.out.print(flist[x]); //Print out the encrypted word
            }
            status = 1;
        }
        else {
            int[] ascL = new int[indLen];
            System.out.println("printing ascii\n");
            for (int x = 0; x < indLen; x++) {
                ascL[x] = (int) clist[x] + numShift; 
                System.out.println(ascL[x]);
                //rotate givne user inputs
            }
            System.out.println("printing reversed word");
            for (int x = 0; x < indLen; x++) {
                flist[x] = (char)(ascL[x]); //cast ASCII int back to char and store the chars
                System.out.print(flist[x]); //Print out the encrypted word
            }
            status = 0;
        }
    }
}
    
    