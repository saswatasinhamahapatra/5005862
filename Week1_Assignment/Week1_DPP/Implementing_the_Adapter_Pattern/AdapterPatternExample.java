// AdapterPatternExample.java

// Step 1: Define Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 2: Implement Adaptee Classes
class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class Stripe {
    public void makePayment(double amount) {
        System.out.println("Processing Stripe payment of $" + amount);
    }
}

class Square {
    public void executePayment(double amount) {
        System.out.println("Processing Square payment of $" + amount);
    }
}

// Step 3: Implement the Adapter Class
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

class SquareAdapter implements PaymentProcessor {
    private Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.executePayment(amount);
    }
}

// Step 4: Test the Adapter Implementation
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentProcessor squareProcessor = new SquareAdapter(new Square());

        payPalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
        squareProcessor.processPayment(300.00);
    }
}

