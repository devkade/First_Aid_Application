package com.example.first_aid.database;

import java.util.ArrayList;
import java.util.List;

public class odapNote {

    public static List<List<String>> odapAll=new ArrayList<List<String>>();
    public static List<List<String>> odapNAll=new ArrayList<List<String>>();
    public static List<List<String>> odapA=new ArrayList<List<String>>();
    public static List<List<String>> odapNA=new ArrayList<List<String>>();
    public static List<List<String>> odapB=new ArrayList<List<String>>();
    public static List<List<String>> odapNB=new ArrayList<List<String>>();
    public static int count=0;

    public void setOdapA(List<String> list){
        odapA.add(list);
    }

    public void setOdapNA(List<String> list){
        odapNA.add(list);
    }

    public void setOdapB(List<String> list){
        odapB.add(list);
    }

    public void setOdapNB(List<String> list){
        odapNB.add(list);
    }

    public List<List<String>> getOdapA(){
        return odapA;
    }

    public List<List<String>> getOdapNA(){
        return odapNA;
    }

    public List<List<String>> getOdapB(){
        return odapB;
    }

    public List<List<String>> getOdapNB(){
        return odapNB;
    }

    public List<String> getOdapAlist(int i){
        List<List<String>> OdapAA=new ArrayList<List<String>>();
        for(int j=0; j<odapA.size(); j++) {
            OdapAA.add(odapA.get(j));
        }

        for(int j=0; j<odapNA.size(); j++) {
            OdapAA.add(odapNA.get(j));
        }

        List<String> odap = OdapAA.get(i);
        return odap;
    }

    public List<String> getOdapBlist(int i){
        List<List<String>> OdapBB=new ArrayList<List<String>>();
        for(int j=0; j<odapB.size(); j++) {
            OdapBB.add(odapB.get(j));
        }

        for(int j=0; j<odapNB.size(); j++) {
            OdapBB.add(odapNB.get(j));
        }

        List<String> odap = OdapBB.get(i);
        return odap;
    }

    public void Acleaner(){
        odapA.clear();
    }

    public void NAcleaner(){
        odapNA.clear();
    }

    public void Bcleaner(){
        odapB.clear();
    }

    public void NBcleaner(){
        odapNB.clear();
    }

    public void remover(int A){
        odapAll.remove(A);
    }

    public void Nremover(int A){
        odapNAll.remove(A);
    }

    public void setOdapAAll(){
        count=0;
        for(int i=0; i<odapA.size(); i++){
            odapAll.add(odapA.get(i));
        }
    }

    public void setOdapANumAll(){
        count=0;
        for(int i=0; i<odapNA.size(); i++){
            odapNAll.add(odapNA.get(i));
        }
    }

    public void setOdapBAll(){
        count=0;
        for(int i=0; i<odapB.size(); i++){
            odapAll.add(odapB.get(i));
        }
    }

    public void setOdapBNumAll(){
        count=0;
        for(int i=0; i<odapNB.size(); i++){
            odapNAll.add(odapNB.get(i));
        }
    }

    public List<String> getOdapAll(){
        if(odapAll.size()>0){
            List<String> odap=odapAll.get(count);
            count++;
            return odap;
        }
        else{
            List<String> odap=new ArrayList<String>();
            return odap;
        }
    }

    public List<String> getOdapNAll(){
        if(odapNAll.size()>0){
            List<String> odap=odapNAll.get(count);
            count++;
            return odap;
        }
        else{
            List<String> odap=new ArrayList<String>();
            return odap;
        }
    }

    public List<String> getOdapAlllist(int i){
        List<List<String>> OdapAllA=new ArrayList<List<String>>();
        for(int j=0; j<odapAll.size(); j++) {
            OdapAllA.add(odapAll.get(j));
        }

        for(int j=0; j<odapNAll.size(); j++) {
            OdapAllA.add(odapNAll.get(j));
        }

        List<String> odap = OdapAllA.get(i);
        return odap;
    }

    public List<List<String>> getOdapAllA(){return odapAll;}

    public List<List<String>> getOdapNAllA(){return odapNAll;}

    public int getSize(){return odapAll.size();}

    public int getNSize(){return odapNAll.size();}

}
