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
        List.add(new Item("",""));
        List.add(new Item("",""));
        List.add(new Item("官方：阿联酋球队沙迦FC从巴萨签下波黑中场皮亚尼奇","https://m.hupu.com/bbs/55460074.html"));
        List.add(new Item("多家媒体：波特下午和切尔西会谈，明天可能就会官宣上任","https://m.hupu.com/bbs/55459519.html"));
        List.add(new Item("继承传统？盘点阿布时代以来，切尔西的那些主帅们","https://m.hupu.com/bbs/55459625.html"));
        List.add(new Item("图赫尔的切尔西20个月回顾：花了4亿欧元，赢下3座冠军","https://m.hupu.com/bbs/55458231.html"));
        List.add(new Item("斯帕莱蒂：我梦想过C罗搭档奥斯梅恩，但我不想失去奥斯梅恩","https://m.hupu.com/bbs/55460251.html"));
        List.add(new Item("电讯报：若确定加盟，波特会带引援分析师+教练组入主切尔西","https://m.hupu.com/bbs/55460214.html"));
        List.add(new Item("欧联客战苏黎世，托马斯、S罗和塞德里克因伤未随枪手出征","https://m.hupu.com/bbs/55459993.html"));
        List.add(new Item("马竞主席：很开心格列兹曼在队里，我没有掺和过排首发的事","https://m.hupu.com/bbs/55459799.html"));
        List.add(new Item("",""));
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