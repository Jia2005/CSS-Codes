//Diffie-Hellman Key Exchange Algorithm
import java.util.*;

class Diffie {
    private static long power(long a, long b, long p) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % p;
            }
            a = (a * a) % p;
            b = b / 2;
        }
        return result;
    }
   
    private static boolean isPrimitiveRoot(long g, long p) {
        if (g <= 0 || g >= p) return false;
       
        Set<Long> powers = new HashSet<>();
        for (long i = 1; i < p; i++) {
            long powerMod = power(g, i, p);
            if (powers.contains(powerMod)) {
                return false;
            }
            powers.add(powerMod);
        }
        return powers.size() == p - 1;
    }
   
    private static long findPrimitiveRoot(long p) {
        System.out.println("Finding primitive root for " + p + ":");
        for (long g = 1; g < p; g++) {
            System.out.println("Checking if " + g + " is a primitive root of " + p);
            if (isPrimitiveRoot(g, p)) {
                System.out.println(g + " is a primitive root of " + p);
                System.out.println("Powers of " + g + " mod " + p + ":");
                for (long i = 0; i < p-1; i++) {
                    System.out.println(g + "^" + i + " mod " + p + " = " + power(g, i, p));
                }
                return g;
            } else {
                System.out.println(g + " is not a primitive root of " + p);
            }
        }
        return -1;
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long P, G, x, a, y, b, ka, kb, gxy;
       
        System.out.print("Enter the value of P: ");
        P = sc.nextLong();
       
        G = findPrimitiveRoot(P);
        if (G == -1) {
            System.out.println("No primitive root found. Please check if P is prime.");
            return;
        }
        System.out.println("Using G = " + G + " as primitive root of " + P);
        System.out.print("Enter the private key a for Alice: ");
        a = sc.nextLong();
        x = power(G, a, P);
        System.out.println("R1 = " + G + "^" + a + " mod " + P + " = " + x);
        System.out.print("Enter the private key b for Bob: ");
        b = sc.nextLong();
        y = power(G, b, P);
        System.out.println("R2 = " + G + "^" + b + " mod " + P + " = " + y);
        System.out.print("Secret key for Alice: ");
        ka = power(y, a, P);
        System.out.println("(" + y + "^" + a + ") mod " + P + " = " + ka);
        System.out.print("Secret key for Bob: ");
        kb = power(x, b, P);
        System.out.println("(" + x + "^" + b + ") mod " + P + " = " + kb);
        gxy = power(G, (a * b), P);
        System.out.println("g^(xy) mod P = " + gxy);
        if (ka == kb) {
            System.out.println("The shared secret key is verified: " + ka);
        } else {
            System.out.println("The keys do not match!");
        }
    }
}
