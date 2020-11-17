package challenges.hambergerbompany;

public class BergerCompany {
    private Address address;
    private String name;
    private String owner;
    private double bill;

    public BergerCompany(Address address, String name, String owner) {
        this.address = address;
        this.name = name;
        this.owner = owner;
        this.bill = 0d;
    }

    public double getBill() {
        return bill;
    }

    public void orderBerger() {
        this.orderBerger(CONSTANTS.SIMPLE_BURGER, null, null, null, null, null, null);
    }
    public void orderBerger(String type) {
        orderBerger(type, null, null, null, null, null, null);
    }
    public void orderBerger(String type, AdditionalItem item1) {
        orderBerger(type, item1, null, null, null, null, null);
    }
    public void orderBerger(String type, AdditionalItem item1, AdditionalItem item2) {
        orderBerger(type, item1, item2, null, null, null, null);
    }
    public void orderBerger(String type, AdditionalItem item1, AdditionalItem item2, AdditionalItem item3) {
        orderBerger(type, item1, item2, item3, null, null, null);
    }
    public void orderBerger(String type, AdditionalItem item1, AdditionalItem item2, AdditionalItem item3, AdditionalItem item4) {
        orderBerger(type, item1, item2, item3, item4, null, null);
    }
    public void orderBerger(String type, AdditionalItem item1, AdditionalItem item2, AdditionalItem item3, AdditionalItem item4, AdditionalItem item5) {
        orderBerger(type, item1, item2, item3, item4, item5, null);
    }
    public void orderBerger(String type, AdditionalItem item1, AdditionalItem item2, AdditionalItem item3, AdditionalItem item4, AdditionalItem item5, AdditionalItem item6) {
        if (type.equals(CONSTANTS.SIMPLE_BURGER)) {
            Berger hamBerger = new Berger(item1, item2, item3, item4);
            this.bill += hamBerger.totalCost();
        }
        else if (type.equals(CONSTANTS.DELUXE_BURGER)) {
            BergerDelux bergerDeluxe = new BergerDelux();
            this.bill += bergerDeluxe.totalCost();
        } else {
            BergerHealthy bergerHealthy =  new BergerHealthy(item1, item2, item3, item4, item5, item6);
            this.bill += bergerHealthy.totalCost();
        }
    }

    public void printCompanyDetails () {
        System.out.println("Name: " + this.name );
        System.out.println("Owner: " + this.owner );
        address.printAddress();
    }

    public void printBill() {
        System.out.println("Total bill: " +  this.getBill());
    }
}
