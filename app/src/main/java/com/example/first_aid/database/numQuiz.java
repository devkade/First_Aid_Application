package com.example.first_aid.database;

import java.util.ArrayList;
import java.util.List;

public class numQuiz {
    public List<List<String>> getnumA() {
        List<List<String>> A = new ArrayList<List<String>>();
        List<String> B = new ArrayList<String>();
        B.add("A");
        B.add("7");
        B.add("발작 시 취해야 하는 행동으로 바르지 못한 것은?\n 1. 발작이 시작되면 입을 막거나 무리하게 해서라도 환자의 몸을 바르게 하도록 노력 한다.\n 2. 주변의 위험 물체를 제거하고, 부드러운 천으로 머리 밑을 받쳐준다.\n 3. 구토가 있다면 옆으로 뉘어 입에서 편안히 토사물이 나오도록 돕고 치아에는 아무것도 끼워 넣지 않는다.\n 4. 공공장소에서 발작이 있었다면 환자는 단황 할 수 있으므로 주변사람들이 에워싸지 않도록 한다.\n");
        B.add("1");
        B.add("무리하게 발작을 막으려 하면 오히려 발작이 더 심해질 수 있다. 단, 혀를 깨물지 않도록 하는 것은 괜찮다.");
        A.add(B);
        List<String> C = new ArrayList<String>();
        C.add("A");
        C.add("8");
        C.add("붕대 사용 시 주의 할 점이 아닌 것은?\n 1. 붕대는 풀어지지 않게 단단히 묵는다.\n 2. 붕대 처치 후 자주 혈액순환을 확인해 준다.\n 3. 너무 조여졌으면 느슨하게 해준다.\n 4. 젖은 붕대를 사용해 준다.\n");
        C.add("4");
        C.add("젖은 붕대를 사용할 경우, 마르면서 압박을 심하게 가할 위험이 있다.");
        A.add(C);
        return A;
    }
    public List<List<String>> getnumB() {
        List<List<String>> A = new ArrayList<List<String>>();
        List<String> B = new ArrayList<String>();
        B.add("B");
        B.add("5");
        B.add("심폐소생술 처치방법에서 바르지 않은 것은?\n 1. 가슴 압박 시 팔의 힘으로 압박한다.\n  2. 압박 후 가슴 이완 시 손에 힘을 주지 않는다.\n 3. 압박 시 팔은 수직으로 한다.\n 4. 압박 중에 가슴에서 손이 떨어지면 안 된다. \n");
        B.add("1");
        B.add("가슴 압박 시 체중을 이용해서 압박을 해야 한다.");
        A.add(B);
        List<String> C = new ArrayList<String>();
        C.add("B");
        C.add("6");
        C.add("산소공급이 중단된 환자의 뇌사 현상이 일어나는 평균적인 시간대는?\n 1. 2~3분 \n 2. 4~6분 \n 3. 6~8분 \n 4. 8분 이상\n");
        C.add("2");
        C.add("그러기 때문에 황금시간이 5분이라 불린다. 5분이 경과하기 이전에 최선을 다해서 심폐소생술을 해야 한다.");
        A.add(C);
        return A;
    }
}
