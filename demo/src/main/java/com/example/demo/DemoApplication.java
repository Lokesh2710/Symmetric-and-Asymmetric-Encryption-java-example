package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import jakarta.xml.bind.DatatypeConverter;

@SpringBootApplication
public class DemoApplication {
    
   private static final String RSA = "RSA";

   // Generating public & private keys
   // using RSA algorithm.
   public static KeyPair generateRSAKkeyPair() throws Exception
   {
       SecureRandom secureRandom = new SecureRandom();
       KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);

       keyPairGenerator.initialize(2048, secureRandom);
       
       return keyPairGenerator.generateKeyPair();
   }

   // Encryption function which converts
   // the plainText into a cipherText
   // using private Key.
   
   public static byte[] do_RSAEncryption(String plainText,PrivateKey privateKey) throws Exception
   {
       Cipher cipher = Cipher.getInstance(RSA);

       cipher.init(Cipher.ENCRYPT_MODE, privateKey);

       return cipher.doFinal(plainText.getBytes());
       
   }

   
   // Decryption function which converts
   // the ciphertext back to the
   // orginal plaintext.
   
   public static String do_RSADecryption(byte[] cipherText,PublicKey publicKey) throws Exception
   {
       Cipher cipher = Cipher.getInstance(RSA);

       cipher.init(Cipher.DECRYPT_MODE,publicKey);
       
       byte[] result = cipher.doFinal(cipherText);

       return new String(result);
   }

   // Driver code
   public static void main(String args[]) throws Exception
   {
       KeyPair keypair = generateRSAKkeyPair();

       String text = " Flower on the path ";
     
       byte[] cipherText = do_RSAEncryption(text,keypair.getPrivate());

       System.out.println("Public Key : " + DatatypeConverter.printHexBinary(keypair.getPublic().getEncoded()));

       System.out.println("Private Key : " + DatatypeConverter.printHexBinary(keypair.getPrivate().getEncoded()));

       System.out.println("Original text : "+ text );
       
       System.out.print("Encrypted Text (using Private key ) : ");

       System.out.println(DatatypeConverter.printHexBinary(cipherText));

       String decryptedText = do_RSADecryption(cipherText,keypair.getPublic());

       System.out.println("Decrypted Text (using Public key ) : "+ decryptedText);
   }
}