<<<<<<< HEAD
package com.example.android.themakers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class OurIntro extends AppIntro2 {



    @Override
    public void init(Bundle savedInstanceState) {

        getSupportActionBar().hide();

        addSlide(AppIntroFragment.newInstance("UTILITEE"
                , "Get location of common places on Campus, View on Map and Share your location with your friends."
                , R.drawable.ic_place_white_48dp
                , Color.parseColor("#2a8a9b")));
        addSlide(AppIntroFragment.newInstance("UTILITEE"
                , "List your items (Services) for sale and get buyers calling you."
                , R.drawable.ic_business_center_white_48dp
                , Color.parseColor("#42ae5d")));
        addSlide(AppIntroFragment.newInstance("UTILITEE"
                , "Emergency? Call the nearest Emergency service station with just a button click. "
                , R.drawable.ic_phone_white_48dp
                , Color.parseColor("#f7963d")));

        setProgressButtonEnabled(true);

        setFadeAnimation();
        setFlowAnimation();

    }


    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.android.themakers", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("hasLaunched","yes").apply();

        Intent intent = new Intent(this, LocationMainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    @Override
    public void onSlideChanged() {

    }

}
=======
package com.example.android.themakers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class OurIntro extends AppIntro2 {



    @Override
    public void init(Bundle savedInstanceState) {

        getSupportActionBar().hide();

        addSlide(AppIntroFragment.newInstance("STUDENTS' COMPANION"
                , "Get location of common places on Campus, View on Map and Share your location with your friends."
                , R.drawable.ic_place_white_48dp
                , Color.parseColor("#2a8a9b")));
        addSlide(AppIntroFragment.newInstance("STUDENTS' COMPANION"
                , "List your items (Services) for sale and get buyers calling you."
                , R.drawable.ic_business_center_white_48dp
                , Color.parseColor("#42ae5d")));
        addSlide(AppIntroFragment.newInstance("STUDENTS' COMPANION"
                , "Emergency? Call the nearest Emergency service station with just a button click. "
                , R.drawable.ic_phone_white_48dp
                , Color.parseColor("#f7963d")));

        setProgressButtonEnabled(true);

        setFadeAnimation();
        setFlowAnimation();

    }


    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.android.themakers", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("hasLaunched","yes").apply();

        Intent intent = new Intent(this, LocationMainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    @Override
    public void onSlideChanged() {

    }

}
>>>>>>> 93558684926287160cc8c7f84ba6444ff5f25e26
