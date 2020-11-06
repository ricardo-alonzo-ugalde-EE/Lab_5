package org.electricuniverse.lab_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button button; // next activity button
    Button button2; // Move and Rotate button
    Button button3; // Move Back button
    Button button4; // Fade Out button
    Button button5; // Fade In button
    Button button6; // XML animator
    ImageView imageView; // Image View


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Step 2: Property Animations**************************************************************
         * */
        /**
         * Next Activity Button
         * */
        button = (Button) findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                NextActivity(imageView);
            }
        });


        /**
         * Move and Rotate Button
         * */
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                imageView.animate().setDuration(1000).x(500).y(800).rotationYBy(720).scaleX(.4F).scaleY(.4F);
            }
        });

        /**
         * Move Back
         * */
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                imageView.animate().setDuration(1000).x(imageView.getLeft()).y(imageView.getTop()).rotationYBy(720).scaleX(1F).scaleY(1F);
            }
        });

        /**
         * Fade Out
         * */
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                imageView.animate().setDuration(1000).alpha(0F);
            }
        });

        /**
         * Fade Out
         * */
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                imageView.animate().setDuration(1000).alpha(0F);
            }
        });

        /**
         * Fade In
         * */
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageView.animate().setDuration(1000).alpha(1F);
            }
        });

        /**
         * XML Animator
         * */
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               AnimatorSet spinSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.custom_animator);
                spinSet.setTarget(imageView);
                spinSet.start();
            }
        });

    }

    private void NextActivity(View view)
    {
        Intent intent = new Intent(this, newActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,view, "newActivity");
        startActivity(intent,optionsCompat.toBundle());
    }


}