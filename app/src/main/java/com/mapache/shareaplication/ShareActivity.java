package com.mapache.shareaplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mapache.shareaplication.utils.AppConstants;

public class ShareActivity extends AppCompatActivity {

    private TextView text_username, text_password, text_email, text_gender;
    private Button button_send2;
    private String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        initializeViews();

        Bundle bundle = getIntent().getExtras();
        Intent mIntent = this.getIntent();
        if (mIntent != null) {
            text_username.setText(bundle.getString(AppConstants.KEY_USERNAME));
            text_password.setText(bundle.getString(AppConstants.KEY_PASSWORD));
            text_email.setText(bundle.getString(AppConstants.KEY_EMAIL));
            text_gender.setText(bundle.getString(AppConstants.KEY_GENDER));
        }

        button_send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message();
                Intent mIntent = new Intent();
                mIntent.setAction(Intent.ACTION_SEND);
                mIntent.setType("text/plain");
                mIntent.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(mIntent);
            }
        });

    }

    public void initializeViews(){
        text_username = findViewById(R.id.text_username);
        text_password = findViewById(R.id.text_password);
        text_email = findViewById(R.id.text_email);
        text_gender = findViewById(R.id.text_gender);
        button_send2 = findViewById(R.id.button_send2);
    }

    public void message(){
        msg = text_username.getText().toString() + "\n" + text_password.getText().toString() + "\n" + text_email.getText().toString() + "\n" + text_gender.getText().toString();
    }

}
