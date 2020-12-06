package com.example.first_aid.Quiz;

public class ListViewItem {
    private String categoryS;
    private String numS;
    private String contentS;

    public void setCategoryS(String category){
        categoryS=category;
    }

    public void setNumS(String num){
        numS=num;
    }

    public void setContentS(String content){
        contentS=content;
    }

    public String getCategoryS(){
        return this.categoryS;
    }

    public String getNumS(){
        return this.numS;
    }

    public String getContentS(){
        return this.contentS;
    }
}
