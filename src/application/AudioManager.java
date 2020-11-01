package application;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

	public static void playMusic(String file) {
		
		AudioFormat format;
		DataLine.Info info;
		String uriString = new File(file).toURI().toString();
		Media pick = new Media(uriString); 
		MediaPlayer player = new MediaPlayer(pick);
		
		format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
		
		try {
	        info = new DataLine.Info(TargetDataLine.class, format);
	        final TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(info);
	        targetLine.open();

	        AudioInputStream audioStream = new AudioInputStream(targetLine);

	        byte[] buf = new byte[256];

	        Thread targetThread = new Thread() {
	            public void run() {
	                targetLine.start();
	                try {
	                    audioStream.read(buf);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        };

	        targetThread.start();
	        
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
	
}



/*
static AudioFormat format;
static DataLine.Info info;

public static void input() {
    format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);

    try {
        info = new DataLine.Info(TargetDataLine.class, format);
        final TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(info);
        targetLine.open();

        AudioInputStream audioStream = new AudioInputStream(targetLine);

        byte[] buf = new byte[256]

        Thread targetThread = new Thread() {
            public void run() {
                targetLine.start();
                try {
                    audioStream.read(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        targetThread.start();
} catch (LineUnavailableException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} */