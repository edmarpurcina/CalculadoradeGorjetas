package com.example.calculadoradegorjetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private SeekBar percentGorjeta;
    private TextView txtGorjeta, txtPercenteGorjeta, txtTotal;
    private TextInputEditText valorConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // textView
        txtGorjeta = findViewById(R.id.textGorjeta);
        txtPercenteGorjeta = findViewById(R.id.textPercent);
        txtTotal = findViewById(R.id.textTotal);

        // SeekBar
        percentGorjeta = findViewById(R.id.seekBar);

        // TextInputEditText
        valorConta = findViewById(R.id.inputConta);

        listnerSeekbar();
    }


    public void listnerSeekbar(){

        percentGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                double gorjeta;
                txtPercenteGorjeta.setText(progress + "%");

                if ( valorConta.getText().toString().isEmpty() ){

                    Toast.makeText(getApplicationContext(), "Informe um valor para a conta", Toast.LENGTH_SHORT).show();

                }else {

                    System.out.println("Valor conta == " + valorConta.getText().toString());
                    double valorGorjeta = Double.parseDouble(valorConta.getText().toString());

                    if (progress != 0) {
                        gorjeta = valorGorjeta * (progress / 100.0);

                    } else {

                        gorjeta = 0.00;

                    }
                    txtGorjeta.setText("R$ " + String.valueOf(gorjeta));

                    double total = Double.parseDouble(valorConta.getText().toString()) + gorjeta;

                    txtTotal.setText("R$ " + String.valueOf(total));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });

    }


}
