package challenges.bankCompany;

import java.util.ArrayList;

public class Branch {
    private String name;
    private final String ID;
    private final ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public void printBranchDetails() {
        System.out.println("Branch name: " +  this.getName() + "; branch ID: " + this.getID());
    }

    public void updateBranchName(String newName) {
        this.name = newName;
    }

    public void addCustomer(Customer customer) {
        if (this.customers.contains(customer)) {
            System.out.println("Warn: Customer already exits!!");
            return;
        }
        this.customers.add(customer);
        System.out.println(customer.getFirstName() + " is added successfully!");
    }

    public void deleteCustomer(Customer customer) {
        if (!this.customers.contains(customer)) {
            System.out.println("Warn: Customer do not Exist!!");
            return;
        }
        this.customers.remove(customer);
        System.out.println(customer.getFirstName() + " is removed successfully!");
    }

    public void viewCustomers() {
        for(Customer customer:this.customers) {
            customer.viewProfile();
        }
    }
}
