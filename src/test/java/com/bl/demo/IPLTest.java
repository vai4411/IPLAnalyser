package com.bl.demo;

import com.bl.demo.main.dataLoader;
import com.bl.demo.model.IPLClass;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class IPLTest {

    @Test
    public void givenIPLBatsmanCSVFile_ReturnsCorrectRecords() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        Assert.assertEquals(100,list.size());
    }

    @Test
    public void givenData_SortPlayerAvgWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString(list,"Avg");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("MS Dhoni",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerStrikeRateWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString(list,"SR");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Ishant Sharma",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerNumberOfBoundaryHittingWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString(list,"Boundary");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Andre Russell",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerNumberOfFourHittingWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString(list,"4s");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Shikhar Dhawan",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerNumberOfSixHittingWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString(list,"6s");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Andre Russell",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerAvgWithBoundaryWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString(list,"Avg With Boundary");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("David Warner",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerAvgWithStrikeRateWise_DisplayTopPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString(list,"Avg With Strike Rate");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Ishant Sharma",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerAvgWithStrikeRateWise_DisplayBottomPlayer() {
        dataLoader loader = new dataLoader();
        ArrayList list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString(list,"Avg With Strike Rate");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Bhuvneshwar Kumar",iplClass[list.size()-1].player);
    }
}
