package br.com.edabes.utils;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoopSound {

    public static void main(String[] args) throws Exception {
        File audio = new File(
            "C:\\dev\\tcc\\ed_abes\\audio_files\\grass1.wav");
        Clip clip = AudioSystem.getClip();
        // getAudioInputStream() also accepts a File or InputStream
        AudioInputStream ais = AudioSystem.
            getAudioInputStream( audio );
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // A GUI element to prevent the Clip's daemon Thread
                // from terminating at the end of the main()
                //JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
        System.out.println("rodou");
    }
    
    
}