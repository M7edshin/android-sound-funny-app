package shahin.soundfunny.CustomAdapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import shahin.soundfunny.Fragments.DisgustingFragment;
import shahin.soundfunny.Fragments.MusicFragment;
import shahin.soundfunny.Fragments.NoiseFragment;
import shahin.soundfunny.Fragments.PhraseFragment;

//Created by Mohamed Shahin on 05/09/2017.


public class SoundFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public SoundFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MusicFragment();
        } else if (position == 1) {
            return new PhraseFragment();
        } else if (position == 2) {
            return new NoiseFragment();
        } else {
            return new DisgustingFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

}