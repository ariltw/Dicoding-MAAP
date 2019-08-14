package com.ariltw.composer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ariltw.composer.model.Composer;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public final static String EXTRA_DATA = "EXTRA_COMPOSER";

    private TextView name;
    private TextView year;
    private TextView desc;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bindView();
        setContent();
    }

    private void bindView() {
        name = findViewById(R.id.name);
        year = findViewById(R.id.year);
        desc = findViewById(R.id.detail);
        image = findViewById(R.id.photo);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setContent() {
        Composer composer = getIntent().getParcelableExtra(EXTRA_DATA);

        assert composer != null;
        name.setText(composer.getName());
        year.setText(composer.getYear());
        desc.setText(composer.getDescription());
        image.setImageResource(composer.getImage());
    }

}
