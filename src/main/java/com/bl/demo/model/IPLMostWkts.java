package com.bl.demo.model;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWkts {

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Econ")
    public float eco;

    @CsvBindByName(column = "Avg", required = true)
    public float avg;

    @CsvBindByName(column = "SR", required = true)
    public float sr;
}
