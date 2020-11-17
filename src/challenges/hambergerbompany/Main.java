package challenges.hambergerbompany;

public class Main {
    public static void main(String[] args) {
        Address billsAddress = new Address(
                "102",
                "Liverpool St",
                "London",
                "ew1 2e4"
            );
        BergerCompany bills = new BergerCompany(billsAddress, "Bill's Berger", "Bill");

        bills.printCompanyDetails();
        bills.orderBerger();
        bills.orderBerger(
            CONSTANTS.HEALTHY_BURGER,
            addItems(CONSTANTS.ITEM_CARROT),
            addItems(CONSTANTS.ITEM_CHEESE),
            addItems(CONSTANTS.ITEM_SWEETCORN),
            addItems(CONSTANTS.ITEM_LETTUCE),
            addItems(CONSTANTS.ITEM_TOMATO)
        );
        bills.orderBerger(CONSTANTS.DELUXE_BURGER);
        bills.printBill();
    }

    public static AdditionalItem addItems(String itemName) {
        switch(itemName) {
            case CONSTANTS.ITEM_CARROT:
                AdditionalItem carrot = new AdditionalItem(CONSTANTS.ITEM_CARROT, 0.20d);
                return carrot;
            case CONSTANTS.ITEM_SWEETCORN:
                AdditionalItem sweetCorn = new AdditionalItem(CONSTANTS.ITEM_SWEETCORN, 0.30d);
                return sweetCorn;
            case CONSTANTS.ITEM_CHEESE:
                AdditionalItem cheese = new AdditionalItem(CONSTANTS.ITEM_CHEESE, 0.10d);
                return cheese;
            case CONSTANTS.ITEM_LETTUCE:
                AdditionalItem lettuce = new AdditionalItem(CONSTANTS.ITEM_LETTUCE, 0.20d);
                return lettuce;
            case CONSTANTS.ITEM_CUCUMBER:
                AdditionalItem cucumber = new AdditionalItem(CONSTANTS.ITEM_CUCUMBER, 0.05d);
                return cucumber;
            case CONSTANTS.ITEM_TOMATO:
                AdditionalItem tomato = new AdditionalItem(CONSTANTS.ITEM_TOMATO, 0.05d);
                return tomato;
            default:
                return null;
        }
    }
}
