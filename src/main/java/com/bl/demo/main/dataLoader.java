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

    public static String sortedString(ArrayList list) {
        Comparator<cricketDAO> comparator = Comparator.comparing(ipl -> ipl.avg);
        sortData.dataSort(comparator,list);
        String sortedString = new Gson().toJson(list);
        return sortedString;
    }
}