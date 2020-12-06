package com.example.first_aid.database;

import java.util.ArrayList;
import java.util.List;

public class odapNote {

    public static List<List<String>> odapB=new ArrayList<List<String>>();

    public void setOdapB(List<String> list){
        odapB.add(list);
    }

    public List<List<String>> getOdapB(){
        return odapB;
    }
}
