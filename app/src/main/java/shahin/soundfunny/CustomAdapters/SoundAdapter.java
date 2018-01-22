package shahin.soundfunny.CustomAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import shahin.soundfunny.R;
import shahin.soundfunny.Sound;

//Created by Mohamed Shahin on 05/09/2017.


public class SoundAdapter extends ArrayAdapter<Sound> {

    public SoundAdapter(Context context, ArrayList<Sound> arrayList) {
        super(context, 0, arrayList);
    }

    static class ViewHolder {
        TextView tvTitle;
        ImageView imgPlayImage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Sound currentSound = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sound_item_list, parent, false);
            viewHolder.tvTitle = convertView.findViewById(R.id.tvTitle);
            viewHolder.imgPlayImage = convertView.findViewById(R.id.imgPlayImage);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (currentSound != null) {
            viewHolder.tvTitle.setText(currentSound.getSoundTitle());
        }

        if (currentSound != null) {
            viewHolder.imgPlayImage.setImageResource(currentSound.getPlayImageResourceId());
        }

        return convertView;

    }

}
