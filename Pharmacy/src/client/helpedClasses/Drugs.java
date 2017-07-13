package client.helpedClasses;

public class Drugs 
{
    int id,quantity,numberOfStripes,price;
    String name,type,productiondate,expirationdate,code,productioncompany;

    public Drugs(int id, int quantity, int numberOfStripes, int price,
                 String name, String type, String productiondate,
                 String expirationdate, String code,
                 String productioncompany) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.numberOfStripes = numberOfStripes;
        this.price = price;
        this.name = name;
        this.type = type;
        this.productiondate = productiondate;
        this.expirationdate = expirationdate;
        this.code = code;
        this.productioncompany = productioncompany;
    }


    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getNumberOfStripes() {
        return numberOfStripes;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getProductiondate() {
        return productiondate;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public String getCode() {
        return code;
    }

    public String getProductioncompany() {
        return productioncompany;
    }
}
