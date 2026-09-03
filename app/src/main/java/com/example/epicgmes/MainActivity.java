package com.example.epicgmes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Primeiro coloca a tela na tela
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Encontra o botão
        Button proxima = findViewById(R.id.proximo);

        // Quando clicar no botão, abre a MainActivity2
        proxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });

        // ViewPager dos jogos
        ViewPager2 viewPager = findViewById(R.id.viewPagerJogos);

        int[] imagens = {
                R.drawable.battlefield,
                R.drawable.resident,
                R.drawable.phantom1,
                R.drawable.first
        };

        String[] precos = {
                "R$ 174,95",
                "R$ 360,54",
                "R$ 249,90",
                "R$ 299,00"
        };

        List<Integer> listaImagens = new ArrayList<>();

        for (int imagem : imagens) {
            listaImagens.add(imagem);
        }

        List<String> listaPrecos = Arrays.asList(precos);

        ImageAdapter adapter = new ImageAdapter(
                listaImagens,
                listaPrecos
        );

        viewPager.setAdapter(adapter);

        // Ajuste das margens da tela
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );
    }
}
