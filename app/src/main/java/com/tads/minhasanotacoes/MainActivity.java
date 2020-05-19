package com.tads.minhasanotacoes;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView anotacao = findViewById(R.id.textoAnotacao);
                SharedPreferences sharedPreferences = getSharedPreferences("ANOTACOES", MODE_PRIVATE);
                SharedPreferences.Editor editorText = sharedPreferences.edit();
                editorText.putString("ANOTACAO", anotacao.getText().toString());
                editorText.apply();
                Snackbar.make(view, "Anotação salva!", Snackbar.LENGTH_LONG)
                        .setAction("OK!", null).show();
            }
        });
        TextView texto = findViewById(R.id.textoAnotacao);
        SharedPreferences sharedPreferences = getSharedPreferences("ANOTACOES", MODE_PRIVATE);
        if (sharedPreferences.contains("ANOTACAO")) {
            String anotacao = sharedPreferences.getString("ANOTACAO", "");
            texto.setText(anotacao);
        }
    }


}
