class MobilePhone {
    String brand;
    String model;
    double price;
    int quantity;
    String color;
    int storageGB;

    // Default Constructor: Initializes with default values
    MobilePhone() {
        System.out.println("-----Inside the Default Constructor-----");
        brand = "Unknown";
        model = "Unknown";
        price = 0.0;
        quantity = 0;
        color = "Not Specified";
        storageGB = 0;
    }

    // Parameterized Constructor: Initializes with specific values
    MobilePhone(String b, String m, double p, int q, String c, int s) {
        System.out.println("-----Inside the Parameterized Constructor-----");
        this.brand = b;
        this.model = m;
        this.price = p;
        this.quantity = q;
        this.color = c;
        this.storageGB = s;
    }

    // Copy Constructor: Initializes using an existing MobilePhone object (creates duplicate record)
    MobilePhone(MobilePhone m1) {
        System.out.println("-----Inside the Copy Constructor-----");
        this.brand = m1.brand;
        this.model = m1.model;
        this.price = m1.price;
        this.quantity = m1.quantity;
        this.color = m1.color;
        this.storageGB = m1.storageGB;
    }

    // Method to display mobile phone details
    void display() {
        System.out.println("Brand: " + brand +
                           "\nModel: " + model +
                           "\nColor: " + color +
                           "\nStorage: " + storageGB + "GB" +
                           "\nPrice: Rs." + price +
                           "\nQuantity: " + quantity);
    }

    public static void main(String[] args) {
        // 1. Creating an object using the Default Constructor
        MobilePhone m0 = new MobilePhone();
        m0.display();

        // 2. Creating an object using the Parameterized Constructor
        MobilePhone m1 = new MobilePhone("Samsung", "Galaxy S23", 74999.0, 15, "Phantom Black", 256);
        m1.display();

        // 3. Creating a duplicate record using the Copy Constructor
        MobilePhone m2 = new MobilePhone(m1);
        m2.display();
    }
}