package com.ariltw.composer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView name = findViewById(R.id.name);
        TextView id = findViewById(R.id.id);
        ImageView photo = findViewById(R.id.photo);

        name.setText(R.string.data_acc_name);
        id.setText(R.string.data_acc_id);
        photo.setImageResource(R.drawable.c);
    }
}
