package com.example.a198_try;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/**
 * This class manages the contents of the Instructions slideshow.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.gangsa3notmoving,
            R.drawable.gangsa3singletap,
            R.drawable.gangsa3slide,
            R.drawable.gangsa3hold
    };

    public String[] slide_headings = {
            "GENERAL INSTRUCTIONS",
            "RINGING",
            "SLIDING",
            "DAMPING"
    };

    public String[] slide_descs = {
            "Slide through this frame to see the gestures you can\nuse in this app. Press 'GO' to play. Once in the playing\npage, you can choose a setting you want to try by\ntouching the dropdown menu at the top.",
            "The RINGING playing style can be done by using either\nthe palm of the HAND or a wooden STICK. To perform this style, do a single tap gesture as shown above.",
            "The SLIDING playing style can be done by using\nthe palm of the HAND. To perform this style, do a fling gesture as shown above.",
            "The DAMPING playing style can be done by using either\nthe palm of the HAND or a wooden STICK. To perform this style,\ndo a long press gesture as shown above."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
