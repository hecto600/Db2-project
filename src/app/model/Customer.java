package app.model;

public class Customer {
    private String customerID;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String addres;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;

    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactTitle() {
        return contactTitle;
    }
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }
    public String getAddres() {
        return addres;
    }
    public void setAddres(String addres) {
        this.addres = addres;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    @Override
    public String toString(){
        return 
            "CustomerID: "      + customerID    +
            "\nCompanyName: "   + companyName   +
            "\nContactName: "   + contactName   +          
            "\nContactTitle: "  + contactTitle  +          
            "\nAddres: "        + addres        +          
            "\nCity: "          + city          +          
            "\nRegion: "        + region        +          
            "\nPostalCode: "    + postalCode    +          
            "\nCountry: "       + country       +          
            "\nPhone: "         + phone         +       
            "\nFax: "           + fax;
    }
}
