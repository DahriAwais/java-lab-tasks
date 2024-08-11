class MobilePhone {
    private String brand;
    private String model;
    private double price;
    private int storageCapacity; // in GB

    // Constructor
    public MobilePhone(String brand, String model, double price, int storageCapacity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.storageCapacity = storageCapacity;
    }

    // Method to display phone details
    public void displayPhoneDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }

    // Method to compare prices of two phones
    public static void comparePrices(MobilePhone phone1, MobilePhone phone2) {
        if (phone1.price < phone2.price) {
            System.out.println(phone1.model + " is cheaper than " + phone2.model);
        } else if (phone1.price > phone2.price) {
            System.out.println(phone1.model + " is more expensive than " + phone2.model);
        } else {
            System.out.println(phone1.model + " and " + phone2.model + " have the same price.");
        }
    }

    // Method to check if a phone meets specific storage requirements
    public boolean meetsStorageRequirement(int minimumStorage) {
        return this.storageCapacity >= minimumStorage;
    }

    // Getter for storage capacity
    public int getStorageCapacity() {
        return storageCapacity;
    }
}

public class MobilePhoneInformation {
    public static void main(String[] args) {
        // Creating an array of MobilePhone objects
        MobilePhone[] phones = {
                new MobilePhone("Apple", "iPhone 14", 999.99, 128),
                new MobilePhone("Samsung", "Galaxy S22", 849.99, 256),
                new MobilePhone("Google", "Pixel 7", 599.99, 128),
                new MobilePhone("OnePlus", "9 Pro", 729.99, 512)
        };

        // Display details of each phone
        for (MobilePhone phone : phones) {
            phone.displayPhoneDetails();
            System.out.println();
        }

        // Compare prices of two phones
        System.out.println("Comparing prices of iPhone 14 and Galaxy S22:");
        MobilePhone.comparePrices(phones[0], phones[1]);
        System.out.println();

        // Check if a phone meets a specific storage requirement
        int requiredStorage = 256;
        System.out.println("Checking if phones meet at least " + requiredStorage + "GB storage:");
        for (MobilePhone phone : phones) {
            if (phone.meetsStorageRequirement(requiredStorage)) {
                System.out.println(phone.getStorageCapacity() + "GB is sufficient.");
            } else {
                System.out.println(phone.getStorageCapacity() + "GB is insufficient.");
            }
        }
        System.out.println();

        // Find the phone with the highest storage capacity
        MobilePhone highestStoragePhone = phones[0];
        for (MobilePhone phone : phones) {
            if (phone.getStorageCapacity() > highestStoragePhone.getStorageCapacity()) {
                highestStoragePhone = phone;
            }
        }

        System.out.println("The phone with the highest storage capacity is:");
        highestStoragePhone.displayPhoneDetails();
    }
}
