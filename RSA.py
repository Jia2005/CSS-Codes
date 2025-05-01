//RSA
import java.util.Scanner; 
public class RSA { 
    public static int power(int base, int expo, int m) { 
        int res = 1; 
        base = base % m; 
        while (expo > 0) { 
            if ((expo & 1) == 1) { 
                res = (res * base) % m; 
            } 
            base = (base * base) % m; 
            expo = expo / 2; 
        } 
        return res; 
    } 
    public static int modInverse(int e, int phi) { 
        for (int d = 2; d < phi; d++) { 
            if ((e * d) % phi == 1) { 
                return d; 
            } 
        } 
        return -1; 
    } 
    public static int gcd(int a, int b) { 
        while (b != 0) { 
            int temp = b; 
            b = a % b; 
            a = temp; 
        } 
        return a; 
    } 
    public static int[] findPrimes(int n) { 
        int p = 0, q = 0; 
        for (int i = 2; i <= Math.sqrt(n); i++) { 
            if (n % i == 0) { 
                p = i; 
                q = n / i; 
                break; 
            } 
        } 
        return new int[] { p, q }; 
    } 
    public static int encrypt(int m, int e, int n) { 
        return power(m, e, n); 
    } 
    public static int decrypt(int c, int d, int n) {
        return power(c, d, n); 
    } 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
 
        System.out.print("Enter public key (n): "); 
        int n = scanner.nextInt(); 
        System.out.print("Enter public exponent (e): "); 
        int e = scanner.nextInt(); 
        System.out.print("Enter message to encrypt (M): "); 
        int M = scanner.nextInt(); 
        System.out.println("\nEncryption key : ( "+e+", "+n+" )\n"); 
        int[] primes = findPrimes(n); 
        int p = primes[0]; 
        int q = primes[1]; 
        System.out.println("Prime factors of n: p = " + p + ", q = " + q); 
        int phi = (p - 1) * (q - 1); 
        System.out.println("Calculated phi(n) = "+(p-1)+" * "+(q-1)+" = " + phi); 
        int d = modInverse(e, phi); 
        System.out.println("Private key (d): " + d); 
        int C = encrypt(M, e, n); 
        System.out.println("Encrypted Message (C): " + C); 
        int decrypted = decrypt(C, d, n); 
        System.out.println("Decrypted Message: " + decrypted); 
    } 
} 
