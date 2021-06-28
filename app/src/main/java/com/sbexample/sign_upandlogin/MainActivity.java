package com.sbexample.sign_upandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button signup;
    TextView btn;
    EditText uname,password,cpassword;
    private String usname;
    private String psw;
    private String cpsw;
    private static final String PASSWORD_PATTERN="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

    Pattern pattern=Pattern.compile(PASSWORD_PATTERN);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.text1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });
        signup=findViewById(R.id.signup);
        uname=findViewById(R.id.username);
        password=findViewById(R.id.passwd);
        cpassword=findViewById(R.id.cpasswd);




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usname=uname.getText().toString();
                psw=password.getText().toString();
                cpsw=cpassword.getText().toString();
                if(usname.isEmpty() || psw.isEmpty() || cpsw.isEmpty()){
                    Toast.makeText(MainActivity.this,"Username/Password cannot be empty",Toast.LENGTH_SHORT).show();
                }
                if(psw.equals(cpsw)==false){
                    Toast.makeText(MainActivity.this,"Password mismatched,please re-enter",Toast.LENGTH_SHORT).show();

                }
                if(isValid()){
                    Bundle bundle=new Bundle();
                    bundle.putString("Username",usname);
                    bundle.putString("Password",cpsw);

                    Intent intent=new Intent(getApplicationContext(),Login.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
    private boolean isValid(){
        if(!pattern.matcher(cpsw).matches()){
            Toast.makeText(MainActivity.this,"Password should contain atleast 1 uppercase\n"+ "1 lowecase character\n"+"1 digit\n"+"1 special character\n"+"minimum 8 characters long",Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }
}
