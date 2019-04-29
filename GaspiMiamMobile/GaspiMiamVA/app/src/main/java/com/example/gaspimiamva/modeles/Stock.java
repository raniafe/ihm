/*package com.example.gaspimiamva.modeles;

import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    public static final String LEGUMES = "one";
    public static final String FRUITS = "two";
    private static List<Pair<String, String>> completeList = new ArrayList<>();


    public static void init() {
        Log.d("PERSON", "init()");
        completeList.clear();
        completeList.add(new Pair(LEGUMES, "courgette"));
        completeList.add(new Pair(FRUITS, "banane"));
        completeList.add(new Pair(LEGUMES, "tomate"));

    }
    public static List<String> getListTwo() {
        List<String> listOne = new ArrayList<>();
        for (Pair child : completeList) {
            if (child.first.equals(FRUITS)) listOne.add((String)(child.second));
        }
        return listOne;
    }
}
*/