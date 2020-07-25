import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;
import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;


public class PasswordHardcoded {

    private static PasswordHardcoded instance = null;
    private HashMap<String, String> passwords;
    private Scanner reader;

    private PasswordHardcoded(){
        this.passwords = new HashMap<>();
        this.reader = new Scanner(System.in);
    }

    public static PasswordHardcoded getInstance(){
        if (instance == null){
            instance = new PasswordHardcoded();
        }
        return instance;
    }

    public void addCredentials(String username, String password) throws NoSuchAlgorithmException {
        if (passwords.containsKey(username)){
            throw new IllegalStateException("Username already exists");
        }
        else {
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            passwords.put(username, new String(Hex.encodeHex(sha256.digest(passwordBytes))));
        }
    }

    public void getCredentials(){
        System.out.print("Username: ");
        String username = reader.next();
        System.out.print("Password: ");
        String password = reader.next();

        if (isValidCredentials(username, password)){
            System.out.println("Valid credentials");
            System.out.println("*the secret of life*");
        }
        else {
            System.out.println("Invalid credentials");
        }
    }

    private boolean isValidCredentials(String username, String password){
        return passwords.containsKey(username) && passwords.get(username).equals(password);
    }

    public void printCredentials(){
        System.out.println(passwords.toString());
    }
}
