package medicineBilling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Bill {
    private Patient patient;
    private List<Medicine> medicines;
    private double totalAmount;
    private String paymentMode;

    public Bill(Patient patient, List<Medicine> medicines, String paymentMode) {
        this.patient = patient;
        this.medicines = medicines;
        this.paymentMode = paymentMode;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        double total = 0;
        for (Medicine medicine : medicines) {
            total += medicine.getTotalPrice();
        }
        return total;
    }

    public void generateBill(String location) throws IOException {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateTime = LocalDateTime.now().format(formatter);

        File billFile = new File(location + File.separator
                + patient.getName() + "_" + System.currentTimeMillis() + ".txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(billFile))) {

            bw.write("\t\tJava Multispeciality Hospital");
            bw.newLine();
            bw.write("\t\tAddress: Java nagar");
            bw.newLine();
            bw.write("\t\tPh: " + patient.getMobile());
            bw.newLine();
            bw.write("Date & Time: " + dateTime);
            bw.newLine();
            bw.write("--------------------------------------------------");
            bw.newLine();

            bw.write("PATIENT NAME  : " + patient.getName());
            bw.newLine();
            bw.write("PATIENT AGE   : " + patient.getAge());
            bw.newLine();

            bw.write("--------------------------------------------------");
            bw.newLine();
            bw.write("MEDICINE----->QTY----->PRICE----->TOTAL");
            bw.newLine();
            bw.write("--------------------------------------------------");

            for (Medicine m : medicines) {
                bw.newLine();
                bw.write(m.getName() + "----->"
                        + m.getQuantity() + "----->"
                        + m.getPrice() + "----->"
                        + m.getTotalPrice());
            }

            bw.newLine();
            bw.write("--------------------------------------------------");
            bw.newLine();
            bw.write("TOTAL AMOUNT : " + totalAmount);
            bw.newLine();
            bw.write("PAYMENT MODE : " + paymentMode);
            bw.newLine();
            bw.write("PAYMENT STATUS : Done");
            bw.newLine();
            bw.write("--------------------------------------------------");
            bw.newLine();
            bw.newLine();
            bw.write("\t\t\tDoctor's Signature");
        }
    }
}
