package com.sbexample.sign_upandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button btnlogin;
    EditText loginuser,loginpass;
    String struname,strpsw;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView btn=findViewById(R.id.lgtosn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,MainActivity.class));
            }
        });
        loginuser=findViewById(R.id.username);
        loginpass=findViewById(R.id.passwd);
        btnlogin=findViewById(R.id.btnlogin);

        Bundle bundle=getIntent().getExtras();
        struname=bundle.getString("Username");
        strpsw=bundle.getString("Password");
        final Intent intent=new Intent(getApplicationContext(),loginsuccesful.class);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<3){
                    if(loginuser.getText().toString().equals(struname) && loginpass.getText().toString().equals(strpsw)){
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this,"Username/Password is invalid",Toast.LENGTH_SHORT).show();
                        count++;
                        loginuser.setText(null);
                        loginpass.setText(null);
                    }
                }
                else{
                    Toast.makeText(Login.this,"Maximum attempt reached",Toast.LENGTH_SHORT).show();
                    btnlogin.setEnabled(false);
                }
            }
        });
    }
}
