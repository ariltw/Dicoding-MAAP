package com.ariltw.composer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ariltw.composer.adapter.ComposerListAdapter;
import com.ariltw.composer.adapter.DeviderItemDecoration;
import com.ariltw.composer.model.Composer;

import java.util.ArrayList;
import java.util.List;

// TODO : [DONE] move to account detail
// TODO : crate best practice for recyclerview

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.menu_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        recyclerView.addItemDecoration(new DeviderItemDecoration(16));

        ArrayList<Composer> data = composerList();
        loadData(data);
    }

    private ArrayList<Composer> composerList() {
        String[] data_name = getResources().getStringArray(R.array.data_list_name);
        String[] data_year = getResources().getStringArray(R.array.data_list_year);
        String[] data_desc = getResources().getStringArray(R.array.data_list_desc);
        @SuppressLint("Recycle") TypedArray data_image = getResources().obtainTypedArray(R.array.data_list_img);

        ArrayList<Composer> list = new ArrayList<>();
        for (int i = 0; i < data_name.length; i++) {
            Composer composer = new Composer(
                    data_name[i],
                    data_year[i],
                    data_desc[i],
                    data_image.getResourceId(i, -1)
            );

            list.add(composer);
        }

        return list;
    }

    private void loadData(List<Composer> list) {
        ComposerListAdapter adapter = new ComposerListAdapter(list, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}