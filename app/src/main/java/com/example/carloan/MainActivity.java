package com.example.carloan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView textPurchaseprice;
    private EditText editPurchaseprice;
    private TextView textDownpayment;
    private EditText editDownpayment;
    private TextView textAnnualinterest;
    private EditText editAnnualinterest;
    private TextView textMonths;
    private EditText editMonths;
    private Button button;
    private ToggleButton toggleButton;
    private TextView textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPurchaseprice = findViewById(R.id.textPurchaseprice);
        editPurchaseprice = findViewById(R.id.editPurchaseprice);
        textDownpayment = findViewById(R.id.textDownpayment);
        editDownpayment = findViewById(R.id.editDownpayment);
        textAnnualinterest = findViewById(R.id.textAnnualinterest);
        editAnnualinterest = findViewById(R.id.editAnnualinterest);
        textMonths = findViewById(R.id.textMonths);
        editMonths = findViewById(R.id.editMonths);
        toggleButton = findViewById(R.id.toggleButton);
        textTotal = findViewById(R.id.textTotal);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Price = Double.parseDouble(editPurchaseprice.getText().toString());
                double Annual = Double.parseDouble(editAnnualinterest.getText().toString());
                double DownPayment = Double.parseDouble(editDownpayment.getText().toString());
                double Length = Double.parseDouble(editMonths.getText().toString());

                if (toggleButton.isChecked())
                    textTotal.setText("" + Annual / 100 / 12 * (Price - DownPayment) / (1 - (Math.pow(1 + Annual / 100 / 12, Length * -1))));
                else
                    textTotal.setText("" + (Annual / 100 / 12 * ((Price - DownPayment) / 3) / 1 - (Math.pow(1 + Annual / 100 / 12, 36))));

            }
        });


    }


}