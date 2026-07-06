public class PayPalPayment implements PaymentStrategy {
    private String username;
    private String password;

    public PayPalPayment(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Authenticating " + username + " with PayPal");
        System.out.println("Paid $" + amount + " using PayPal");
    }
}
