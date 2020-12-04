package com.example.first_aid.Quiz;

import android.graphics.drawable.Drawable;

public class ListViewBtnItem {
    private Drawable iconDrawable ;
    private String textStr ;

    public void setText(String text) {
        textStr = text ;
    }

    public String getText() {
        return this.textStr ;
    }
}
