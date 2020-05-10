package com.bl.demo;

import com.bl.demo.main.dataLoader;
import com.bl.demo.model.IPLMostRuns;
import com.bl.demo.model.IPLMostWkts;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class IPLTest {

    private final String IPL_MOST_RUNS = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private final String IPL_MOST_WKETS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLBatsmanCSVFile_ReturnsCorrectRecords() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        Assert.assertEquals(100,list.size());
    }

    @Test
    public void givenData_SortPlayerAvgWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"Avg");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("MS Dhoni", iplMostRuns[0].player);
    }

    @Test
    public void givenData_SortPlayerStrikeRateWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"SR");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRuns[0].player);
    }

    @Test
    public void givenData_SortPlayerNumberOfBoundaryHittingWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"Boundary");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("Andre Russell", iplMostRuns[0].player);
    }

    @Test
    public void givenData_SortPlayerNumberOfFourHittingWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"4s");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("Shikhar Dhawan", iplMostRuns[0].player);
    }

    @Test
    public void givenData_SortPlayerNumberOfSixHittingWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"6s");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("Andre Russell", iplMostRuns[0].player);
    }

    @Test
    public void givenData_SortPlayerAvgWithBoundaryWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"Avg With Boundary");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("David Warner", iplMostRuns[0].player);
    }

    @Test
    public void givenData_SortPlayerAvgWithStrikeRateWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"Avg With Strike Rate");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRuns[0].player);
    }

    @Test
    public void givenData_SortPlayerAvgWithStrikeRateWise_DisplayBottomPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"Avg With Strike Rate");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("Bhuvneshwar Kumar", iplMostRuns[list.size()-1].player);
    }

    @Test
    public void givenData_SortPlayerRunsWithAvgWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"Runs With Avg");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("David Warner", iplMostRuns[0].player);
    }

    @Test
    public void givenData_SortPlayerRunsWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_RUNS, IPLMostRuns.class,"IPLMostRuns");
        String sortedList = dataLoader.sortedString(list,"Runs");
        IPLMostRuns[] iplMostRuns =new Gson().fromJson(sortedList, IPLMostRuns[].class);
        Assert.assertEquals("David Warner", iplMostRuns[0].player);
    }

    @Test
    public void givenData_SortPlayerBestBowlingAvgWise_DisplayBottomPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_WKETS, IPLMostWkts.class,"IPLMostWkts");
        String sortedList = dataLoader.sortedString(list,"Avg");
        IPLMostWkts[] iplMostWkts =new Gson().fromJson(sortedList, IPLMostWkts[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWkts[0].player);
    }

    @Test
    public void givenData_SortPlayerBestBowlingAvgWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_WKETS, IPLMostWkts.class,"IPLMostWkts");
        String sortedList = dataLoader.sortedString(list,"Avg");
        IPLMostWkts[] iplMostWkts =new Gson().fromJson(sortedList, IPLMostWkts[].class);
        Assert.assertEquals("Liam Livingstone", iplMostWkts[list.size()-1].player);
    }

    @Test
    public void givenData_SortPlayerBestStrikeRateWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_WKETS, IPLMostWkts.class,"IPLMostWkts");
        String sortedList = dataLoader.sortedString(list,"SR");
        IPLMostWkts[] iplMostWkts =new Gson().fromJson(sortedList, IPLMostWkts[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWkts[0].player);
    }

    @Test
    public void givenData_SortPlayerBestEconomyWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_WKETS, IPLMostWkts.class,"IPLMostWkts");
        String sortedList = dataLoader.sortedString(list,"Eco");
        IPLMostWkts[] iplMostWkts =new Gson().fromJson(sortedList, IPLMostWkts[].class);
        Assert.assertEquals("Shivam Dube", iplMostWkts[list.size()-1].player);
    }

    @Test
    public void givenData_SortPlayerBestEconomyWise_DisplayBottomPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData(IPL_MOST_WKETS, IPLMostWkts.class,"IPLMostWkts");
        String sortedList = dataLoader.sortedString(list,"Eco");
        IPLMostWkts[] iplMostWkts =new Gson().fromJson(sortedList, IPLMostWkts[].class);
        Assert.assertEquals("Ben Cutting", iplMostWkts[0].player);
    }
}
