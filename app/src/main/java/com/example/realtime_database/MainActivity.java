package com.example.realtime_database;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view)
    {
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);

        String roll=t1.getText().toString().trim();
        String name=t2.getText().toString().trim();
        String age=t3.getText().toString().trim();
        String course=t4.getText().toString().trim();

        dataHolder holder=new dataHolder(name,age,course );

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("student");
        node.child(roll).setValue(holder);

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        Toast.makeText(getApplicationContext(),"Value inserted",Toast.LENGTH_LONG).show();


    }
}