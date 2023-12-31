package dao_impl;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayAudio {
    static int count1 = 0;
    Clip clip;
    AudioInputStream audioInputStream;
    String filePath;
    Long currentFrame;
    String status;

    public PlayAudio() {

    }

    public void playAudio1(String filePath, int count) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        count1 = count;
        this.filePath = filePath;
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        clip = AudioSystem.getClip();

        clip.open(audioInputStream);
        clip.loop(count1);

    }

    public void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        clip.start();

        status = "play";
    }

    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (status.equals("play")) {
            System.out.println("Audio is already being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        play();
    }

    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        play();
    }

    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
        System.exit(0);
    }

    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
    }
}
