package com.wilson.myview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wilson.myview.R;
import com.wilson.myview.view.refresh.RefreshListView;

import java.util.ArrayList;

public class RefreshActivity extends Activity {
    private RefreshListView refreshListView;
    private ArrayList<String> list = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initView();
        initData();
    }

    private void initView() {
        refreshListView = (RefreshListView) findViewById(R.id.refreshListView);
    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
            list.add("listview原来的数据 - " + i);
        }
//		final View headerView = View.inflate(this, R.layout.layout_header, null);
        //第一种方法
//		headerView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
//			@Override
//			public void onGlobalLayout() {
//				headerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//				int headerViewHeight = headerView.getHeight();
//				headerView.setPadding(0, -headerViewHeight, 0, 0);
//				refreshListView.addHeaderView(headerView);//
//			}
//		});
        //第二种方法
//		headerView.measure(0, 0);//主动通知系统去测量
//		int headerViewHeight = headerView.getMeasuredHeight();
//		headerView.setPadding(0, -headerViewHeight, 0, 0);
//		refreshListView.addHeaderView(headerView);//

        adapter = new MyAdapter();
        refreshListView.setAdapter(adapter);

        refreshListView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                //需要联网请求服务器的数据，然后更新UI
                requestDataFromServer(false);
            }

            @Override
            public void onLoadingMore() {
                requestDataFromServer(true);
            }
        });

    }

    /**
     * 模拟向服务器请求数据
     */
    private void requestDataFromServer(final boolean isLoadingMore) {
        new Thread() {
            public void run() {
                SystemClock.sleep(3000);//模拟请求服务器的一个时间长度
                if (isLoadingMore) {
                    list.add("加载更多的数据-1");
                    list.add("加载更多的数据-2");
                    list.add("加载更多的数据-3");
                } else {
                    list.add(0, "下拉刷新的数据");
                }
                //在UI线程更新UI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        refreshListView.completeRefresh();
                    }
                });
            }
        }.start();
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(RefreshActivity.this);
            textView.setPadding(20, 20, 20, 20);
            textView.setTextSize(18);
            textView.setText(list.get(position));
            return textView;
        }

    }
}
