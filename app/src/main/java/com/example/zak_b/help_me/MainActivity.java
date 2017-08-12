package com.example.zak_b.help_me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Link to Button UI and
         */
        final Button button = (Button)findViewById(R.id.gotoBanksId);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startViewBank();
            }
        });
    }

    /**
     * Starts the all buttons activity
     */
    protected void startAllButtons() {
        Intent intent = new Intent(this, AllTheButtonsActivity.class); //
        startActivity(intent);
    }

    protected void startViewBank() {
        Intent intent = new Intent(this, ViewBankActivity.class);
        startActivity(intent);
    }
}
