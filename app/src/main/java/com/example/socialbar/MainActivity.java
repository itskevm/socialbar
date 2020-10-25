package com.example.socialbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView userName = null;
    public static TextView phoneNumber = null;
    public static TextView emailAddress = null;
    public static TextView userBio = null;

    private String savedFirstName = null;
    private String savedLastName = null;
    private String savedNumber = null;
    private String savedEmail = null;
    private String savedBio = null;

    public static final int DEF = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (TextView) findViewById(R.id.textView_nameValue);
        phoneNumber = (TextView) findViewById(R.id.textView_phoneValue);
        emailAddress = (TextView) findViewById(R.id.textView_emailValue);
        userBio = (TextView) findViewById(R.id.textView_bioValue);

        // Load previous values
        loadUserData();

        // Set values in the text fields
        setUserData();


        LinearLayout nameField = (LinearLayout) findViewById(R.id.select_name_layout);
        LinearLayout phoneField = (LinearLayout) findViewById(R.id.select_phone_layout);
        LinearLayout emailField = (LinearLayout) findViewById(R.id.select_email_layout);
        LinearLayout bioField = (LinearLayout) findViewById(R.id.select_bio_layout);

        nameField.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                editName();
            }
        });
        phoneField.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                editPhone();
            }
        });
        emailField.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                editEmail();
            }
        });
        bioField.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                editBio();
            }
        });


    }

    public void loadUserData () {
        System.out.println("Loading User Data.");
        SharedPreferences sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE);
        savedFirstName = sharedPreferences.getString("userFirstName","");
        savedLastName = sharedPreferences.getString("userLastName","");
        savedNumber = sharedPreferences.getString("userNumber","");
        savedEmail = sharedPreferences.getString("userEmail","");
        savedBio = sharedPreferences.getString("userBio","");
    }

    public void setUserData () {
        System.out.println("Setting User Data.");
        userName.setText(savedFirstName + " " + savedLastName);
        phoneNumber.setText(savedNumber);
        emailAddress.setText(savedEmail);
        userBio.setText(savedBio);
    }

    public void editName () {
        System.out.println("Proceeding to Edit Name.");
        Intent intent = new Intent(this, UpdateName.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void editPhone () {
        System.out.println("Proceeding to Edit Phone.");
        Intent intent = new Intent(this, UpdatePhone.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void editEmail () {
        System.out.println("Proceeding to Edit Email.");
        Intent intent = new Intent(this, UpdateEmail.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void editBio () {
        System.out.println("Proceeding to Edit Bio.");
        Intent intent = new Intent(this, UpdateBio.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
