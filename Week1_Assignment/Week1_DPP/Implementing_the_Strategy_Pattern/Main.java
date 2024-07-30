public class Main {

    // Strategy interface
    interface PaymentStrategy {
        void pay(int amount);
    }

    // Concrete strategy for credit card payments
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
        }
    }

    // Concrete strategy for PayPal payments
    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using PayPal: " + email);
        }
    }

    // Context class
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public PaymentContext(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(int amount) {
            paymentStrategy.pay(amount);
        }
    }

    // Main class to test the implementation
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432");
        PaymentStrategy payPal = new PayPalPayment("user@example.com");

        PaymentContext context = new PaymentContext(creditCard);
        context.executePayment(100);

        context = new PaymentContext(payPal);
        context.executePayment(200);
    }
}
