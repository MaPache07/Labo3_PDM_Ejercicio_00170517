package com.mapache.shareaplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.mapache.shareaplication.utils.AppConstants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button_send;
    public EditText edit_username, edit_password, edit_email;
    private RadioButton radio_male, radio_female;
    private String username, password, email, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        radio_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "Male";
            }
        });
        radio_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "Female";
            }
        });

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edit_username.getText().toString();
                password = edit_password.getText().toString();
                email = edit_email.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.KEY_USERNAME, username);
                bundle.putString(AppConstants.KEY_PASSWORD, password);
                bundle.putString(AppConstants.KEY_GENDER, gender);
                bundle.putString(AppConstants.KEY_EMAIL, email);
                Intent mIntent = new Intent(MainActivity.this, ShareActivity.class);
                mIntent.putExtras(bundle);
                startActivity(mIntent);
            }
        });
    }

    public void initializeViews(){
        button_send = findViewById(R.id.button_send);
        edit_username = findViewById(R.id.edit_username);
        edit_password = findViewById(R.id.edit_password);
        edit_email = findViewById(R.id.edit_email);
        radio_male = findViewById(R.id.radio_male);
        radio_female = findViewById(R.id.radio_female);
    }

}
