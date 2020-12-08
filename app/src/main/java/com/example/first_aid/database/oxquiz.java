package com.example.first_aid.database;


import java.util.ArrayList;
import java.util.List;

public class oxquiz {
    Database quiz;
    List<List<String>> oxq=quiz.readOX("C:\\Users\\Mario76\\Desktop\\ox_quiz.csv");

    public List<List<String>> getOX(){return oxq;}

    public List<List<String>> getoxA(){
        List<List<String>> A = new ArrayList<List<String>>();
        List<String> B = new ArrayList<String>();
        B.add("A");
        B.add("1");
        B.add("경련 환자가 발생했을 때, 환자를 잡아서 안정을 취하게 해야 한다.O/X");
        B.add("X");
        B.add("경련하는 동안 환자의 손상을 막아야 하지만 환자를 잡아서는 안 된다.");
        A.add(B);
        List<String> C = new ArrayList<String>();
        C.add("A");
        C.add("2");
        C.add("사람을 두 명이서 운반할 때 환자의 발을 앞쪽으로 하여 운반해야 한다. O/X");
        C.add("O");
        C.add("적절치 못한 운반은 환자의 상태를 악화시킬 수 있다.");
        A.add(C);
        List<String> D = new ArrayList<String>();
        D.add("A");
        D.add("3");
        D.add("의식이 없는 환자에게 약을 먹일 때에는 입에 바로 약을 넣어준다. O/X");
        D.add("X");
        D.add("목에 걸릴 위험이 있으므로 혀 밑에 넣어준다.");
        A.add(D);
        List<String> E = new ArrayList<String>();
        E.add("A");
        E.add("4");
        E.add("골절에 대한 응급처치가 이루어진 환자는 보온에 따른 응급처치를 할 필요는 없다. O/X");
        E.add("X");
        E.add("응급상황은 복합적으로 나타날 수 있다. 상황에 따른 응급처치를 다 해야 한다.");
        A.add(E);
        List<String> F = new ArrayList<String>();
        F.add("A");
        F.add("5");
        F.add("의식이 있는 환자에 대해서는 응급처치에 대해 동의를 받아야만 한다. O/X");
        F.add("O");
        F.add("동의 없이 신체를 접촉하는 행위는 위법이며 어떤 경우 폭행으로 간주될 수 있다.");
        A.add(F);
        List<String> G = new ArrayList<String>();
        G.add("A");
        G.add("6");
        G.add("의식이 없는 환자에 대해서는 응급처치에 대해 동의를 받을 필요가 없다. O/X");
        G.add("O");
        G.add("묵시적 동의로 간주되어 응급처치를 진행할 수 있다.");
        A.add(G);
        return A;
    }

    public List<List<String>> getoxB(){
        List<List<String>> B = new ArrayList<List<String>>();
        List<String> C = new ArrayList<String>();
        C.add("B");
        C.add("1");
        C.add("영아(아기)에게 심폐소생술을 할 때 깍지를 끼고 흉부압박을 해야 한다. O/X");
        C.add("X");
        C.add("상당히 큰 부상이 발생할 수도 있다. 중약지를 가지고 압박해주어야 한다.");
        B.add(C);
        List<String> D = new ArrayList<String>();
        D.add("B");
        D.add("2");
        D.add("영아(아기)가 목이 막힌 상황일 때(기도폐쇄) 등을 두드려야 한다. O/X");
        D.add("O");
        D.add("영아 기도폐쇄 상황에서 적합한 방법 중 하나이다.");
        B.add(D);
        List<String> E = new ArrayList<String>();
        E.add("B");
        E.add("3");
        E.add("임산부나 복부비만 기도폐쇄시의 응급처치 방법은 다른 사람들과는 달리 가슴을 밀어내는(혹은 가슴압박) 방법을 써야 한다. O/X\n");
        E.add("O");
        E.add("단 일반인의 경우 복부 밀어내기법(일반적으로 아는 하임리히법)을 사용한다.");
        B.add(E);
        List<String> F = new ArrayList<String>();
        F.add("B");
        F.add("4");
        F.add("기도 폐쇄로 의식을 잃은 경우 인공호흡을 해야 한다. O/X");
        F.add("O");
        F.add("의식을 잃은 경우 인공호흡과 하임리히법을 번갈아 가면서 해야 한다.");
        B.add(F);

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
