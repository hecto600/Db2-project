package app.model;

public class Customer {
    private String customerID = new String();
    private String companyName = new String();
    private String contactName = new String();
    private String contactTitle = new String();
    private String address = new String();
    private String city = new String();
    private String region = new String();
    private String postalCode = new String();
    private String country = new String();
    private String phone = new String();
    private String fax = new String();

    @Override
    public String toString() {
        return "CustomerID: " + customerID +
                "\nCompanyName: " + companyName +
                "\nContactName: " + contactName +
                "\nContactTitle: " + contactTitle +
                "\nAddress: " + address +
                "\nCity: " + city +
                "\nRegion: " + region +
                "\nPostalCode: " + postalCode +
                "\nCountry: " + country +
                "\nPhone: " + phone +
                "\nFax: " + fax;
    }
    
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    
}
