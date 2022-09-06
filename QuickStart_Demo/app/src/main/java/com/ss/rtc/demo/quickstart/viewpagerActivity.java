package com.ss.rtc.demo.quickstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import java.util.ArrayList;

public class viewpagerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyRecyclerAdapter adapter;
    private Context context;
    private List<Item> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        context=this;
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        List =new ArrayList<>();
        List.add(new Item("哔哩哔哩","https://www.bilibili.com/"));
        List.add(new Item("知乎","https://www.zhihu.com/"));
        adapter=new MyRecyclerAdapter(context,List,this);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()) {
                    case R.id.chatroom:
                        startActivity(new Intent(getApplicationContext(), ChatRoom.class));
                        overridePendingTransition(0,0);

                        overridePendingTransition(0,0);

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