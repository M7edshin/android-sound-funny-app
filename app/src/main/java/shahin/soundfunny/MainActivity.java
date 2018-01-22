package shahin.soundfunny;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import shahin.soundfunny.CustomAdapters.SoundFragmentPagerAdapter;

import static shahin.soundfunny.QueryUtils.releaseMediaPlayer;

import com.google.android.gms.ads.MobileAds;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

//Created by Mohamed Shahin on 05/09/2017.


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-1885749404874590~5843093822");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        ViewPager viewPager = findViewById(R.id.viewpager);
        SoundFragmentPagerAdapter adapter = new SoundFragmentPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_music);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_phrases);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_noise);
        tabLayout.getTabAt(3).setIcon(R.mipmap.ic_disgusting);

    }

    public void stopSound(View view) {
        releaseMediaPlayer();
    }
}
