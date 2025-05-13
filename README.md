# 🔐 Crypto Codes

<div align="center">

![GitHub last commit](https://img.shields.io/github/last-commit/Jia2005/CSS-codes?color=green&style=for-the-badge)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/Jia2005/CSS-codes?color=blue&style=for-the-badge)

<img src="https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExYTNlODY5MzkzMWQ2NDBjNDkyZDJhNjA1NjA1MjJhZmI3MTBlNWNjMiZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PWc/077i6AULCXc0FKTj9s/giphy.gif" width="300px">

</div>

Hey there! 👋 Welcome to my collection of cryptography algorithms implemented from your college assignments. 

This repo contains various encryption, hashing, and key exchange implementations for learning and educational purposes.

## 🔒 Symmetric Encryption

| Algorithm | Description | Time Complexity |
|-----------|-------------|-----------------|
| **Caesar** | The classic substitution cipher that shifts characters by a fixed offset | O(n) |
| **Playfair** | Digraph substitution cipher that encrypts pairs of letters | O(n) |

<details>
<summary>💡 Example usage (click to expand)</summary>

```java
// Caesar cipher example
String plaintext = "HELLO";
int shift = 3;
String encrypted = caesar.encrypt(plaintext, shift);  // Returns "KHOOR"
```

</details>

## 🔑 Asymmetric Encryption

| Algorithm | Description | Security |
|-----------|-------------|----------|
| **RSA** | Public-key cryptosystem for secure data transmission | Based on factoring large integers |
| **Diffie-Hellman** | Method for securely exchanging cryptographic keys over public channels | Based on discrete logarithm problem |

<details>
<summary>⚙️ Implementation details (click to expand)</summary>

```java
// RSA simplified example
KeyPair keys = RSA.generateKeyPair(1024);
String encrypted = RSA.encrypt("Secret message", keys.publicKey);
String decrypted = RSA.decrypt(encrypted, keys.privateKey);
```

</details>

## 🧮 Hashing Algorithms

| Algorithm | Description | Output Size |
|-----------|-------------|------------|
| **MD5** | Widely used hash function producing a 128-bit hash value | 128 bits (16 bytes) |

## 🧠 Math Utilities

| Utility | Description | Used In |
|---------|-------------|---------|
| **Euclidean** | Algorithms for computing GCD and modular inverse | RSA, many crypto systems |
| **Buffer_Overflow** | Demonstration of memory vulnerability | Security testing |

## 📖 How to Run

### ☕ Java Implementations

```bash
# Compile the Java file
javac RSA.java

# Run the program
java RSA

# Example output:
# Generated keys: (public_key, private_key)
# Encrypted: a7f12d8e...
# Decrypted: Hello, world!
```

### 🔧 C Implementations

```bash
# Compile with gcc
gcc Buffer_Overflow.c -o buffer

# Run the executable
./buffer

# Example output:
# Demonstrating buffer overflow vulnerability...
```

## 🤝 Contributing

Found a bug? Have a better implementation? Want to add a new algorithm? I'd love your help!

```bash
# Fork this repository
# Create your feature branch
git checkout -b cool-new-feature

# Commit your changes
git commit -m 'Added an awesome crypto algorithm'

# Push to the branch
git push origin cool-new-feature

# Open a Pull Request 🎉
```

## ⭐ Support

If this repo helped you understand crypto concepts better, consider giving it a star! Each star motivates me to add more algorithms and improve the existing ones! ✨

<div align="center">
<img src="https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExYzNmYTdjMDhiNWM0NmMxZDExYmVkNGZkMDk0NWE0NzcwZjFkZjM5YSZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PWc/LmNwrBhejkK9EFP504/giphy.gif" width="200px">
</div>
