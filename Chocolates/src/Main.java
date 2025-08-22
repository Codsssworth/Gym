import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarm = null;

        String file= "Chocolates\\src\\file_example_WAV_1MG.wav";
//        File file = new File(url);


        while (alarm == null) {

            try {
                System.out.print("Enter alarm time : ");
                String time = scanner.nextLine();
                alarm = LocalTime.parse(time, format);
                System.out.println("Alarm set at : " + alarm);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarm,file,scanner);
        Thread clock = new Thread(alarmClock);
        clock.start();
}
}