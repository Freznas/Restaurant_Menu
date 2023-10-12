package com.example.restaurangmeny;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    Button avslut;
    Button förätter;
    ImageView förrätt1;
    ImageView förrätt2;
    ImageView förrätt3;

    TextView starter1;
    TextView starter2;
    TextView starter3;
    Button huvudrätter;
    ImageView huvudrätt1;
    ImageView huvudrätt2;
    ImageView huvudrätt3;
    Button efterrätter;
    ImageView efterrätt1;
    ImageView efterrätt2;
    ImageView efterrätt3;

    boolean isFörrätter = false;
    boolean isHuvudrätter = false;
    boolean isEfterrätter = false;


MediaPlayer mediaPlayer;

    @SuppressLint({"CutPasteId", "MissingInflatedId", "ResourceType"})
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        avslut = findViewById(R.id.btn_avslut);

        mediaPlayer = MediaPlayer.create(this, R.raw.italian_music);
        mediaPlayer.start();
        förrätt1 = findViewById(R.id.iv_förrätt1);
        förrätt2 = findViewById(R.id.iv_förrätt2);
        förrätt3 = findViewById(R.id.iv_förrätt3);

        starter1 = findViewById(R.id.tv_starter1);
        starter2 = findViewById(R.id.tv_starter2);
        starter3 = findViewById(R.id.tv_starter3);

        förrätt1.setImageResource(R.drawable.bruschetta);
        förrätt2.setImageResource(R.drawable.mini_pizza);
        förrätt3.setImageResource(R.drawable.anti_pasti);

        huvudrätt1 = findViewById(R.drawable.pizza_margherita);
        huvudrätt2 = findViewById(R.drawable.pasta_la_genovese);
        huvudrätt3 = findViewById(R.drawable.italiensk_sallad);

        efterrätt1 = findViewById(R.drawable.pistache_gelato);
        efterrätt2 = findViewById(R.drawable.tiramisu);
        efterrätt3 = findViewById(R.drawable.cannoli);

        förätter = findViewById(R.id.btn_förrätter);
        huvudrätter = findViewById(R.id.btn_huvudrätter);
        efterrätter = findViewById(R.id.btn_efterrätter);

        // I våra onclick metoder för förätter, huvudrätter och efterrätter så sätter vi in metoder
        // för att ändra värdet på de variabler som står för förrätter/starters till relevant information baserat på menyval.


        förätter.setOnClickListener(new View.OnClickListener()
                /**
                 * här sätter vi in metod för att ändra tillbaka värdet på variablerna till förrätterna om användaren vill återvända till förrätter.
                 */
        {
            public void onClick(View view)
            {
                förrätt1.setImageResource(R.drawable.bruschetta);
                förrätt2.setImageResource(R.drawable.mini_pizza);
                förrätt3.setImageResource(R.drawable.anti_pasti);
                starter1.setText(R.string.starter1);
                starter2.setText(R.string.starter2);
                starter3.setText(R.string.starter3);
                isFörrätter = true;
                isHuvudrätter = false;
                isEfterrätter = false;
            }
        });
        huvudrätter.setOnClickListener(new View.OnClickListener()
                /**
                 * här sätter vi in en metod för att ändra värdet till huvudrätternas information som hämtas från resursfilerna.
                 */
        {
            @Override
            public void onClick(View a)
            {
                förrätt1.setImageResource(R.drawable.pizza_margherita);
                förrätt2.setImageResource(R.drawable.pasta_la_genovese);
                förrätt3.setImageResource(R.drawable.italiensk_sallad);
                starter1.setText(R.string.main1);
                starter2.setText(R.string.main2);
                starter3.setText(R.string.main3);
                isFörrätter = false;
                isHuvudrätter = true;
                isEfterrätter = false;
                           }
        });

        efterrätter.setOnClickListener(new View.OnClickListener()
                /**
                 * här sätter vi in en metod för att ändra värdet till efterrätternas information som hämtas från resursfilerna.
                 */
        {
            @Override
            public void onClick(View b)
            {
                förrätt1.setImageResource(R.drawable.pistache_gelato);
                förrätt2.setImageResource(R.drawable.tiramisu);
                förrätt3.setImageResource(R.drawable.cannoli);
                starter1.setText(R.string.dessert1);
                starter2.setText(R.string.dessert2);
                starter3.setText(R.string.dessert3);
                isFörrätter = false;
                isHuvudrätter = false;
                isEfterrätter = true;
            }
        });

        //slutligen så skapar vi en onclick för att avsluta appen och stänga menyn.
        avslut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View d)
            {
                finish();
            }
        });

    }
    @Override
    protected void onStop(){
        super.onStop();
        mediaPlayer.release();
    }
}
