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

import com.blackprince.tasks.TaskHerder;


public class ButterflyActivity extends AppCompatActivity {
    private static double MAX_BUTTERFLY = 12* Math.PI;
    private static double MIN_BUTTERFLY = 0;

    private TaskHerder taskHerder;
    private double currentX;
    private double currentY;

    private ConstraintLayout centerCanvas;
    private int centerHeight;
    private int centerWidth;
    private double t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterfly);

        // Assign the toolbar so we can populate it
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        setupAbortListener();
        setupResetListener();
        findCenterCanvas();
        setupDrawing();
    }

    private void findCenterCanvas() {
        this.centerCanvas = (ConstraintLayout) findViewById(R.id.centerCanvas);
        this.centerHeight = centerCanvas.getHeight();
        this.centerWidth = centerCanvas.getWidth();
    }

    private void setupResetListener() {
        Button abortButton = (Button) findViewById(R.id.resetButton);

        abortButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                recreate();
            }
        });
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

    private void setupDrawing()
    {
        this.currentX = 25;
        this.currentY = 150;
        t = 0;
    }

    private void calculateNextButterfly() {
        Double a = Math.exp(Math.cos(t));
        Double b = 2 * Math.cos(4 * t);
        Double c = Math.pow(Math.sin(t/12), 5);

        this.currentX = (0-1)*250*Math.sin(t) * (a - b - c) + 650;
        this.currentY = (0-1)*250*Math.cos(t) * (a - b - c) + 1200;
    }

    private void drawTextView(String str) {
        TextView view = new TextView(this);
        view.setText(str);
        view.setX(100);
        view.setY(200);

        centerCanvas.addView(view);
    }

    private void drawButterflyView(int resId) {
        t = MIN_BUTTERFLY;

        while(t < MAX_BUTTERFLY) {
            calculateNextButterfly();
            createImageView(resId, this.currentX, this.currentY);
            t += 0.01;
        }
    }

    private void drawRandView(int resId) {

        Random rand = new Random();
        int x = rand.nextInt(1000);
        int y = rand.nextInt(1900) + 100;

        createImageView(resId, x, y);
    }


    private void createImageView(int resId, double x, double y) {


        ImageView heartView = new ImageView(this);

        heartView.setX(new Double(x).intValue());
        heartView.setY(new Double(y).intValue());
        heartView.setImageResource(resId);

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

                drawButterflyView(R.drawable.ic_favorite_black_18dp);
                return true;
            case R.id.action_land_plane:
                drawRandView(R.drawable.ic_flight_land_black_18dp);
                return true;

            case R.id.action_half_star:
                drawRandView(R.drawable.ic_star_half_black_18dp);
                return true;

            case R.id.action_cloud_circle_black:
                drawRandView(R.drawable.ic_cloud_circle_black_18dp);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
