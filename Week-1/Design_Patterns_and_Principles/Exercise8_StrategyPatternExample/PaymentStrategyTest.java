public class PaymentStrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("4111111111111234"));
        context.executePayment(250.0);

        context.setPaymentStrategy(new PayPalPayment("ADITYA", "ay5155"));
        context.executePayment(89.99);
    }
}
