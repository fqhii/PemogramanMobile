package com.example.praktek4_kirimdata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profil_Pegawai extends AppCompatActivity {

    private EditText edHasilNama, edHasilAlamat, edHasilUmur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profil_pegawai);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edHasilNama = findViewById(R.id.ed_hasil_nama);
        edHasilAlamat = findViewById(R.id.ed_hasil_alamat);
        edHasilUmur = findViewById(R.id.ed_hasil_umur);

        Intent intent = getIntent();
        if (intent != null) {
            String nama = intent.getStringExtra("EXTRA_NAMA");
            String alamat = intent.getStringExtra("EXTRA_ALAMAT");
            String umur = intent.getStringExtra("EXTRA_UMUR");

            if (nama != null) edHasilNama.setText(nama);
            if (alamat != null) edHasilAlamat.setText(alamat);
            if (umur != null) edHasilUmur.setText(umur + " Tahun");
        }
    }
}
