package com.example.worksheet03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_class);
        Button button = findViewById(R.id.button);
        EditText amount = findViewById(R.id.NoteAmount);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount01 = amount.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("NoteAmount",amount01);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

    }
}