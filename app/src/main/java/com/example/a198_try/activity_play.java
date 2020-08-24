package com.example.a198_try;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

/**
 * This class manages the Playing page.
 */

public class activity_play extends AppCompatActivity implements View.OnTouchListener {

    private ImageView button;
    private GestureDetectorCompat mGestureDetector;
    Spinner spinner;
    private SoundPool soundPool;
    private int sound_ghd1, sound_ghr1, sound_ghs1;
    private int sound_ghd2, sound_ghr2, sound_ghs2;
    private int sound_ghd3, sound_ghr3, sound_ghs3;
    private int sound_ghd4, sound_ghr4, sound_ghs4;
    private int sound_ghd5, sound_ghr5, sound_ghs5;
    private int sound_ghd6, sound_ghr6, sound_ghs6;
    private int sound_gsd1, sound_gsr1;
    private int sound_gsd2, sound_gsr2;
    private int sound_gsd3, sound_gsr3;
    private int sound_gsd4, sound_gsr4;
    private int sound_gsd5, sound_gsr5;
    private int sound_gsd6, sound_gsr6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SET APP TO FULL SCREEN
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_play);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        } else {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound_ghd1 = soundPool.load(this, R.raw.ghd1_synth, 1);
        sound_ghd2 = soundPool.load(this, R.raw.ghd2_synth, 1);
        sound_ghd3 = soundPool.load(this, R.raw.ghd3_synth, 1);
        sound_ghd4 = soundPool.load(this, R.raw.ghd4_synth, 1);
        sound_ghd5 = soundPool.load(this, R.raw.ghd5_synth, 1);
        sound_ghd6 = soundPool.load(this, R.raw.ghd6_synth, 1);
        sound_ghr1 = soundPool.load(this, R.raw.ghr1_synth, 1);
        sound_ghr2 = soundPool.load(this, R.raw.ghr2_synth, 1);
        sound_ghr3 = soundPool.load(this, R.raw.ghr3_synth, 1);
        sound_ghr4 = soundPool.load(this, R.raw.ghr4_synth, 1);
        sound_ghr5 = soundPool.load(this, R.raw.ghr5_synth, 1);
        sound_ghr6 = soundPool.load(this, R.raw.ghr6_synth, 1);
        sound_ghs1 = soundPool.load(this, R.raw.ghs1_synth, 1);
        sound_ghs2 = soundPool.load(this, R.raw.ghs2_synth, 1);
        sound_ghs3 = soundPool.load(this, R.raw.ghs3_synth, 1);
        sound_ghs4 = soundPool.load(this, R.raw.ghs4_synth, 1);
        sound_ghs5 = soundPool.load(this, R.raw.ghs5_synth, 1);
        sound_ghs6 = soundPool.load(this, R.raw.ghs6_synth, 1);
        sound_gsd1 = soundPool.load(this, R.raw.gsd1_synth, 1);
        sound_gsd2 = soundPool.load(this, R.raw.gsd2_synth, 1);
        sound_gsd3 = soundPool.load(this, R.raw.gsd3_synth, 1);
        sound_gsd4 = soundPool.load(this, R.raw.gsd4_synth, 1);
        sound_gsd5 = soundPool.load(this, R.raw.gsd5_synth, 1);
        sound_gsd6 = soundPool.load(this, R.raw.gsd6_synth, 1);
        sound_gsr1 = soundPool.load(this, R.raw.gsr1_synth, 1);
        sound_gsr2 = soundPool.load(this, R.raw.gsr2_synth, 1);
        sound_gsr3 = soundPool.load(this, R.raw.gsr3_synth, 1);
        sound_gsr4 = soundPool.load(this, R.raw.gsr4_synth, 1);
        sound_gsr5 = soundPool.load(this, R.raw.gsr5_synth, 1);
        sound_gsr6 = soundPool.load(this, R.raw.gsr6_synth, 1);


        /*------------------------SPINNER / DROPDOWN MENU ---------------------------------------*/

        // The following section of code manages the spinner (aka dropdown menu) contents.

        // DROPDOWN ITEM LABEL
        final String str[] = {
                "Gangsa 1 using Hand", "Gangsa 1 using Stick",
                "Gangsa 2 using Hand", "Gangsa 2 using Stick",
                "Gangsa 3 using Hand", "Gangsa 3 using Stick",
                "Gangsa 4 using Hand", "Gangsa 4 using Stick",
                "Gangsa 5 using Hand", "Gangsa 5 using Stick",
                "Gangsa 6 using Hand", "Gangsa 6 using Stick"};

        spinner = findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.options)
        );
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(adapter);

        // SET GANGSA IMAGE CORRESPONDING TO THE SELECTED SPINNER ITEM
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(str[0].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa1);
                } else if(str[1].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa1);
                } else if(str[2].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa2);
                } else if(str[3].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa2);
                } else if(str[4].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa3);
                } else if(str[5].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa3);
                } else if(str[6].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa4);
                } else if(str[7].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa4);
                } else if(str[8].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa5);
                } else if(str[9].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa5);
                } else if(str[10].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa6);
                } else if(str[11].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa6);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*---------------------------------------------------------------------------------------*/

        // DECLARATIONS FOR THE NEXT SECTION OF CODE (ON GESTURES DETECTION)
        button = findViewById(R.id.button_gangsa);
        button.setOnTouchListener((View.OnTouchListener) this);
        mGestureDetector = new GestureDetectorCompat(this, new GestureListener());
    }

    /*-------------------- ON TOUCH LISTENER & GESTURE DETECTOR ---------------------------------*/

    // The following section of code manages gesture detection (touch listener and gesture detector).

    // LISTEN FOR TOUCH EVENTS (FOR WHEN THE USER TOUCHES THE SCREEN)
    @Override
    public boolean onTouch (View v, MotionEvent event){
        long t = System.currentTimeMillis();
        android.util.Log.i("Time Class ", " Touch time value in milliseconds " + t);
        mGestureDetector.onTouchEvent(event);

        return false;
    }

    // LISTEN FOR GESTURES (FOR WHEN THE USER PERFORMS ANY OF THE THREE(3) GESTURES:
    // SINGLE TAP, LONG PRESS, OR FLING
    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A LONG PRESS ON THE SCREEN
        @Override
        public void onLongPress(MotionEvent e) {
            long tlong = System.currentTimeMillis();
            android.util.Log.i("Time Class ", "Long press touch time value in milliseconds " + tlong);
            //Toast.makeText(activity_play.this,
            //        "long press", Toast.LENGTH_SHORT).show();    // GESTURE CONFIRMATORY TEXT
            if(("Gangsa 1 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd1, 1,1,0,0,1);
                long tgsd1 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tgsd1);
            } else if(("Gangsa 2 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd2, 1,1,0,0,1);
                long tgsd2 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tgsd2);
            } else if(("Gangsa 3 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd3, 1,1,0,0,1);
                long tgsd3 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tgsd3);
            } else if(("Gangsa 4 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd4, 1,1,0,0,1);
                long tgsd4 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tgsd4);
            } else if(("Gangsa 5 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd5, 1,1,0,0,1);
                long tgsd5 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tgsd5);
            } else if(("Gangsa 6 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd6, 1,1,0,0,1);
                long tgsd6 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tgsd6);
            } else if(("Gangsa 1 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd1, 1,1,0,0,1);
                long tghd1 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tghd1);
            } else if(("Gangsa 2 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd2, 1,1,0,0,1);
                long tghd2 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tghd2);
            } else if(("Gangsa 3 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd3, 1,1,0,0,1);
                long tghd3 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tghd3);
            } else if(("Gangsa 4 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd4, 1,1,0,0,1);
                long tghd4 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tghd4);
            } else if(("Gangsa 5 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd5, 1,1,0,0,1);
                long tghd5 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tghd5);
            } else if(("Gangsa 6 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd6, 1,1,0,0,1);
                long tghd6 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Damping audio time value in milliseconds " + tghd6);
            }

            super.onLongPress(e);
        }

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A FLING ON THE SCREEN
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            long tfling = System.currentTimeMillis();
            android.util.Log.i("Time Class ", "Fling touch time value in milliseconds " + tfling);
            //Toast.makeText(activity_play.this,
            //        "fling", Toast.LENGTH_SHORT).show();    // GESTURE CONFIRMATORY TEXT
        if(("Gangsa 1 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs1, 1,1,0,0,1);
            long tghs1 = System.currentTimeMillis();
            android.util.Log.i("Time Class ", "Sliding audio time value in milliseconds " + tghs1);
        } else if(("Gangsa 2 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs2, 1,1,0,0,1);
            long tghs2 = System.currentTimeMillis();
            android.util.Log.i("Time Class ", "Sliding audio time value in milliseconds " + tghs2);
        } else if(("Gangsa 3 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs3, 1,1,0,0,1);
            long tghs3 = System.currentTimeMillis();
            android.util.Log.i("Time Class ", "Sliding audio time value in milliseconds " + tghs3);
        } else if(("Gangsa 4 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs4, 1,1,0,0,1);
            long tghs4 = System.currentTimeMillis();
            android.util.Log.i("Time Class ", "Sliding audio time value in milliseconds " + tghs4);
        } else if(("Gangsa 5 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs5, 1,1,0,0,1);
            long tghs5 = System.currentTimeMillis();
            android.util.Log.i("Time Class ", "Sliding audio time value in milliseconds " + tghs5);
        } else if(("Gangsa 6 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs6, 1,1,0,0,1);
            long tghs6 = System.currentTimeMillis();
            android.util.Log.i("Time Class ", "Sliding audio time value in milliseconds " + tghs6);
        }

            //playHandSliding(v);    // AUDIO PLAYBACK

            return super.onFling(e1, e2, velocityX, velocityY);
        }

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A SINGLE TAP ON THE SCREEN
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            long ttap = System.currentTimeMillis();
            android.util.Log.i("Time Class ", "Tap touch time value in milliseconds " + ttap);
            //Toast.makeText(activity_play.this,
            //        "single tap", Toast.LENGTH_SHORT).show();   // GESTURE CONFIRMATORY TEXT
            if(("Gangsa 1 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr1, 1,1,0,0,1);
                long tgsr1 = System.currentTimeMillis();

                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tgsr1);
            } else if(("Gangsa 2 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr2, 1,1,0,0,1);
                long tgsr2 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tgsr2);
            } else if(("Gangsa 3 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr3, 1,1,0,0,1);
                long tgsr3 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tgsr3);
            } else if(("Gangsa 4 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr4, 1,1,0,0,1);
                long tgsr4 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tgsr4);
            } else if(("Gangsa 5 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr5, 1,1,0,0,1);
                long tgsr5 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tgsr5);
            } else if(("Gangsa 6 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr6, 1,1,0,0,1);
                long tgsr6 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tgsr6);
            } else if(("Gangsa 1 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr1, 1,1,0,0,1);
                long tghr1 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tghr1);
            } else if(("Gangsa 2 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr2, 1,1,0,0,1);
                long tghr2 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tghr2);
            } else if(("Gangsa 3 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr3, 1,1,0,0,1);
                long tghr3 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tghr3);
            } else if(("Gangsa 4 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr4, 1,1,0,0,1);
                long tghr4 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tghr4);
            } else if(("Gangsa 5 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr5, 1,1,0,0,1);
                long tghr5 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tghr5);
            } else if(("Gangsa 6 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr6, 1,1,0,0,1);
                long tghr6 = System.currentTimeMillis();
                android.util.Log.i("Time Class ", "Ringing audio time value in milliseconds " + tghr6);
            }

            return super.onSingleTapConfirmed(e);
        }
    }
}
