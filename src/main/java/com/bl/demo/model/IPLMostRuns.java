package com.bl.demo.model;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRuns {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat" , required = true)
    public int mat;

    @CsvBindByName(column = "Avg", required = true)
    public float runAvg;

    @CsvBindByName(column = "SR", required = true)
    public float sr;

    @CsvBindByName(column = "4s", required = true)
    public int four;

    @CsvBindByName(column = "6s", required = true)
    public int six;

    @CsvBindByName(column = "Runs", required = true)
    public int run;
}
