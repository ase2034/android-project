package com.ss.rtc.demo.quickstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public void overridePendingTransition (int enterAnim, int exitAnim)
public class viewpagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);


        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()) {
                    case R.id.chatroom:
                        startActivity(new Intent(getApplicationContext(), ChatRoom.class));
                        overridePendingTransition(0,0);

                        overridePendingTransition(0,0)

                        return true;
                    case R.id.home:
                        return true;
                    case R.id.my:
                        startActivity(new Intent(getApplicationContext(), My.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }
}