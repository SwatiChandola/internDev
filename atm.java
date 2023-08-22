import java.util.Scanner;
class atm {
    private double bal;
    public atm(double initBal) {
        bal = initBal;
    }
    public double getBal() {
        return bal;
    }
    public void deposit(double amt) {
        bal += amt;
    }
    public boolean withdraw(double amt) {
        if (bal >= amt) {
            bal -= amt;
            return true;
        }
        return false;
    }
}
class bank {
    private atm bankacc;
    private Scanner s;
    public bank(atm account) {
        bankacc = account;
        s = new Scanner(System.in);
    }
    public void Menu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw Ammount");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
    public void run() {
        while (true) {
            Menu();
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawamt = s.nextDouble();
                    if (bankacc.withdraw(withdrawamt)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositamt = s.nextDouble();
                    bankacc.deposit(depositamt);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.println("Your balance: " + bankacc.getBal());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
class Main {
    public static void main(String[] args) {
        atm userAccount = new atm(1000.0); 
        bank atm = new bank(userAccount);
        atm.run();
    }
}