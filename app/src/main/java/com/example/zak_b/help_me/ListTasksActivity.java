package com.example.zak_b.help_me;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.blackprince.tasks.TaskHerder;

public class ListTasksActivity extends AppCompatActivity {
    private ConstraintLayout centerCanvas;
    private ListView listView;
    private List<String> List_file;
    private TaskHerder taskHerder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tasks);
        centerCanvas = (ConstraintLayout) findViewById(R.id.centerConstrainer);

        listView = new ListView(this);
        centerCanvas.addView(listView);

        taskHerder = TaskHerder.getSingleton();



        // Set an adapter to populate the list. I'm assuming the simple_list_item is the design
        // option.
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout
                .simple_list_item_1,taskHerder.getNames()));

        linkButterflyButton();
        linkMainButton();
    }

    private void populateListFile() {
        List_file = new ArrayList<String>();
        List_file.add("Coderzheaven");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Google");
        List_file.add("Android");
        List_file.add("iPhone");
        List_file.add("Apple");

    }

    private void linkButterflyButton() {
        Button butterfly = (Button)findViewById(R.id.toButterflyBtn);
        butterfly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToButterfly();
            }
        });
    }

    private void linkMainButton() {
        Button butterfly = (Button)findViewById(R.id.toMainBtn);
        butterfly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });
    }

    private void goToButterfly() {
        Intent intent = new Intent(this, ButterflyActivity.class);
        startActivity(intent);
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
