package client.helpedClasses;

public class Saless {
    int id;
    double tatalPrice;
    String customerName,drugName,processDate;

    public Saless(int id, double tatalPrice, String customerName,
                  String drugName, String processDate) {
        super();
        this.id = id;
        this.tatalPrice = tatalPrice;
        this.customerName = customerName;
        this.drugName = drugName;
        this.processDate = processDate;
    }

    public int getId() {
        return id;
    }

    public double getTatalPrice() {
        return tatalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getProcessDate() {
        return processDate;
    }
}
