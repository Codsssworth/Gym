import java.util.Scanner;

public class tempreture {

    public static void main(String[] args) {

       double temp,result;
       String type ;
       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter Tempreture :");
       temp = scanner.nextDouble();

       while(temp!=-1){

       System.out.print("convert to Celsius or Farenhiet :");
       type = scanner.next().toUpperCase();

       result = (type.equals("C"))? (temp - 32)*5/9 : (temp * 1.8)+32;

       System.out.printf("Converted temp = %f %s \n",result,type);

       System.out.print("Enter Tempreture (-1 to quit):");
       temp = scanner.nextDouble();
       }

       scanner.close();
    }
}
