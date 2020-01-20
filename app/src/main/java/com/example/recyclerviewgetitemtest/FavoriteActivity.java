package com.example.recyclerviewgetitemtest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView favorite_list;
    private ArrayList<FavoriteModel> favorite_data = new ArrayList<>();
    private FavoriteListAdapter adapter;
    private Button btn_edit;
    private boolean isEdit; // 是否為編輯的狀態

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化元件
        initView();

        // 載入資料
        favorite_data.add(new FavoriteModel(R.drawable.bee,"蟻人與黃蜂女"));
        favorite_data.add(new FavoriteModel(R.drawable.bookshop,"街角的書店"));
        favorite_data.add(new FavoriteModel(R.drawable.champion,"冠軍大叔"));
        favorite_data.add(new FavoriteModel(R.drawable.summer,"夏日1993"));
        favorite_data.add(new FavoriteModel(R.drawable.hades,"鋼鐵墳墓2"));

        // 配對 Adatpter
        adapter = new FavoriteListAdapter(FavoriteActivity.this,favorite_data,false);//補上新建構子
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        favorite_list.setLayoutManager(layoutManager);
        favorite_list.setAdapter(adapter);

        // 編輯的點擊事件
        btn_edit.setOnClickListener(this);
    }

    //========= setOnClickListener 的監聽事件 START =========//
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // 點了編輯的 button 要改變刪除按鈕（在 RecyclerView 裡）的可視狀態
            case R.id.favoritepageEdit:
                isEdit = ! isEdit; // 點下去後 isEdit 的狀態改變（!：NOT運算，真變假，假變真）
                Log.d("D200=",""+isEdit);

                adapter.setVisible(isEdit);//用Setter取值
                adapter.notifyDataSetChanged();
                break;
        }

    }
    //========= setOnClickListener 的監聽事件 END =========//

    //========= 初始化元件 START =========//
    private void initView() {
        // 編輯
        btn_edit = findViewById(R.id.favoritepageEdit);
        // RecyclerView
        favorite_list = findViewById(R.id.favoriteList);
    }
    //========= 初始化元件 END =========//
}
