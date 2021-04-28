package com.example.bailes_activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText text_username, text_password;
    Button button_login,button_register;
    DBLinker DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        text_username = (EditText) findViewById(R.id.txt_username2);
        text_password = (EditText) findViewById(R.id.txt_password2);
        button_login = (Button) findViewById(R.id.btn_login);
        button_register = (Button) findViewById(R.id.btn_signup);
        DB = new DBLinker(this);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = text_username.getText().toString();
                String pass = text_password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginPage.this, "Not all fields are entered", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginPage.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
}