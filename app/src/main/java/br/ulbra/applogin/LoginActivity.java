package br.ulbra.applogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edLogin, edPass;
    Button btEntrar, btVoltar2;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DBHelper(this);
        edLogin = (EditText)findViewById(R.id.edLogin);
        edPass = (EditText)findViewById(R.id.edPass);
        btEntrar = (Button)findViewById(R.id.btEntrar);
        btVoltar2 = (Button)findViewById(R.id.btVoltar2);


        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edLogin.getText().toString();
                String password=edPass.getText().toString();
                if(username.equals("")){
                    Toast.makeText(LoginActivity.this,"Usuario não inserido, tente novamente",Toast.LENGTH_SHORT).show();
                }else if(password.equals("")){
                    Toast.makeText(LoginActivity.this,"Senha não inserida, tente novamente",Toast.LENGTH_SHORT).show();
                }else{
                    String res = db.validarLogin(username,password);
                    if(res.equals("OK")){
                        Toast.makeText(LoginActivity.this,"Login OK !!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this,"Login ou Senha errado(s)!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}





