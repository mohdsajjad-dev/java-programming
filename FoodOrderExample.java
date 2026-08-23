abstract class FoodOrder {
    abstract double calculateBill();

    void message() {
        System.out.println("Calculating bill for your order...");
    }
}

class DineInOrder extends FoodOrder {
    double baseAmount;
    double serviceChargePercent = 10.0; // 10% service charge for dine-in

    DineInOrder(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    double calculateBill() {
        double serviceCharge = (baseAmount * serviceChargePercent) / 100;
        double total = baseAmount + serviceCharge;
        System.out.println("Dine-In Order Bill:");
        System.out.println("Base Amount: Rs. " + baseAmount);
        System.out.println("Service Charge (10%): Rs. " + serviceCharge);
        return total;
    }
}

class TakeAwayOrder extends FoodOrder {
    double baseAmount;
    double packagingCharge = 20.0; // Flat packaging charge for takeaway

    TakeAwayOrder(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    double calculateBill() {
        double total = baseAmount + packagingCharge;
        System.out.println("Take-Away Order Bill:");
        System.out.println("Base Amount: Rs. " + baseAmount);
        System.out.println("Packaging Charge: Rs. " + packagingCharge);
        return total;
    }
}

public class FoodOrderExample {
    public static void main(String[] args) {
        FoodOrder order1 = new DineInOrder(500.0);
        order1.message();                          // Calls concrete method from FoodOrder
        double total1 = order1.calculateBill();     // Calls DineInOrder's calculateBill method
        System.out.println("Total Bill: Rs. " + total1);

        System.out.println();

        FoodOrder order2 = new TakeAwayOrder(400.0);
        order2.message();                           // Calls concrete method from FoodOrder
        double total2 = order2.calculateBill();      // Calls TakeAwayOrder's calculateBill method
        System.out.println("Total Bill: Rs. " + total2);
    }
}