package com.example.worksheet03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button[] noteButtons;
    private int clickCount = 0;

    ActivityResultLauncher<Intent> detailActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    String amount = intent.getStringExtra("NoteAmount");

                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addButton = findViewById(R.id.addNote);
        noteButtons = new Button[]{
                findViewById(R.id.noteOne),
                findViewById(R.id.noteTwo),
        findViewById(R.id.noteThree),
        findViewById(R.id.noteFour),
        };

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickCount < noteButtons.length) {
                    noteButtons[clickCount].setVisibility(View.VISIBLE);
                    clickCount++;
                }
                Intent intent = new Intent(MainActivity.this, NoteClass.class);
                detailActivityLauncher.launch(intent);
                //startActivity(intent);
            }
        });

    }




}
