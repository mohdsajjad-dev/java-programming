class Product {
    String name;
    double price;

    void displayCommonDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }
}

interface ProductInterface {
    void displayProduct();
}

class Electronic extends Product implements ProductInterface {
    Electronic() {
        name = "Laptop";
        price = 50000;
    }

    public void displayProduct() {
        displayCommonDetails();
        System.out.println("Category: Electronic");
    }
}

class Clothing extends Product implements ProductInterface {
    Clothing() {
        name = "T-Shirt";
        price = 800;
    }

    public void displayProduct() {
        displayCommonDetails();
        System.out.println("Category: Clothing");
    }
}

class Grocery extends Product implements ProductInterface {
    Grocery() {
        name = "Rice";
        price = 600;
    }

    public void displayProduct() {
        displayCommonDetails();
        System.out.println("Category: Grocery");
    }
}

public class EcommerceProductSystem {
    public static void main(String[] args) {
        Electronic electronic = new Electronic();
        Clothing clothing = new Clothing();
        Grocery grocery = new Grocery();

        electronic.displayProduct();

        clothing.displayProduct();

        grocery.displayProduct();
    }
}
