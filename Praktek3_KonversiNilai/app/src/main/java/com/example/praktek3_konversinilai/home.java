package com.example.praktek3_konversinilai;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        Button btnNilai = findViewById(R.id.btn_nilai);
        Button btnPetunjuk = findViewById(R.id.btn_petunjuk);
        Button btnTentang = findViewById(R.id.btn_tentang);

        btnNilai.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, MainActivity.class);
            startActivity(intent);
        });

        btnPetunjuk.setOnClickListener(v -> {
            new AlertDialog.Builder(home.this)
                    .setTitle("Petunjuk Penggunaan")
                    .setMessage("1. Klik menu 'Nilai Mahasiswa' untuk membuka form konversi nilai.\n\n" +
                            "2. Masukkan Nama Mahasiswa, Nilai Tugas, dan Nilai Kehadiran.\n\n" +
                            "3. Klik tombol 'HITUNG' untuk melihat Nilai Angka dan Nilai Huruf.")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        btnTentang.setOnClickListener(v -> {
            new AlertDialog.Builder(home.this)
                    .setTitle("Tentang Aplikasi")
                    .setMessage("Aplikasi Konversi Nilai Mahasiswa\n\n" +
                            "Institusi: STMIK HANG TUAH PEKANBARU\n" +
                            "Versi: 1.0\n" +
                            "Deskripsi: Aplikasi untuk menghitung dan mengkonversi nilai mahasiswa berdasarkan nilai tugas dan kehadiran.")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}
