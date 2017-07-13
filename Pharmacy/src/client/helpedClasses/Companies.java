package client.helpedClasses;

public class Companies {
    int id;
    String name,phone,website,facebook,branch,salesRepresentativeName,representativePhone;

    public Companies(int id, String name, String phone, String website,
                     String facebook, String branch,
                     String salesRepresentativeName,
                     String representativePhone) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.facebook = facebook;
        this.branch = branch;
        this.salesRepresentativeName = salesRepresentativeName;
        this.representativePhone = representativePhone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getBranch() {
        return branch;
    }

    public String getSalesRepresentativeName() {
        return salesRepresentativeName;
    }

    public String getRepresentativePhone() {
        return representativePhone;
    }
}