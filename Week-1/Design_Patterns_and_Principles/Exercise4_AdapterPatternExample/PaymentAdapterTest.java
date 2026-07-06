public class PaymentAdapterTest {
    public static void main(String[] args) {
        PayPalGateway payPalGateway = new PayPalGateway("ADITYA", "ay5155");
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        payPalProcessor.processPayment(150.0);

        StripeGateway stripeGateway = new StripeGateway("sk_test_ADITYA_ay5155");
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        stripeProcessor.processPayment(75.5);
    }
}
