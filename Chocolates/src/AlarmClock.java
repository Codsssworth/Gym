import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable {

    private final LocalTime alarm;
    private String file;
    private final Scanner scanner;

    AlarmClock(LocalTime alarm,String file,Scanner scanner){
        this.alarm = alarm;
        this.file = file;
        this.scanner = scanner;
    }

    @Override
    public void run() {

        while(LocalTime.now().isBefore(alarm)){
            try {
                Thread.sleep(1000);
                System.out.printf("\r%02d:%02d:%02d" , LocalTime.now().getHour(),LocalTime.now().getMinute(), LocalTime.now().getSecond());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            RingAlarm(file);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void RingAlarm(String file) throws UnsupportedAudioFileException, FileNotFoundException {
        File f = new File(file);
        String input = "";
        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audio = AudioSystem.getAudioInputStream(f)){

            Clip clip = AudioSystem.getClip();
            clip.open(audio);

            clip.start();
            System.out.println("\n BABE WAKE UPPP..");
            System.out.println("Press enter to exit..");
            scanner.nextLine();

            clip.close();
            scanner.close();

            } catch (LineUnavailableException e) {
               throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("over");
        }
    }


}
