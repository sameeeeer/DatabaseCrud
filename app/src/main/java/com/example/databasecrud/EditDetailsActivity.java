package com.example.databasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDetailsActivity extends AppCompatActivity {
    EditText fname, femail, number;
    Button btnUpdate, btnreturn;
    String id, name, email, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);
        fname = findViewById(R.id.et_fullname);
        femail = findViewById(R.id.et_email);
        number = findViewById(R.id.et_phone);
        btnUpdate = findViewById(R.id.btnupdate);
        btnreturn = findViewById(R.id.btnreturn);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        phone = intent.getStringExtra("phone");

        fname.setText(name);
        femail.setText(email);
        number.setText(phone);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper db = new DbHelper(EditDetailsActivity.this);
                String ename = fname.getText().toString();
                String eemail = femail.getText().toString();
                String ephone = number.getText().toString();
                boolean status = db.updateStudentDetails(Integer.parseInt(id), ename, eemail, ephone);

                if(status){
                    Toast.makeText(EditDetailsActivity.this, "Student Details Changed!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditDetailsActivity.this, "Error! Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(EditDetailsActivity.this, DisplayStudentsActivity.class);
                startActivity(intent_back);
            }
        });


    }
}
