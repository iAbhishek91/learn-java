package challenges.hambergerbompany;

public class Address {
    private String shopNumber;
    private String street;
    private String city;
    private String postCode;

    public Address(String shopNumber, String street, String city, String postCode) {
        this.shopNumber = shopNumber;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
    }

    public void printAddress() {
        System.out.println(
                "Shop Number: " + this.shopNumber +
                "; Street: " + this.street +
                "; City: " + this.city +
                "; Postcode: " + this.postCode
        );
    }
}
