package challenges.hambergerbompany;

public class Berger {
    private String name;
    private String type;
    private double cost;
    private AdditionalItem item1;
    private AdditionalItem item2;
    private AdditionalItem item3;
    private AdditionalItem item4;

    public Berger(AdditionalItem item1, AdditionalItem item2, AdditionalItem item3, AdditionalItem item4) {
        this("Simple", CONSTANTS.SIMPLE_BURGER, 2, item1, item2, item3, item4);
    }
    public Berger(String name, String type, double cost) {
        this(name, type, cost, null, null, null, null);
    }

    public Berger(
            String name,
            String type,
            double cost,
            AdditionalItem item1,
            AdditionalItem item2,
            AdditionalItem item3,
            AdditionalItem item4
            ) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
    }

    public double totalCost() {
        double totalCost = this.cost;
        System.out.println(this.name + " burger cost: " + this.cost);

        if (this.item1 != null ) {
            System.out.println("Added: " + item1.getName() + " + " + item1.getCost());
            totalCost += item1.getCost();
        }

        if (this.item2 != null ) {
            System.out.println("Added: " + item2.getName() + " + " + item2.getCost());
            totalCost += item2.getCost();
        }
        if (this.item3 != null ) {
            System.out.println("Added: " + item3.getName() + " + " + item3.getCost());
            totalCost += item3.getCost();
        }
        if (this.item4 != null ) {
            System.out.println("Added: " + item4.getName() + " + " + item4.getCost());
            totalCost += item4.getCost();
        }

        return totalCost;
    }
}
