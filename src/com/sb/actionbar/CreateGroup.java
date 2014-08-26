package com.sb.actionbar;

import com.sb.studybuddies.R;
import com.sb.studybuddies.R.layout;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
 
public class CreateGroup extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
 
        // get action bar   
        ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}