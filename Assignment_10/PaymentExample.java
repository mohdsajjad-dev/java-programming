abstract class Payment {
    abstract void pay(double amount);

    void message() {
        System.out.println("Processing payment through the selected method.");
    }
}

class CreditCardPayment extends Payment {
    void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using Credit Card.");
    }
}

class UPIPayment extends Payment {
    void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using UPI.");
    }
}

public class PaymentExample {
    public static void main(String[] args) {
        Payment payment1 = new CreditCardPayment();
        payment1.pay(2500.0);       // Calls Credit Card's pay method
        payment1.message();         // Calls concrete method from Payment

        Payment payment2 = new UPIPayment();
        payment2.pay(500.0);        // Calls UPI's pay method
        payment2.message();         // Calls concrete method from Payment
    }
}
