package wingsteven.passman;

public class App {
    static final String GREETING = "Welcome to PassMan, the passphrase manager!";

	public String getGreeting() {
        return GREETING;
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
