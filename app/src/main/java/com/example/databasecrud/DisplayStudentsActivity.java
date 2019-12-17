package com.example.databasecrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databasecrud.adapters.StudentAdapter;
import com.example.databasecrud.models.Student;

import java.util.List;

public class DisplayStudentsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button BtntoStud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_students);


        recyclerView = findViewById(R.id.recyclerViewStudents);
        BtntoStud = findViewById(R.id.btnBtoA);


        DbHelper dbHelper = new DbHelper(DisplayStudentsActivity.this);
        List<Student> studentList = dbHelper.displayStudents();

        StudentAdapter studentAdapter = new StudentAdapter(DisplayStudentsActivity.this, studentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);

        BtntoStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayStudentsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
