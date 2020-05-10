package com.bl.demo.main;

import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ICSVBuilder;
import com.bl.demo.dao.cricketDAO;
import com.bl.demo.model.IPLMostRuns;
import com.bl.demo.model.IPLMostWkts;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

public class dataLoader {
    static Comparator<cricketDAO> comparator = null;

    public static <T> ArrayList loadData(String filePath, Class className, String fileName) {
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath));){
            ArrayList<cricketDAO> arr = new ArrayList<>();
            ICSVBuilder builder = CSVBuilderFactory.getBuilder();
            Iterator<T> censusCSVIterator = builder.getCSVFileIterator(reader,className);
            Iterable<T> censusIterable = ()-> censusCSVIterator;
            if (fileName == "IPLMostRuns") {
                StreamSupport.stream(censusIterable.spliterator(), false)
                        .forEach(csvCensus -> arr.add(new cricketDAO((IPLMostRuns) csvCensus)));
            }
            else {
                StreamSupport.stream(censusIterable.spliterator(), false)
                        .forEach(csvCensus -> arr.add(new cricketDAO((IPLMostWkts) csvCensus)));
            }
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String sortedString(ArrayList list, String parameter) {
        switch (parameter) {
            case "Avg" :
                comparator = Comparator.comparing(ipl -> ipl.runAvg);
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
                comparator = Comparator.comparing(ipl -> ipl.sr+ipl.runAvg);
                break;
            case "Runs With Avg" :
                comparator = Comparator.comparing(ipl -> ipl.runs+ipl.runAvg);
                break;
            case "Runs" :
                comparator = Comparator.comparing(ipl -> ipl.runs);
                break;
            case "Eco" :
                comparator = Comparator.comparing(ipl -> ipl.eco);
                break;
            case "SR With Wikets" :
                comparator = Comparator.comparing(ipl -> ipl.sr+ipl.four+ipl.fiveWickets);
                break;
            case "4W" :
                comparator = Comparator.comparing(ipl -> ipl.fourWickets);
                break;
            case "5W" :
                comparator = Comparator.comparing(ipl -> ipl.fiveWickets);
                break;
            case "Wickets With Avg" :
                comparator = Comparator.comparing(ipl -> ipl.wkts);
                break;
            case "Name" :
                comparator = Comparator.comparing(ipl -> ipl.player);
                break;
            case "Batting And Bowling Avg" :
                comparator = Comparator.comparing(ipl -> ipl.bowlAvg+ipl.runAvg);
                break;
            case "Best AllRounder" :
                comparator = Comparator.comparing(ipl -> ipl.runs+ipl.wkts);
                break;
            default:
                System.out.println("Invalid Choice...");
                break;
        }
        sortData.dataSort(comparator, list);
        String sortedString = new Gson().toJson(list);
        return sortedString;
    }

    public static ArrayList getList() throws IOException {
        ArrayList<cricketDAO> list1 = loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv",IPLMostRuns.class,"IPLMostRuns");
        ArrayList<cricketDAO> list2 = loadData("./src/test/resources/IPL2019FactsheetMostWkts.csv",IPLMostWkts.class,"IPLMostWkts");
        ArrayList list = new ArrayList();
        for (int i=0;i<list1.size()-1;i++) {
            for (int j=0;j<list1.size()-1;j++) {
                if (list1.get(i).player.equals(list2.get(j).player)) {
                    list.add( new cricketDAO(list2.get(j),list1.get(i)));
                }
            }
        }
        return list;
    }
}
