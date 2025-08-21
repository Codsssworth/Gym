import java.util.Scanner;

public class Banking {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("BANKING PORTAL");

        int option;
        boolean isrun = true;
        double amount = 0 ;

        while (isrun) {

            System.out.println("1.Check Balance");
            System.out.println("2.Withdraw");
            System.out.println("3.Deposit");
            System.out.println("4.Exit");
            option = scanner.nextInt();

            switch (option) {

                case 1 -> Balance(amount);
                case 2 -> amount=Withdraw(amount);
                case 3 -> amount=Deposit(amount);
                case 4 -> isrun = false;
                default -> System.out.println("50% charges for invalid option _|_");
            }
        }

        scanner.close();
    }

    static void Balance(double amount){

        System.out.printf("Balance : %f \n", amount);
    }

   static double Deposit(double amount){
        double add;
        System.out.println("Enter Amount :");
        add = scanner.nextDouble();

        if(add>0){
        amount+=add;
        }else {
            System.out.print("Get money prick");
        }
        return amount;

   }

  static Double Withdraw(double amount){

      double wid;
      System.out.println("Enter Amount :");
      wid = scanner.nextDouble();
      if(wid<=amount && amount > 0) {
          amount -= wid;
      }
      else {
          System.out.println("BROKE ASS HAHA");
      }
      return amount;
  }




}

