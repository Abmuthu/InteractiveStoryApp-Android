package com.example.abmuthu.interactive_story_app.Model;

/**
 * Created by abmuthu on 7/4/16.
 */
public class Choice {
    private String mText;
    private int mNextPage;

    public Choice(String text, int nextPage){
        mText = text;
        mNextPage = nextPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
