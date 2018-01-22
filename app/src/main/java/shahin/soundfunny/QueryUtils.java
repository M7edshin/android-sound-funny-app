package shahin.soundfunny;

import android.media.MediaPlayer;

//Created by Mohamed Shahin on 05/09/2017.

public class QueryUtils {

    private QueryUtils() {
    }

    public static MediaPlayer mediaPlayer;

    public static void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
