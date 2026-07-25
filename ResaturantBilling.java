class RestaurantBilling {
    static int totalOrders; // static variable to track total orders across all bill types
    double billAmount = 0;

    // Default Constructor
    RestaurantBilling() {
        billAmount = 0;
    }

    // Overloaded method: calculates bill for dine-in orders (includes service charge)
    double calculateBill(double amount, double serviceCharge) {
        totalOrders++;
        billAmount = amount + serviceCharge;
        return billAmount;
    }

    // Overloaded method: calculates bill for takeaway orders (no extra charge)
    double calculateBill(double amount) {
        totalOrders++;
        billAmount = amount;
        return billAmount;
    }

    // Overloaded method: calculates bill for delivery orders (includes delivery fee)
    double calculateBill(double amount, double deliveryFee, boolean isDelivery) {
        totalOrders++;
        billAmount = amount + deliveryFee;
        return billAmount;
    }

    // Method to display total orders processed
    void show() {
        System.out.println("Total Orders Processed: " + RestaurantBilling.totalOrders);
    }

    public static void main(String[] args) {
        RestaurantBilling billing = new RestaurantBilling();

        // 1. Dine-in order with service charge
        double dineInBill = billing.calculateBill(500.0, 50.0);
        System.out.println("Dine-In Bill: Rs." + dineInBill);

        // 2. Takeaway order without service charge
        double takeawayBill = billing.calculateBill(300.0);
        System.out.println("Takeaway Bill: Rs." + takeawayBill);

        // 3. Delivery order with delivery fee
        double deliveryBill = billing.calculateBill(400.0, 40.0, true);
        System.out.println("Delivery Bill: Rs." + deliveryBill);

        // Displaying total orders using static variable
        billing.show();
    }
}