package com.bankapp.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView balance;
    private EditText edit_money;
    private Button bt_withdraw;
    private Button bt_deposit;

    DecimalFormat df = new DecimalFormat("#.00");
    Double balanceAccount = 3000.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        StartComponents();
        balance.setText("Saldo em conta: " + "R$ " + df.format(balanceAccount));

        bt_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double money;
                money = Double.parseDouble(edit_money.getText().toString());
                if (money < balanceAccount && money > 20) {
                    balanceAccount -= money;
                    edit_money.setText("");
                    balance.setText("Saldo em conta: " + "R$ " + df.format(balanceAccount));
                    Toast.makeText(MainActivity.this, "R$ "
                            + df.format(balanceAccount) +
                            " Sacados!", Toast.LENGTH_SHORT).show();
                } else if (money < 20) {
                    Toast.makeText(MainActivity.this, "Saldo menor que R$ 20,00!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Não possui saldo suficiente!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double money;
                money = Double.parseDouble(edit_money.getText().toString());

                balanceAccount += money;
                edit_money.setText("");
                balance.setText("Saldo em conta: " + "R$ " + df.format(balanceAccount));
                Toast.makeText(MainActivity.this, "R$ "
                        + df.format(balanceAccount) +
                        " Depositado!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void StartComponents() {
        balance = findViewById(R.id.balance);
        edit_money = findViewById(R.id.edit_money);
        bt_withdraw = findViewById(R.id.bt_withdraw);
        bt_deposit = findViewById(R.id.bt_deposit);
    }

}