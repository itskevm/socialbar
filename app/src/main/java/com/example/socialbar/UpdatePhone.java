package com.example.socialbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UpdatePhone extends AppCompatActivity {

    private ImageView backIcon = null;
    private Button updateBtn = null;
    private EditText phoneNumber = null;

    private String savedNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_phone);

        backIcon = (ImageView) findViewById(R.id.iv_back);
        backIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                goBack();
            }
        });

        loadData();

        phoneNumber = (EditText) findViewById(R.id.phoneValue);
        phoneNumber.setText(savedNumber);

        updateBtn = (Button) findViewById(R.id.update_btn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.i("FunctionCall",fullName);
                saveData();
            }
        });
    }

    public void goBack () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void saveData () {
        SharedPreferences sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userNumber", phoneNumber.getText().toString());
        editor.apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void loadData () {
        SharedPreferences sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE);
        savedNumber = sharedPreferences.getString("userNumber","");
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

}
