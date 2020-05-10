package com.bl.demo.model;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWkts {

    @CsvBindByName(column = "PLAYER" , required = true)
    public String player;

    @CsvBindByName(column = "Econ" , required = true)
    public float eco;

    @CsvBindByName(column = "Avg", required = true)
    public float avg;

    @CsvBindByName(column = "SR", required = true)
    public float sr;

    @CsvBindByName(column = "4w", required = true)
    public int fourWickets;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWickets;
}
