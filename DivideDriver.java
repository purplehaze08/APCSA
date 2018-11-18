import java.util.Scanner;
public class DivideDriver {
    public static void main(String args[]){
        System.out.println("Do you wish to encrypt: yes or no?");
        Scanner sc1 = new Scanner(System.in);
        String res1 = sc1.nextLine().toLowerCase();
        
        if (res1.equals("yes")) {
            System.out.println("Please enter your word");
            String encryWord = sc1.nextLine();
            System.out.println("How many shifts?");
            int shift = sc1.nextInt();
            if(encryWord.length() % 2 == 0) {
                DivideCipher dc1 = new DivideCipher(encryWord, shift);
                dc1.EncryptEven();
             
            }
            else if (encryWord.length() % 2 != 0) {
                DivideCipher dc2 = new DivideCipher(encryWord, shift);
                dc2.EncryptOdd();
            }
        }
        System.out.print( "\n" );
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Do you wish to decrypt a word: yes or no?");
        String res2 = sc2.nextLine().toLowerCase();
        if (res2.equals("yes")) {
            System.out.println("Please enter your word");
            String decryWord = sc2.nextLine();
            System.out.println("How many shifts?");
            int shift = sc2.nextInt();
            if(decryWord.length() % 2 == 0) {
                DivideDecipher dc2 = new DivideDecipher(decryWord, shift);
                dc2.DecryptEven();
            }
            else if (decryWord.length() % 2 != 0) {
                DivideDecipher dc2 = new DivideDecipher(decryWord, shift);
                dc2.DecryptOdd();
            }
        }
    }
}