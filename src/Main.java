import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        PasswordHardcoded passwordHardcoded = PasswordHardcoded.getInstance();

        passwordHardcoded.addCredentials("user1", "steveslist");

        passwordHardcoded.printCredentials();
        passwordHardcoded.getCredentials();
    }
}
