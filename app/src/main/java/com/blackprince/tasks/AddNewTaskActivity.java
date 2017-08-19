package com.blackprince.tasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zak_b.help_me.ListTasksActivity;
import com.example.zak_b.help_me.R;

public class AddNewTaskActivity extends AppCompatActivity {
    private Button saveTaskButton;
    private EditText userNameText;
    private TaskHerder taskHerder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

         getSaveTaskButton();
         getUserNameText();

         taskHerder = TaskHerder.getSingleton();

         saveTaskButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 addNewUser();
             }
        });

        final Button goToLists = (Button)findViewById(R.id.goToTasksBtn);
        goToLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToListTasks();
            }
        });
    }

    private void addNewUser() {
        String name = userNameText.getText().toString();
        taskHerder.addUser(name);
    }

    private void getSaveTaskButton() {
        saveTaskButton = (Button)findViewById(R.id.saveTaskButton);
    }

    private void getUserNameText() {
        userNameText = (EditText)findViewById(R.id.newUserText);
    }

    private void goToListTasks() {
        Intent intent = new Intent(this, ListTasksActivity.class);
        startActivity(intent);
    }
}
