package com.mapache.shareaplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    private TextView text_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        text_msg = findViewById(R.id.textMsg);

        Intent mIntent = getIntent();
        if(mIntent != null){
            text_msg.setText(mIntent.getStringExtra(mIntent.EXTRA_TEXT));
        }
    }
}
