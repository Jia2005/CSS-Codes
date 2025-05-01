//Implementing Casear Cipher in Java
import java.util.*; 
public class Cipher 
{ 
      public static String Cipher (String input, int key) 
      { 
      StringBuilder ciphertext = new StringBuilder(); 
             for (char c : input.toCharArray()) 
      { 
                 ciphertext.append((char) ((c + key) % 255)); 
              } 
              return ciphertext.toString(); 
      } 
        public static String decrypt(String text, int key) 
      { 
              StringBuilder plaintext = new StringBuilder(); 
              for (char c : text.toCharArray()) { 
                  plaintext.append((char) ((c - key + 255) % 255)); 
              } 
              return plaintext.toString(); 
          } 
      public static void main(String args[]) 
      { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the plaintext to be ciphered"); 
        String input = sc.nextLine(); 
        int key = 3; 
        System.out.println("The plain text is "+input); 
        String ciphertext = Cipher(input,key); 
        System.out.println("The ciphered text is "+ciphertext); 
        String plaintext = decrypt(ciphertext,key); 
        System.out.println("The decrypted text is "+plaintext); 
       
      } 
}
