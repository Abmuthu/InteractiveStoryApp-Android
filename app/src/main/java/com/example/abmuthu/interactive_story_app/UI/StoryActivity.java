package com.example.abmuthu.interactive_story_app.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abmuthu.interactive_story_app.Model.Page;
import com.example.abmuthu.interactive_story_app.Model.Story;
import com.example.abmuthu.interactive_story_app.R;

public class StoryActivity extends AppCompatActivity {

    private static final String TAG = StoryActivity.class.getSimpleName();
    private ImageView mStoryImageView;
    private TextView mStoryTextView;
    private Button mChoice1Button;
    private Button mChoice2Button;
    private String mName;


    private Story story = new Story();
    private Page mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);


        Intent intent = getIntent();
        mName = intent.getStringExtra("Name");
        Log.d(TAG, mName);

        mStoryImageView = (ImageView) findViewById(R.id.storyImageView);
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1Button = (Button) findViewById(R.id.choice1Button);
        mChoice2Button = (Button) findViewById(R.id.choice2Button);

        loadStory(0);
    }

    private void loadStory(int choice){
        mCurrentPage = story.getPage(choice);
        Drawable drawable = ContextCompat.getDrawable(this, mCurrentPage.getImageId());
        mStoryImageView.setImageDrawable(drawable);
        String storyText = mCurrentPage.getText();

        // Name will appear in text if Placeholder is present. Name will not appear if theres no Placeholder
        mStoryTextView.setText(String.format(storyText, mName));
        if (mCurrentPage.isFinal()){
            mChoice1Button.setVisibility(View.INVISIBLE);
            mChoice2Button.setText("PLAY AGAIN");
            mChoice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        else {
            mChoice1Button.setText(mCurrentPage.getChoice1().getText());
            mChoice2Button.setText(mCurrentPage.getChoice2().getText());

            mChoice1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadStory(nextPage);
                }
            });

            mChoice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadStory(nextPage);
                }
            });

        }


    }

}
