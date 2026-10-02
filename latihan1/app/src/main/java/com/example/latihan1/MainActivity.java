package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latihan1.R;

public class MainActivity extends AppCompatActivity {
    EditText edPanjang, edLebar, edHasil;
    Button btHitung;
    double vPanjang, vLebar, vHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edPanjang = (EditText) findViewById(R.id.edPanjang);
        edLebar = (EditText) findViewById(R.id.edLebar);
        btHitung = (Button) findViewById(R.id.btHitung);
        edHasil = (EditText) findViewById(R.id.edHasil);
    }
    public void HITUNG (View view) {
        vPanjang = Double.parseDouble(edPanjang.getText().toString());
        vLebar = Double.parseDouble(edLebar.getText().toString());
        vHasil = vPanjang * vLebar;
        edHasil.setText("" + vHasil);
    }
}
