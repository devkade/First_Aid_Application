package com.example.first_aid.database;


import java.util.ArrayList;
import java.util.List;

public class oxquiz {
    Database quiz;
    List<List<String>> oxq=quiz.readOX("C:\\Users\\Mario76\\Desktop\\ox_quiz.csv");

    public List<List<String>> getOX(){return oxq;}

    public List<List<String>> getoxA(){
        List<List<String>> A = new ArrayList<List<String>>();
        for(int i=0; i<oxq.size(); i++) {
            List<String> line = oxq.get(i);
            if(line.get(0)=="A"){
                A.add(line);
            }
        }
        return A;
    }

    public List<List<String>> getoxB(){
        List<List<String>> B = new ArrayList<List<String>>();
        for(int i=0; i<oxq.size(); i++) {
            List<String> line = oxq.get(i);
            if(line.get(0)=="B"){
                B.add(line);
            }
        }
        return B;
    }

    public List<List<String>> getoxC(){
        List<List<String>> C = new ArrayList<List<String>>();
        for(int i=0; i<oxq.size(); i++) {
            List<String> line = oxq.get(i);
            if(line.get(0)=="C"){
                C.add(line);
            }
        }
        return C;
    }

    public List<List<String>> getoxD(){
        List<List<String>> D = new ArrayList<List<String>>();
        for(int i=0; i<oxq.size(); i++) {
            List<String> line = oxq.get(i);
            if(line.get(0)=="D"){
                D.add(line);
            }
        }
        return D;
    }

    public List<List<String>> getoxE(){
        List<List<String>> E = new ArrayList<List<String>>();
        for(int i=0; i<oxq.size(); i++) {
            List<String> line = oxq.get(i);
            if(line.get(0)=="E"){
                E.add(line);
            }
        }
        return E;
    }

    public List<List<String>> getoxF(){
        List<List<String>> F = new ArrayList<List<String>>();
        for(int i=0; i<oxq.size(); i++) {
            List<String> line = oxq.get(i);
            if(line.get(0)=="F"){
                F.add(line);
            }
        }
        return F;
    }
}
