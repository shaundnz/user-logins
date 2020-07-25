public class Main {

    public static void main(String[] args){
        PasswordHardcoded passwordHardcoded = PasswordHardcoded.getInstance();

        passwordHardcoded.addCredentials("John", "Doe");
        passwordHardcoded.addCredentials("Jane", "Doe");

        passwordHardcoded.getCredentials();
    }
}
