import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double amount=100,bet,payout;
        String option = "";
        boolean isrun;


        System.out.println("***** SLOT MACHINO LA VEGAS *****");

        while(amount>0 && !option.equals("X")){

            System.out.println("1. Place your Bet : ");
            bet = Bet(amount);
            amount -=bet;

            System.out.println("2.Spininn");
            payout = Spin(bet,amount);

            if(payout>0) {
                amount+=payout;
                System.out.printf("Congrats lowlife...you actually won $%f \n", payout);
                System.out.printf("Here's your balance skunk $%f \n", amount);

            }else{
                System.out.println("Better luck next time loser");
                System.out.printf("Here's your leftover  $%f \n", amount);
            }
            System.out.println("[Enter] to play again [X] to Exit");
            option = scanner.next().toUpperCase();

        }
    }

    static double Bet(double amount){

        double bet;
        System.out.print("Enter your bet :");
        bet = scanner.nextDouble();

        if( amount> bet){
            amount -=bet;
        }else {
            System.out.println("GET MOVING YOU BROKE ASS JUNKIEE!!");
        }

        return bet;
    }

    static double Spin(double bet,double amount){

        double payout = 0;
        String[] emos = {"😊","😉","😒","😘","🤣","😜"};
        String[] slots = new String[3];
        Random random = new Random();
        if( bet>0) {
            for (int i = 0; i < 3; i++) {
                slots[i] = emos[random.nextInt(emos.length)];
            }
            System.out.print(slots[0] + slots[1] + slots[2]);

            if (slots[0].equals(slots[1]) && slots[1].equals(slots[2])) {

                payout = bet * 5;
            }

            if (slots[0].equals(slots[1])) {

                payout = bet * 2;
            }

            if (slots[0].equals(slots[2])) {

                payout = bet * 2;
            }

            if (slots[1].equals(slots[2])) {

                payout = bet * 2;
            }
        }

    return payout;
    }
}
