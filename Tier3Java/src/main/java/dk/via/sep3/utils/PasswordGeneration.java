package dk.via.sep3.utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

public class PasswordGeneration {
    private static final int SALT_LENGTH = 16;
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 128;

    private PasswordGeneration() {
        throw new IllegalStateException("Utility class");
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        byte[] hash = factory.generateSecret(keySpec).getEncoded();

        // Combine salt and hash and encode as Base64 or store separately in the database
        byte[] combined = concatenateByteArrays(salt, hash);
        return Base64.getEncoder().encodeToString(combined);
    }

    public static boolean verifyPassword(String enteredPassword, String storedPassword) throws InvalidKeySpecException, NoSuchAlgorithmException
    {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] decodedStoredPassword = Base64.getDecoder().decode(storedPassword);

        // Extract salt and hash from storedPassword
        byte[] salt = Arrays.copyOfRange(decodedStoredPassword, 0, SALT_LENGTH);
        byte[] storedHash = Arrays.copyOfRange(decodedStoredPassword, SALT_LENGTH, decodedStoredPassword.length);

        KeySpec keySpec = new PBEKeySpec(enteredPassword.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        byte[] enteredHash = factory.generateSecret(keySpec).getEncoded();

        return Arrays.equals(enteredHash, storedHash);
    }

    private static byte[] concatenateByteArrays(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
}
