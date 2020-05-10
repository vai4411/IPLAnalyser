package com.bl.demo.main;

import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ICSVBuilder;
import com.bl.demo.dao.cricketDAO;
import com.bl.demo.model.IPLClass;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class dataLoader {
    static Comparator<cricketDAO> comparator = null;

    public static <T> ArrayList loadData(String filePath, Class className) {
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath));){
            ArrayList<Object> arr = new ArrayList<>();
            ICSVBuilder builder = CSVBuilderFactory.getBuilder();
            Iterator<T> censusCSVIterator = builder.getCSVFileIterator(reader,className);
            Iterable<T> censusIterable = ()-> censusCSVIterator;
            StreamSupport.stream(censusIterable.spliterator(),false)
                    .forEach(csvCensus -> arr.add(new cricketDAO((IPLClass) csvCensus)));
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String sortedString(ArrayList list, String parameter) {
        switch (parameter) {
            case "Avg" :
                comparator = Comparator.comparing(ipl -> ipl.avg);
                break;
            case "SR" :
                comparator = Comparator.comparing(ipl -> ipl.sr);
                break;
            case "Boundary" :
                comparator = Comparator.comparing(ipl -> ipl.four+ipl.six);
                break;
            case "4s" :
                comparator = Comparator.comparing(ipl -> ipl.four);
                break;
            case "6s" :
                comparator = Comparator.comparing(ipl -> ipl.six);
                break;
            case "Avg With Boundary" :
                comparator = Comparator.comparing(ipl -> (ipl.six+ipl.four)/ipl.mat);
                break;
            case "Avg With Strike Rate" :
                comparator = Comparator.comparing(ipl -> ipl.sr+ipl.avg);
                break;
            case "Runs With Avg" :
                comparator = Comparator.comparing(ipl -> ipl.runs+ipl.avg);
                break;
            default:
                System.out.println("Invalid Choice...");
                break;
        }
        sortData.dataSort(comparator, list);
        String sortedString = new Gson().toJson(list);
        return sortedString;
    }
}
