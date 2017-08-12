package com.example.zak_b.help_me;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import tasks.Task;
import tasks.TaskHerder;

public class ViewBankActivity extends AppCompatActivity {
    private TaskHerder taskHerder;
    private int nextX;
    private int nextY;

    private ConstraintLayout centerCanvas;
    private int centerHeight;
    private int centerWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bank);

        // Assign the toolbar so we can populate it
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        setupAbortListener();
        findCenterCanvas();

        // Create a task herder.
        String[] names = {"Emilio", "Katya", "Ivanka"};
        String[] descs = {"Fuck", "this", "shit"};
        taskHerder = new TaskHerder();
        taskHerder.easyBuildOwnersTasks(names, descs);
    }

    private void findCenterCanvas() {
        this.centerCanvas = (ConstraintLayout) findViewById(R.id.centerCanvas);
        this.centerHeight = centerCanvas.getHeight();
        this.centerWidth = centerCanvas.getWidth();
    }

    private void setupAbortListener(){
        Button abortButton = (Button) findViewById(R.id.abortButton);

        abortButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoMainActivity();
            }
        });
    }

    private void gotoMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void createFavView() {

        Random rand = new Random();
        int x = rand.nextInt(1000);
        int y = rand.nextInt(1000);

        ImageView heartView = new ImageView(this);

        heartView.setX(x);
        heartView.setY(y);
        heartView.setImageResource(R.drawable.ic_favorite_black_48dp);
        centerCanvas.addView(heartView);
    }

    // Create menu item
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        // Favorite has been defined in favorite.xml
        inflater.inflate(R.menu.favorite, menu);
        inflater.inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView bankName = (TextView) findViewById(R.id.bankName);

        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...

                createFavView();

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
