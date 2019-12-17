package com.example.databasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databasecrud.models.Student;

public class MainActivity extends AppCompatActivity {

    EditText fname, femail, number;
    DbHelper dbHelper;
    Button btnsave, btnshow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = findViewById(R.id.btnsave);
        btnshow = findViewById(R.id.btnshow);

        fname = findViewById(R.id.et_fullname);
        femail = findViewById(R.id.et_email);
        number = findViewById(R.id.et_phone);

        dbHelper = new DbHelper(MainActivity.this);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fname.getText().toString();
                String email = femail.getText().toString();
                String phone = number.getText().toString();

                boolean sts = dbHelper.insertStudent(new Student(0, name, email, phone));

                if(sts){
                    Toast.makeText(MainActivity.this, "Student Added Successful!", Toast.LENGTH_SHORT).show();
                    fname.getText().clear();
                    femail.getText().clear();
                    number.getText().clear();
                } else {
                    Toast.makeText(MainActivity.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayStudentsActivity.class);
                startActivity(intent);
            }
        });

    }
}
