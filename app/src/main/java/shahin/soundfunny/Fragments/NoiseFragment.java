package shahin.soundfunny.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import shahin.soundfunny.CustomAdapters.SoundAdapter;
import shahin.soundfunny.R;
import shahin.soundfunny.Sound;

import static shahin.soundfunny.QueryUtils.mediaPlayer;
import static shahin.soundfunny.QueryUtils.releaseMediaPlayer;

//Created by Mohamed Shahin on 05/09/2017.


public class NoiseFragment extends Fragment {

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sound_list, container, false);

        final ArrayList<Sound> arrayListSound = new ArrayList<>();

        arrayListSound.add(new Sound(R.raw.laugh_annoying_laugh, "Annoying Laugh", R.mipmap.ic_play));
        arrayListSound.add(new Sound(R.raw.human_crowd_noise, "Crowd Noise", R.mipmap.ic_play));
        arrayListSound.add(new Sound(R.raw.human_female_scream, "Female Scream", R.mipmap.ic_play));


        SoundAdapter adapter = new SoundAdapter(getActivity(), arrayListSound);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Sound sound = arrayListSound.get(position);
                mediaPlayer = MediaPlayer.create(getActivity(), sound.getSoundFile());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });

        return rootView;


    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                releaseMediaPlayer();
            }
        }
    }
}
