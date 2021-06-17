package com.example.javaTask.service;

import com.example.javaTask.data.StringData;

import java.util.ArrayList;
import java.util.List;

public class StringService implements IStringService{
    @Override
    public List<String> findStrings( String keyWord)  {

        List<String> strings = new ArrayList<>();
        StringData stringData =  StringData.getInstance();

        if(!keyWord.isEmpty()){
            for (String elem:stringData.getAll()){
                if(elem.contains(keyWord)) {
                    strings.add(elem);
                }
            }
            if(strings.isEmpty())
                    strings.add("Няма резултат");
        }else {strings = stringData.getAll();}


        return strings;
    }

}
