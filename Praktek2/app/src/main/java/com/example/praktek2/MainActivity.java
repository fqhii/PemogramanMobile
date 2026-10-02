package com.example.praktek2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        Button btnProfil = findViewById(R.id.btn_profil);
        Button btnTentang = findViewById(R.id.btn_tentang);
        Button btnHubungi = findViewById(R.id.btn_hubungi);

        if (btnProfil != null) {
            btnProfil.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, profil.class);
                startActivity(intent);
            });
        }

        if (btnTentang != null) {
            btnTentang.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, tentang.class);
                startActivity(intent);
            });
        }

        if (btnHubungi != null) {
            btnHubungi.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@uhtp.ac.id"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Tanya seputar Praktek 2");
                    startActivity(Intent.createChooser(intent, "Pilih aplikasi email..."));
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Hubungi kami: info@uhtp.ac.id", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
