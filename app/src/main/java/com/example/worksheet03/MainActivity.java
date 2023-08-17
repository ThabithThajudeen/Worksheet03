package com.example.worksheet03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button[] noteButtons;
    private int noteCount =0;

    private int clickCount = 0;
    private List<String> noteList = new ArrayList<>();

    ActivityResultLauncher<Intent> detailActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    String amount = intent.getStringExtra("NoteAmount");
                    noteList.add(amount);
                    noteCount++;
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
        for (int i = 0; i < noteButtons.length; i++) {
            noteButtons[i].setVisibility(View.INVISIBLE);
            final int noteIndex = i;
            noteButtons[i].setOnClickListener(view -> {
                startNoteClassActivity(noteIndex);
            });
        }


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickCount < noteButtons.length) {
                    noteButtons[clickCount].setVisibility(View.VISIBLE);

                    //final int noteIndex = i;

                    clickCount++;
                }
                Intent intent = new Intent(MainActivity.this, NoteClass.class);
                detailActivityLauncher.launch(intent);
                //startActivity(intent);
            }
        });

    }
    private void startNoteClassActivity(int noteIndex) {
        Intent intent = new Intent(MainActivity.this, NoteClass.class);
        intent.putExtra("noteIndex", noteIndex);
        detailActivityLauncher.launch(intent);
    }




}
