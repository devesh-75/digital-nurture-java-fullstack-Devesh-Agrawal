public class PayPalGateway {
    private String username;
    private String password;

    public PayPalGateway(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void makePayment(double amountInDollars) {
        System.out.println("PayPal: authenticating user " + username);
        System.out.println("PayPal: charging $" + amountInDollars);
    }
}
