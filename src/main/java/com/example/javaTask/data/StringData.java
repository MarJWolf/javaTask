package com.example.javaTask.data;
import java.util.ArrayList;
import java.util.List;

public class StringData implements java.io.Serializable{
    private ArrayList<String> AllS = new ArrayList<>();

    private static StringData instance = new StringData();

    private StringData(){}

    public static StringData getInstance(){
        return instance;
    }

    public List<String> getAll() {
        return AllS;
    }

    public void Add(String u) { AllS.add(u); }

    public void Del(String u) {
        if(AllS.contains(u)){
            for(int i = 0; i < AllS.size(); i++)
            {
                if(AllS.get(i).equals(u)){
                    AllS.remove(i);
                }
            }
        }
    }
}
