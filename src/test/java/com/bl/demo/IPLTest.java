package com.bl.demo;

import com.bl.demo.main.dataLoader;
import com.bl.demo.model.IPLClass;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IPLTest {

    @Test
    public void givenIPLBatsmanCSVFile_ReturnsCorrectRecords() {
        dataLoader loader = new dataLoader();
        List list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        Assert.assertEquals(100,list.size());
    }

    @Test
    public void givenData_SortPlayerAvgWise_DisplayPlayer() {
        dataLoader loader = new dataLoader();
        List list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString((ArrayList) list,"Avg");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("MS Dhoni",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerStrikeRateWise_DisplayPlayer() {
        dataLoader loader = new dataLoader();
        List list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString((ArrayList) list,"SR");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Ishant Sharma",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerNumberOfBoundaryHittingWise_DisplayPlayer() {
        dataLoader loader = new dataLoader();
        List list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString((ArrayList) list,"Boundary");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Andre Russell",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerNumberOfFourHittingWise_DisplayPlayer() {
        dataLoader loader = new dataLoader();
        List list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString((ArrayList) list,"4s");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Shikhar Dhawan",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerNumberOfSixHittingWise_DisplayPlayer() {
        dataLoader loader = new dataLoader();
        List list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString((ArrayList) list,"6s");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("Andre Russell",iplClass[0].player);
    }

    @Test
    public void givenData_SortPlayerAvgWithBoundaryWise_DisplayPlayer() {
        dataLoader loader = new dataLoader();
        List list = loader.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        String sortedList = dataLoader.sortedString((ArrayList) list,"Avg With Boundary");
        IPLClass[] iplClass =new Gson().fromJson(sortedList,IPLClass[].class);
        Assert.assertEquals("David Warner",iplClass[0].player);
    }
}
