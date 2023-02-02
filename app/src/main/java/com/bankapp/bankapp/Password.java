package com.bankapp.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password extends AppCompatActivity {

    private EditText account;
    private EditText password;
    private Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        getSupportActionBar().hide();

        account = findViewById(R.id.edit_account);
        password = findViewById(R.id.edit_password);
        buttonConfirm = findViewById(R.id.bt_confirm);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int registeredAccount = 1234;
                int registeredPassword = 789456;

                int typeAccount = Integer.parseInt(account.getText().toString());
                int typePassword = Integer.parseInt(password.getText().toString());

                if (registeredAccount == typeAccount && registeredPassword == typePassword) {
                    goToMainActivity();
                } else {
                    Toast.makeText(Password.this, "Senha Errada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}