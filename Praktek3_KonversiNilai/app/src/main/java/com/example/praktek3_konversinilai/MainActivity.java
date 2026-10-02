package com.example.praktek3_konversinilai;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText edNama, edTugas, edKehadiran, edNilaiAngka, edHuruf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edNama = findViewById(R.id.ed_nama);
        edTugas = findViewById(R.id.ed_tugas);
        edKehadiran = findViewById(R.id.ed_kehadiran);
        Button btnHitung = findViewById(R.id.btn_hitung);
        edNilaiAngka = findViewById(R.id.ed_nilai_angka);
        edHuruf = findViewById(R.id.ed_huruf);

        btnHitung.setOnClickListener(v -> hitungNilai());
    }

    private void hitungNilai() {
        String nama = edNama.getText().toString().trim();
        String strTugas = edTugas.getText().toString().trim();
        String strKehadiran = edKehadiran.getText().toString().trim();

        if (TextUtils.isEmpty(nama)) {
            edNama.setError("Nama harus diisi");
            edNama.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strTugas)) {
            edTugas.setError("Nilai tugas harus diisi");
            edTugas.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strKehadiran)) {
            edKehadiran.setError("Nilai kehadiran harus diisi");
            edKehadiran.requestFocus();
            return;
        }

        double nilaiTugas = Double.parseDouble(strTugas);
        double nilaiKehadiran = Double.parseDouble(strKehadiran);

        if (nilaiTugas < 0 || nilaiTugas > 100) {
            edTugas.setError("Nilai tugas antara 0 - 100");
            edTugas.requestFocus();
            return;
        }

        if (nilaiKehadiran < 0 || nilaiKehadiran > 100) {
            edKehadiran.setError("Nilai kehadiran antara 0 - 100");
            edKehadiran.requestFocus();
            return;
        }

        double nilaiAngka = (nilaiTugas * 0.6) + (nilaiKehadiran * 0.4);
        String huruf;

        if (nilaiAngka >= 85) {
            huruf = "A";
        } else if (nilaiAngka >= 70) {
            huruf = "B";
        } else if (nilaiAngka >= 55) {
            huruf = "C";
        } else if (nilaiAngka >= 40) {
            huruf = "D";
        } else {
            huruf = "E";
        }

        edNilaiAngka.setText(String.format(Locale.getDefault(), "%.2f", nilaiAngka));
        edHuruf.setText(huruf);

        Toast.makeText(this, "Perhitungan Selesai untuk " + nama, Toast.LENGTH_SHORT).show();
    }
}
