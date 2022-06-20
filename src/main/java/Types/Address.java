package Types;

public class Address {

    private String street1;

    private String street2;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    public static Address mockBuyerAddress() {

        Address a = new Address();
        a.street1 = "B_S1";
        a.street2 = "B_S2";
        a.city = "B.c";
        a.country = "B.cy";
        a.postalCode = "B.p";
        a.state = "B.s";
        return a;
    }

    public static Address mockSellerAddress() {

        Address a = new Address();
        a.street1 = "S_S1";
        a.street2 = "S_S2";
        a.city = "S.c";
        a.country = "S.cy";
        a.postalCode = "S.p";
        a.state = "S.s";
        return a;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
