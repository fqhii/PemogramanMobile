package com.example.praktek4_kirimdata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edNama, edAlamat, edUmur;
    private Button btnKirim;

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
        edAlamat = findViewById(R.id.ed_alamat);
        edUmur = findViewById(R.id.ed_umur);
        btnKirim = findViewById(R.id.btn_kirim);

        btnKirim.setOnClickListener(v -> {
            String nama = edNama.getText().toString().trim();
            String alamat = edAlamat.getText().toString().trim();
            String umur = edUmur.getText().toString().trim();

            if (nama.isEmpty() || alamat.isEmpty() || umur.isEmpty()) {
                Toast.makeText(MainActivity.this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, Profil_Pegawai.class);
            intent.putExtra("EXTRA_NAMA", nama);
            intent.putExtra("EXTRA_ALAMAT", alamat);
            intent.putExtra("EXTRA_UMUR", umur);
            startActivity(intent);
        });
    }
}
