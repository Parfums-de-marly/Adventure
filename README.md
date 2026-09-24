YOLO no merge conflict


YOLO no merge conflict


mp3 afspiller for later use:

import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;

public class mp3_sound {
public static void main(String[] args) {
try {
// skal være wav fil
File lydFil = new File("C:\\Users\\lucas\\OneDrive\\Skrivebord\\scott-lloyd-shelly-overworld-day.wav");


            AudioInputStream audioStream = AudioSystem.getAudioInputStream(lydFil);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);


            clip.start();


            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            clip.close();
        } catch (Exception e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }
}

