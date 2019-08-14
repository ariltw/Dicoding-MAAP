package com.ariltw.composer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;

import com.ariltw.composer.adapter.ComposerListAdapter;
import com.ariltw.composer.model.Composer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setMotionEventSplittingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

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