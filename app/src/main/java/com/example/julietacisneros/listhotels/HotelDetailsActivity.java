package com.example.julietacisneros.listhotels;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by julietacisneros on 06/11/15.
 */
public class HotelDetailsActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_details);
        ImageView imageView = (ImageView)findViewById(R.id.imageDetails);
        imageView.setImageResource(getIntent().getIntExtra("image", 0));

        TextView textDetails = (TextView)findViewById(R.id.textDescription);
        textDetails.setText(getIntent().getStringExtra("description"));
        textDetails.setMovementMethod(new ScrollingMovementMethod());

        TextView textPunctuation = (TextView)findViewById(R.id.punctuation);
        textPunctuation.setText(getIntent().getStringExtra("punctuation"));

        TextView hotelName = (TextView)findViewById(R.id.hotelName);
        hotelName.setText(getIntent().getStringExtra("name"));
    }

}
