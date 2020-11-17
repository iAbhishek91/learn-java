package challenges.bankcompany;

import java.util.ArrayList;

public class Bank {
    private final String name;
    private final ArrayList<Branch> branches;

    public Bank(String name, ArrayList<Branch> branches) {
        this.name = name;
        this.branches = branches;
    }

    public void addBranch(Branch branch) {
        if (this.branches.contains(branch)) {
            System.out.println("Warn: branch " + branch.getName() + " already exists");
            return;
        }
        this.branches.add(branch);
    }

    public void removeBranch(Branch branch) {
        if (!this.branches.contains(branch)) {
            System.out.println("Warn: branch " + branch.getName() + " do not exists!");
            return;

        }
        this.branches.remove(branch);
        System.out.println("Branch " + branch.getName() + " has been successfully deleted");
    }

    public void printBranchDetails() {
        for(Branch branch:this.branches) {
            System.out.println("Branch name: " + branch.getName() + "; Branch ID: " + branch.getID());
        }
    }

    public void printBankDetails() {
        System.out.println("Bank name: " + this.name + "; number of branches: " + this.branches.size());
    }
}
