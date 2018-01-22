package shahin.soundfunny;

/**
 * Created by M7edS on 05/09/2017.
 */

public class Sound {

    private int soundFile;
    private String soundTitle;
    private int playImageResourceId;


    public Sound(int soundFile, String soundTitle, int playImageResourceId) {

        this.soundFile = soundFile;
        this.soundTitle = soundTitle;
        this.playImageResourceId = playImageResourceId;

    }

    public int getSoundFile() {
        return soundFile;
    }

    public int getPlayImageResourceId() {
        return playImageResourceId;
    }

    public String getSoundTitle() {
        return soundTitle;
    }
}
