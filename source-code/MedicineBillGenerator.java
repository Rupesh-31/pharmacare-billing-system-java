package medicineBilling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicineBillGenerator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter patient age: ");
        int age = sc.nextInt();

        System.out.print("Enter mobile number: ");
        long mobile = sc.nextLong();
        sc.nextLine();

        Patient patient = new Patient(name, age, mobile);

        System.out.print("Enter number of medicines: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Medicine> medicines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Medicine name: ");
            String medName = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            medicines.add(new Medicine(medName, price, qty));
        }

        System.out.print("Payment mode (Cash / UPI / Card): ");
        String paymentMode = sc.nextLine();

        System.out.print("Enter bill save location: ");
        String location = sc.nextLine();

        Bill bill = new Bill(patient, medicines, paymentMode);

        try {
            bill.generateBill(location);
            System.out.println("Bill generated successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

//output:

//Enter patient name: Jdk
//Enter patient age: 99
//Enter mobile number: 9988774433
//Enter number of medicines: 2
//Medicine name: paracitamol
//Price: 2
//Quantity: 10
//Medicine name: amoxyline
//Price: 2
//Quantity: 10
//Payment mode (Cash / UPI / Card): upi
//Enter bill save location: D:\
//Bill generated successfully!