package com.example.hp.blogapp.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import com.example.hp.blogapp.Activities.adapters.NewsFeedAdapter;
import com.example.hp.blogapp.Activities.adapters.NotificationAdapter;
import com.example.hp.blogapp.Activities.common.Common;
import com.example.hp.blogapp.Activities.model.Blog;
import com.example.hp.blogapp.Activities.model.Notification;
import com.example.hp.blogapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity implements NewsFeedAdapter.BlogFilterListener {

    List<Notification> notificationList = new ArrayList<>();
    List<Blog> newsFeedList = new ArrayList<>();
    NewsFeedAdapter newsFeedAdapter;
    NotificationAdapter notificationAdapter;

    EditText searchEditText;


    BottomNavigationView navigationView;
    RelativeLayout newsFeedLayout;
    RecyclerView newsFeedRecyclerView;

    RelativeLayout notificationLayout;

    RecyclerView notificationRecyclerView;


    RelativeLayout userAcoountLayout;

    EditText userName;

    CircleImageView circleImageView;

    Button accountSettingButton;

    LinearLayout toolBarLayout;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        circleImageView = findViewById(R.id.cicrle_image_view);
        accountSettingButton = findViewById(R.id.account_setting_button);
        toolBarLayout = toolbar.findViewById(R.id.toolbar_layout);
        newsFeedLayout = findViewById(R.id.news_feed_layout);
        userAcoountLayout = findViewById(R.id.user_account_layout);
        userName = findViewById(R.id.user_name);
        newsFeedRecyclerView = findViewById(R.id.news_feed_recylerview);
        notificationLayout = findViewById(R.id.notification_layout);
        notificationRecyclerView = findViewById(R.id.notification_recylerview);

        searchEditText = toolbar.findViewById(R.id.searchEditText);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_home:


                    setUpNewsFeedFragment();


                    return true;
                case R.id.navigation_account:

                    setUpAccountSettingFragment();

                    return true;
                case R.id.navigation_notifications:

                    setUpNotificationsFragment();

                    return true;
            }
            return false;
        }
    };

    private void setUpNotificationsFragment() {

        //VISIBILITY

        notificationLayout.setVisibility(View.VISIBLE);
        userAcoountLayout.setVisibility(View.GONE);
        newsFeedLayout.setVisibility(View.GONE);
        toolBarLayout.setVisibility(View.GONE);
        getSupportActionBar().setTitle("Notifications");


        //SETUP RECYCLERVIEW

        notificationRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (notificationList.size() >= 0) {
            notificationAdapter = new NotificationAdapter(notificationList, this);
            notificationRecyclerView.setAdapter(notificationAdapter);
        } else {
            notificationAdapter = new NotificationAdapter(Common.getNotifications(notificationList), this);
            notificationRecyclerView.setAdapter(notificationAdapter);
        }

    }

    private void setUpAccountSettingFragment() {

        //VISIBILITY
        notificationLayout.setVisibility(View.GONE);
        userAcoountLayout.setVisibility(View.VISIBLE);
        newsFeedLayout.setVisibility(View.GONE);
        toolBarLayout.setVisibility(View.GONE);
        getSupportActionBar().setTitle("Account Settings");


    }

    private void setUpNewsFeedFragment() {

        //VISIBILITY
        notificationLayout.setVisibility(View.GONE);
        userAcoountLayout.setVisibility(View.GONE);
        newsFeedLayout.setVisibility(View.VISIBLE);
        toolBarLayout.setVisibility(View.VISIBLE);
        getSupportActionBar().setTitle("");


        newsFeedRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (newsFeedList.size() >= 0) {
            newsFeedAdapter = new NewsFeedAdapter(newsFeedList, this, this);
            newsFeedRecyclerView.setAdapter(newsFeedAdapter);
        } else {
            newsFeedAdapter = new NewsFeedAdapter(Common.getBlogs(newsFeedList), this, this);
            newsFeedRecyclerView.setAdapter(newsFeedAdapter);
        }


        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                newsFeedAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onBlogFiltered(Blog blog) {

    }
}
