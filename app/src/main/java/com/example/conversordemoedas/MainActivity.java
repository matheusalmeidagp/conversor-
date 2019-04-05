package com.example.conversordemoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button bConvertwer;
    private RadioGroup rgConversao;
    private EditText editDolar, editReal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDolar = findViewById(R.id.editDolar);
        editReal = findViewById(R.id.editReal);
        rgConversao = findViewById(R.id.rgConversao);
        bConvertwer = findViewById(R.id.bConverter);

        bConvertwer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dolartxt = editDolar.getText().toString();
                String realtx = editReal.getText().toString();
                Double cotacao = 3.87;
                Double valorConvertido;

                int rgConverter = rgConversao.getCheckedRadioButtonId();
                switch (rgConverter){
                    case R.id.rbDR:
                        rgConverter = 1;
                        break;
                    case R.id.rbRD:
                        rgConverter = 2;
                        break;
                }
                if (rgConverter == 1){
                    Double dolar = Double.parseDouble(dolartxt);
                    valorConvertido = dolar*cotacao;
                    DecimalFormat df = new DecimalFormat();
                    df.applyPattern("#0.00#");
                    editReal.setText(df.format(valorConvertido));
                }else if (rgConverter == 2){
                    Double real = Double.parseDouble(dolartxt);
                    valorConvertido = real/cotacao;
                    DecimalFormat df = new DecimalFormat();
                    df.applyPattern("#0.00#");
                    editDolar.setText(df.format(valorConvertido));
                }

            }
        });


    }
}
