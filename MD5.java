//MD5
import java.util.Scanner; 
public class Main { 
    public static int F(int x, int y, int z) { 
        return (x & y) | (~x & z); 
    }    
    public static int G(int x, int y, int z) { 
        return (x & z) | (y & ~z); 
    }    
    public static int H(int x, int y, int z) { 
        return x ^ y ^ z; 
    }    
    public static int I(int x, int y, int z) { 
        return y ^ (x | ~z); 
    } 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter message: "); 
        String message = scanner.nextLine(); 
        byte[] messageBytes = message.getBytes(); 
        int originalBitLength = messageBytes.length * 8; 
        System.out.println("=== MD5 Simulation for One Iteration ===\n"); 
        System.out.println("Step 1: Append Padding Bits"); 
        int mod512 = originalBitLength % 512; 
        int paddingBits = (mod512 < 448) ? (448 - mod512) : (512 + 448 - mod512); 
        System.out.println("Original message length in bits: " + originalBitLength); 
        System.out.println("Padding bits to add: " + paddingBits); 
        System.out.println(); 
        System.out.println("Step 2: Append Length Bits"); 
        System.out.println("Appending 64-bit length: " + originalBitLength); 
        System.out.println(); 
        System.out.println("Step 3: Initialize MD Buffer"); 
        int initA = 0x67425301, initB = 0xEDFCBA45, initC = 0x98CBADFE, initD = 0x13DCE476; 
        int A = initA, B = initB, C = initC, D = initD; 
        System.out.printf("A = %08x\nB = %08x\nC = %08x\nD = %08x\n\n", A, B, C, D); 
        byte[] block = new byte[16]; 
        for (int i = 0; i < 16; i++) { 
            block[i] = (i < messageBytes.length) ? messageBytes[i] : 0; 
        } 
        int m0 = ((block[0] & 0xff)) | ((block[1] & 0xff) << 8) | ((block[2] & 0xff) << 16) | ((block[3] & 0xff) << 24); 
        int m1 = ((block[4] & 0xff)) | ((block[5] & 0xff) << 8) | ((block[6] & 0xff) << 16) | ((block[7] & 0xff) << 24); 
        int m2 = ((block[8] & 0xff)) | ((block[9] & 0xff) << 8) | ((block[10] & 0xff) << 16) | ((block[11] & 0xff) << 24); 
        int m3 = ((block[12] & 0xff)) | ((block[13] & 0xff) << 8) | ((block[14] & 0xff) << 16) | ((block[15] & 0xff) << 24); 
        System.out.println("Step 4: Process One 512-bit Block"); 
        System.out.println("Operation 1: Using function F (F = (B & C) | (~B & D)) with m0: "+ String.format("%08x", m0)); 
        int T_F = 0xD76AA478, s_F = 7; 
        int temp = A + F(B, C, D) + m0 + T_F; 
        int rotated = Integer.rotateLeft(temp, s_F); 
        int newB = B + rotated; 
        int oldA = A, oldB = B, oldC = C, oldD = D; 
        A = oldD; B = newB; C = oldB; D = oldC; 
        System.out.printf("After F operation:\nA = %08x\nB = %08x\nC = %08x\nD = %08x\n\n", A, B, C, D); 
        System.out.println("Operation 2: Using function G (G = (B & D) | (C & ~D)) with m1: " + String.format("%08x", m1)); 
        int T_G = 0xE8C7B756, s_G = 12; 
        temp = A + G(B, C, D) + m1 + T_G; 
        rotated = Integer.rotateLeft(temp, s_G); 
        newB = B + rotated; 
        oldA = A; oldB = B; oldC = C; oldD = D; 
        A = oldD; B = newB; C = oldB; D = oldC; 
        System.out.printf("After G operation:\nA = %08x\nB = %08x\nC = %08x\nD = %08x\n\n", A, B, C, D); 
        System.out.println("Operation 3: Using function H (H = B ^ C ^ D) with m2: " + String.format("%08x", m2)); 
        int T_H = 0x242070DB, s_H = 17; 
        temp = A + H(B, C, D) + m2 + T_H; 
        rotated = Integer.rotateLeft(temp, s_H); 
        newB = B + rotated; 
        oldA = A; oldB = B; oldC = C; oldD = D; 
        A = oldD; B = newB; C = oldB; D = oldC; 
        System.out.printf("After H operation:\nA = %08x\nB = %08x\nC = %08x\nD = %08x\n\n", A, B, C, D); 
        System.out.println("Operation 4: Using function I (I = C ^ (B | ~D)) with m3: " + String.format("%08x", m3)); 
        int T_I = 0xC1BDCEEE, s_I = 22; 
        temp = A + I(B, C, D) + m3 + T_I; 
        rotated = Integer.rotateLeft(temp, s_I); 
        newB = B + rotated; 
        oldA = A; oldB = B; oldC = C; oldD = D; 
        A = oldD; B = newB; C = oldB; D = oldC; 
        System.out.printf("After I operation:\nA = %08x\nB = %08x\nC = %08x\nD = %08x\n\n", A, B, C, D); 
        A = (A + initA); 
        B = (B + initB); 
        C = (C + initC);
        D = (D + initD); 
        System.out.println("Final MD Buffer Values after 1st iteration (after shift operation):"); 
        System.out.printf("A = %08x\nB = %08x\nC = %08x\nD = %08x\n", A, B, C, D); 
        scanner.close(); 
    } 
}
