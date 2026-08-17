class Vehicle {
    String vehicleNumber, model;
    int manufactureYear;

    Vehicle(String vehicleNumber, String model, int manufactureYear) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.manufactureYear = manufactureYear;
    }

    void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Model: " + model);
        System.out.println("Manufacture Year: " + manufactureYear);
    }
}

class Insurance extends Vehicle {
    String policyNumber;
    double premiumAmount;

    Insurance(String vehicleNumber, String model, int year,
              String policyNumber, double premiumAmount) {
        super(vehicleNumber, model, year);
        this.policyNumber = policyNumber;
        this.premiumAmount = premiumAmount;
    }

    void displayInsuranceInfo() {
        super.displayVehicleInfo();
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Premium Amount: " + premiumAmount);
    }
}

class CarInsurance extends Insurance {
    double idv;

    CarInsurance(String no, String model, int year,
                 String policy, double premium, double idv) {
        super(no, model, year, policy, premium);
        this.idv = idv;
    }

    void displayDetails() {
        super.displayInsuranceInfo();
        System.out.println("IDV: " + idv);
        System.out.println("Vehicle Type: Car");
    }
}

public class VehicleInsuranceSystem {
    public static void main(String[] args) {
        CarInsurance car = new CarInsurance(
            "MH12AB1234", "Honda City", 2022,
            "POL1001", 15000, 850000
        );

        car.displayDetails();
    }
}
