package challenges;

public class BankAcClassExample {
    private int acNo;
    private double balance;
    private String name;
    private String email;
    private String phoneNo;
    
    public void setAcNo(int acNo) { this.acNo = acNo; }
    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Insufficient balance");
            return;
        }
        this.balance = balance;

    }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public double getBalance() { return balance; }

    public void deposit(double amt) {
        this.setBalance(this.balance + amt);
        System.out.println(this.getBalance());
    }

    public void withdraw(double amt) {
        this.setBalance(this.balance - amt);
        System.out.println(this.getBalance());

    }


    public static void main(String[] args) {
        BankAcClassExample abhiAc = new BankAcClassExample();
        abhiAc.setAcNo(1234);
        abhiAc.setName("Abhishek");
        abhiAc.setEmail("i.abhishek.dass@gmai.com");
        abhiAc.setPhoneNo("+44 7384120201");

        abhiAc.deposit(5.24);
        abhiAc.withdraw(4.75);
        abhiAc.withdraw(1.2);
    }
}
