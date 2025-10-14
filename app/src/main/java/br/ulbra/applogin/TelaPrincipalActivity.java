package br.ulbra.applogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TelaPrincipalActivity extends AppCompatActivity {

    Button btnVoltarPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telaprincipal);

        btnVoltarPrincipal =(Button) findViewById(R.id.btnVoltarPrincipal);

        btnVoltarPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaPrincipalActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }


}