package com.example.first_aid.database;

import java.util.ArrayList;
import java.util.List;

public class odapNote {

    public static List<List<String>> odapAll=new ArrayList<List<String>>();
    public static List<List<String>> odapB=new ArrayList<List<String>>();
    public static int count=0;

    public void setOdapB(List<String> list){
        odapB.add(list);
    }

    public List<List<String>> getOdapB(){
        return odapB;
    }

    public List<String> getOdapBlist(int i){
        List<String> odap=odapB.get(i);
        return odap;
    }

    public void cleaner(){
        odapB.clear();
    }

    public void remover(int A){
        odapAll.remove(A);
    }

    public void setOdapAll(){
        count=0;
        for(int i=0; i<odapB.size(); i++){
            odapAll.add(odapB.get(i));
        }
    }

    public List<String> getOdapAll(){
        List<String> odap=odapAll.get(count);
        count++;
        return odap;
    }

    public List<List<String>> getOdapAllA(){return odapAll;}

    public int getSize(){return odapAll.size();}

}
