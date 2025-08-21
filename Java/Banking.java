import java.util.Scanner;

public class Banking {

    public static void main(String[] args) {

        System.out.println("BANKING PORTAL");
        Scanner scanner = new Scanner(System.in);

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
//                case 2 -> Withdraw();
//                case 3 -> Deposit();
                case 4 -> isrun = false;
                default -> System.out.println("50% charges for invalid option _|_");
            }

            scanner.close();
        }


    }

    static void Balance(double amount){

        System.out.println("Balance");
    }

    //desposit

    //wothrae


}

