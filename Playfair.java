//Playfair Cipher

import java.util.*;
public class Playfair {

    public char[][] keyTable;

    public Playfair(String key) {
        keyTable = generateKeyTable(key);

        System.out.println("Key table is");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(keyTable[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private char[][] generateKeyTable(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("X", "I");
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char c : key.toCharArray()) {
            set.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'X') {
                set.add(c);
            }
        }

        char[][] table = new char[5][5];
        Iterator<Character> it = set.iterator();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                table[i][j] = it.next();
            }
        }

        return table;
    }

    private String formatInput(String input) {
        input = input.toUpperCase().replaceAll("[^A-Z]", "").replace("X", "I");
        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < sb.length() - 1; i += 2) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.insert(i + 1, 'J');
            }
        }

        if (sb.length() % 2 != 0) {
            sb.append('J');
        }
        return sb.toString();
    }

    private int[] findPosition(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyTable[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public String encrypt(String plaintext) {
        plaintext = formatInput(plaintext);
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            int[] pos1 = findPosition(plaintext.charAt(i));
            int[] pos2 = findPosition(plaintext.charAt(i + 1));

            if (pos1[0] == pos2[0]) {
                ciphertext.append(keyTable[pos1[0]][(pos1[1] + 1) % 5]);
                ciphertext.append(keyTable[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) {
                ciphertext.append(keyTable[(pos1[0] + 1) % 5][pos1[1]]);
                ciphertext.append(keyTable[(pos2[0] + 1) % 5][pos2[1]]);
            } else {
                ciphertext.append(keyTable[pos1[0]][pos2[1]]);
                ciphertext.append(keyTable[pos2[0]][pos1[1]]);
            }
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {
            int[] pos1 = findPosition(ciphertext.charAt(i));
            int[] pos2 = findPosition(ciphertext.charAt(i + 1));

            if (pos1[0] == pos2[0]) {
                plaintext.append(keyTable[pos1[0]][(pos1[1] + 4) % 5]);
                plaintext.append(keyTable[pos2[0]][(pos2[1] + 4) % 5]);
            } else if (pos1[1] == pos2[1]) {
                plaintext.append(keyTable[(pos1[0] + 4) % 5][pos1[1]]);
                plaintext.append(keyTable[(pos2[0] + 4) % 5][pos2[1]]);
            } else {
                plaintext.append(keyTable[pos1[0]][pos2[1]]);
                plaintext.append(keyTable[pos2[0]][pos1[1]]);
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter key: ");
        String key = input.nextLine();

        Playfair cipher = new Playfair(key);

        System.out.print("Enter text to encrypt: ");
        String text = input.nextLine();

        String encrypted = cipher.encrypt(text);
        System.out.println("Encrypted text: " + encrypted);

        String decrypted = cipher.decrypt(encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}
