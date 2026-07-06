public class StripeGateway {
    private String apiKey;

    public StripeGateway(String apiKey) {
        this.apiKey = apiKey;
    }

    public void charge(int amountInCents) {
        System.out.println("Stripe: using key " + apiKey);
        System.out.println("Stripe: charging " + amountInCents + " cents");
    }
}
