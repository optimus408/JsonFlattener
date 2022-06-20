package types;

public class User {

    private String id;

    private String loginName;

    private String firstName;

    private String lastName;

    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static User mockBuyer() {

        User b = new User();
        b.setFirstName("Buyer_F");
        b.setId("11111111111");
        b.setLoginName("buyerLogin");
        b.setLastName("Buyer_L");
        b.setAddress(Address.mockBuyerAddress());

        return b;

    }

    public static User mockSeller() {

        User b = new User();
        b.setFirstName("Seller_F");
        b.setId("2222222222");
        b.setLoginName("sellerLogin");
        b.setLastName("Seller_L");
        b.setAddress(Address.mockSellerAddress());

        return b;

    }
}
