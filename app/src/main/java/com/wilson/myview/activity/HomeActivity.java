package com.wilson.myview.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wilson.myview.R;

public class HomeActivity extends Activity implements View.OnClickListener {

    private TextView tv_toggle;
    private TextView tv_refresh;
    private TextView tv_slidemenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_toggle:
                startActivity(new Intent(HomeActivity.this, ToggleActivity.class));
                break;
            case R.id.tv_refresh:
                startActivity(new Intent(HomeActivity.this, RefreshActivity.class));
                break;
            case R.id.tv_slidemenu:
                startActivity(new Intent(HomeActivity.this, SlidemenuActivity.class));
                break;
        }

    }

    private void initView() {
        tv_toggle = (TextView) findViewById(R.id.tv_toggle);
        tv_toggle.setOnClickListener(this);
        tv_refresh = (TextView) findViewById(R.id.tv_refresh);
        tv_refresh.setOnClickListener(this);
        tv_slidemenu = (TextView) findViewById(R.id.tv_slidemenu);
        tv_slidemenu.setOnClickListener(this);
    }
}
