package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText n,e,p;
    Button btn;
    TextView l;
    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Auth=FirebaseAuth.getInstance();
        n=findViewById(R.id.editTextText);
        e=findViewById(R.id.editTextText2);
        p=findViewById(R.id.editTextText3);
        btn=findViewById(R.id.button);
        l=findViewById(R.id.textView3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=n.getText().toString();
                String email=e.getText().toString();
                String password=p.getText().toString();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(SignUp.this,"Please Enter Full name",Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(SignUp.this,"Please Enter Email",Toast.LENGTH_LONG).show();
                }else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(SignUp.this,"Please Enter Password",Toast.LENGTH_LONG).show();
                }else{
                    Auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUp.this,"Success",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(SignUp.this,"Failed",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }

        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,SignIn.class);
                startActivity(intent);
                finish();

            }
        });
    }



}