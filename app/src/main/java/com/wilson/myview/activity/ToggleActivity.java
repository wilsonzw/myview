package com.wilson.myview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.wilson.myview.R;
import com.wilson.myview.view.toggle.ToggleView;
import com.wilson.myview.view.toggle.interf.OnToggleStateChangeListener;

public class ToggleActivity extends Activity implements OnToggleStateChangeListener {
    private ToggleView toggleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);

        toggleView = (ToggleView)findViewById(R.id.toggleview);
        int backgroundResID = R.drawable.switch_background;
        int slideResID =R.drawable.slide_button_background;
        toggleView.setImagesResID(backgroundResID,slideResID);
        toggleView.setCurrentToggleState(!true);
        toggleView.setOnToggleStateChangeListener(this);
    }

    @Override
    public void onToggleState(boolean currentState) {
        Toast.makeText(getApplicationContext(), currentState ? "开启" : "关闭", Toast.LENGTH_SHORT).show();
    }
}
