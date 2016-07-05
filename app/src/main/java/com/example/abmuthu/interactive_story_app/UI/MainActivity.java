package com.example.abmuthu.interactive_story_app.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abmuthu.interactive_story_app.R;

public class MainActivity extends AppCompatActivity {

    private Button mStartButton;
    private EditText mStartEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartButton = (Button) findViewById(R.id.startButton);
        mStartEditText = (EditText) findViewById(R.id.startEditText);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mStartEditText.getText().toString();
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                startStory(name);
            }
        });
    }

    private void startStory(String name){
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("Name", name);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mStartEditText.setText("");
    }
}
