package com.bl.demo.main;

import java.util.ArrayList;
import java.util.Comparator;

public class sortData {
    public static <T>void dataSort(Comparator<T> comparator, ArrayList list) {
        for (int i=0; i< list.size(); i++){
            for (int j=0; j <list.size()-1; j++) {
                T census1 = (T) list.get(j);
                T census2 = (T) list.get(j+1);
                if (comparator.compare(census1, census2) < 0) {
                    list.set(j, census2);
                    list.set(j + 1, census1);
                }
            }
        }
    }
}
