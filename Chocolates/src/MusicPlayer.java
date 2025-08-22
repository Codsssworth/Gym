import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MusicPlayer {

    public static void main(String[] args) throws UnsupportedAudioFileException, FileNotFoundException, MalformedURLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        String url= "Chocolates\\src\\file_example_WAV_1MG.wav";
        File file = new File(url);

     try(Scanner scanner = new Scanner(System.in);
         AudioInputStream audio = AudioSystem.getAudioInputStream(file)){

         Clip clip = AudioSystem.getClip();
         clip.open(audio);

         String choice="";

         while(!choice.equals("X")){

             System.out.println("Enter P to play");
             System.out.println("Enter S to Stop");
             System.out.println("Enter R to Reset");
             System.out.println("Enter X to quit");
             choice = scanner.next().toUpperCase();

             switch (choice){
                 case "P" -> {
                     clip.start();
                  System.out.println("Playin...");
                 }
                 case "S" -> clip.stop();
                 case "R" -> clip.setFramePosition(0);
                 case "X" -> clip.close();
                 default -> System.out.println("make sense");
             }

         }

     } catch (LineUnavailableException e) {
         throw new RuntimeException(e);
     } catch (UnsupportedAudioFileException e){
       throw new UnsupportedAudioFileException() ;
     } catch (FileNotFoundException e){
         throw new FileNotFoundException();
     } catch (IOException e) {
         throw new RuntimeException(e);
     }finally {
         System.out.println("over");
     }


    }
}
