package challenges.hambergerbompany;

public class BergerHealthy extends Berger {
    private AdditionalItem item5;
    private AdditionalItem item6;

    public BergerHealthy(AdditionalItem item1, AdditionalItem item2, AdditionalItem item3, AdditionalItem item4, AdditionalItem item5, AdditionalItem item6) {
        this("Healthy", CONSTANTS.HEALTHY_BURGER, 3, item1, item2, item3, item4, item5, item6);
    }
    public BergerHealthy(String name, String type, double cost, AdditionalItem item1, AdditionalItem item2, AdditionalItem item3, AdditionalItem item4, AdditionalItem item5, AdditionalItem item6) {
        super(name, type, cost, item1, item2, item3, item4);
        this.item5 = item5;
        this.item6 = item6;
    }

    @Override
    public double totalCost() {
        double totalCost = super.totalCost();
        if (this.item5 != null ) {
            System.out.println("Added: " + item5.getName() + " + " + item5.getCost());
            totalCost += item5.getCost();
        }

        if (this.item6 != null ) {
            System.out.println("Added: " + item6.getName() + " + " + item6.getCost());
            totalCost += item6.getCost();
        }

        return totalCost;
    }
}
