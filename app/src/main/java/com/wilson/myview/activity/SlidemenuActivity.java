package com.wilson.myview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wilson.myview.R;
import com.wilson.myview.view.slidemenu.SlideMenu;

public class SlidemenuActivity extends Activity {
    private ImageView btn_back;
    private SlideMenu slideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidemenu);

        btn_back = (ImageView) findViewById(R.id.btn_back);
        slideMenu = (SlideMenu) findViewById(R.id.slideMenu);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideMenu.switchMenu();
            }
        });
    }
}
