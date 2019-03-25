package com.mapache.shareaplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.mapache.shareaplication.utils.AppConstants;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button button_send;
    public EditText edit_username, edit_password, edit_email;
    private RadioButton radio_male, radio_female;
    private String username, password, email, gender;
    private String msg_fail = "You haven't inserted all data";
    private TextView text_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edit_username.getText().toString();
                password = edit_password.getText().toString();
                email = edit_email.getText().toString();

                if (radio_male.isChecked()) {
                    gender = radio_male.getText().toString();
                }
                else{
                    gender = radio_female.getText().toString();
                }

                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher matcher = pattern.matcher(email);

                if(!matcher.matches()){
                    email = "";
                }

                if(username != ""  && password != "" && email != "" && gender != ""){
                    Bundle bundle = new Bundle();
                    bundle.putString(AppConstants.KEY_USERNAME, username);
                    bundle.putString(AppConstants.KEY_PASSWORD, password);
                    bundle.putString(AppConstants.KEY_GENDER, gender);
                    bundle.putString(AppConstants.KEY_EMAIL, email);
                    Intent mIntent = new Intent(MainActivity.this, ShareActivity.class);
                    mIntent.putExtras(bundle);
                    startActivity(mIntent);
                }
                else{
                    text_msg.setText(msg_fail);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void initializeViews(){
        button_send = findViewById(R.id.button_send);
        edit_username = findViewById(R.id.edit_username);
        edit_password = findViewById(R.id.edit_password);
        edit_email = findViewById(R.id.edit_email);
        radio_male = findViewById(R.id.radio_male);
        radio_female = findViewById(R.id.radio_female);
        text_msg = findViewById(R.id.msg_fail);
    }

}
