package com.example.tracer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class JoinActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText editTextEmail;
    private EditText editTextPassWord;
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextTel;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        firebaseAuth = firebaseAuth.getInstance();

        editTextEmail = (EditText) findViewById(R.id.editText_Email);
        editTextPassWord = (EditText) findViewById(R.id.editText_Password);
        editTextName = (EditText) findViewById(R.id.editText_Name);
        editTextAge = (EditText) findViewById(R.id.editText_Age);
        editTextTel = (EditText) findViewById(R.id.editText_Tel);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (!editTextEmail.getText().toString().equals("")&&!editTextPassWord.getText().toString().equals("")){
                    // id 와 pw가 공백이 아닌 경우
                    createUser(editTextEmail.getText().toString(),
                            editTextPassWord.getText().toString(), editTextName.getText().toString(),
                            editTextAge.getText().toString(), editTextTel.getText().toString());
                }else{
                    Toast.makeText(JoinActivity.this, "이메일과 비밀번호를 입력하세요",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void createUser(String email, String password, String name, String age, String tel){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                if (task.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(JoinActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    // 중복 계정인경우
                    Toast.makeText(JoinActivity.this, "이미 존재하는 이메일입니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}