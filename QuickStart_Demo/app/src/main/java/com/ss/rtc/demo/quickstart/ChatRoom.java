package com.ss.rtc.demo.quickstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChatRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_navigation);

        bottomNavigationView.setSelectedItemId(R.id.chatroom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()) {
                    case R.id.chatroom:

                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), viewpagerActivity.class));
                        overridePendingTransition(enterAnim:0,enterAnim:0);
                        return true;
                    case R.id.my:
                        startActivity(new Intent(getApplicationContext(), My.class));
                        overridePendingTransition(enterAnim:0,enterAnim:0);
                        return true;

                }
                return false;
            }
        });
    }
}