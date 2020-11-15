package challenges.bankCompany;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Branch> lbgBranches = new ArrayList<>();
        Bank lloyds = new Bank("LBG", lbgBranches);

        System.out.println("----------Bank details--------------");
        lloyds.printBankDetails();

        System.out.println("----------Add branches-------------");
        Branch ilford = new Branch("Ilford", "E01");
        Branch eastHam = new Branch("East Ham", "E02");
        Branch londonCentral = new Branch("London Central", "C01");
        Branch bank = new Branch("Bank", "C02");
        Branch camden = new Branch("Camden", "N01");
        Branch hunslow = new Branch("Hunslow", "W01");
        lloyds.addBranch(ilford);
        lloyds.addBranch(eastHam);
        lloyds.addBranch(londonCentral);
        lloyds.addBranch(bank);
        lloyds.addBranch(camden);
        lloyds.addBranch(hunslow);
        lloyds.printBankDetails();
        lloyds.printBranchDetails();

        System.out.println("----------Remove branches-------------");
        lloyds.removeBranch(eastHam);
        lloyds.printBankDetails();
        lloyds.printBranchDetails();

        System.out.println("----------Exception handling branches-------------");
        lloyds.removeBranch(eastHam);
        lloyds.addBranch(eastHam);
        lloyds.addBranch(eastHam);
        lloyds.printBankDetails();
        lloyds.printBranchDetails();

        System.out.println("----------Add customer to branches-------------");
        Customer abhi = new Customer("Abhishek", "Das");
        Customer sutapa = new Customer("Sutapa", "Chattaraj");
        Customer subho = new Customer("Subhojit", "Mukherjee", 200.25);
        Customer malpa = new Customer("Malpa", "Bajpai", 111.11);
        ilford.addCustomer(abhi);
        ilford.addCustomer(sutapa);
        bank.addCustomer(subho);
        londonCentral.addCustomer(malpa);

        System.out.println("----------Remove customer from branches-------------");
        londonCentral.deleteCustomer(malpa);

        System.out.println("----------Exceptional handling branches-------------");
        londonCentral.deleteCustomer(malpa);
        londonCentral.addCustomer(malpa);
        londonCentral.addCustomer(malpa);

        System.out.println("----------Update branch name-------------");
        ilford.updateBranchName("Ilford");
        ilford.printBranchDetails();

        System.out.println("----------print customers of each branch-------------");
        ilford.viewCustomers();
        londonCentral.viewCustomers();
        bank.viewCustomers();

        System.out.println("----------print customers of each branch-------------");
        sutapa.deposit(500.25, "Savings sept");
        sutapa.deposit(2345.25, "Salary");
        sutapa.withdraw(800, "Rent");
        sutapa.viewProfile();
        sutapa.showTransactions();
    }
}
