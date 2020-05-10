package com.bl.demo.dao;

import com.bl.demo.model.IPLMostRuns;
import com.bl.demo.model.IPLMostWkts;

public class cricketDAO {
public String player;
public float runAvg;
public float bowlAvg;
public float sr;
public int four;
public int six;
public int mat;
public int runs;
public float eco;
public int fiveWickets;
public int fourWickets;
public int wkts;

    public cricketDAO(IPLMostRuns iplMostRuns) {
        player = iplMostRuns.player;
        runAvg = iplMostRuns.runAvg;
        sr = iplMostRuns.sr;
        four = iplMostRuns.four;
        six = iplMostRuns.six;
        mat = iplMostRuns.mat;
        runs = iplMostRuns.run;
    }

    public cricketDAO(IPLMostWkts iplMostWkts) {
        player = iplMostWkts.player;
        bowlAvg = iplMostWkts.bowlAvg;
        sr = iplMostWkts.sr;
        eco = iplMostWkts.eco;
        fiveWickets = iplMostWkts.fiveWickets;
        fourWickets = iplMostWkts.fourWickets;
        wkts = iplMostWkts.wkts;
        mat = iplMostWkts.mat;
    }
    public cricketDAO(cricketDAO iplMostWkts, cricketDAO iplMostRuns) {
        player = iplMostRuns.player;
        runs = iplMostRuns.runs;
        runAvg = iplMostRuns.runAvg;
        sr = iplMostRuns.sr;
        four = iplMostRuns.four;
        six = iplMostRuns.six;
        mat = iplMostRuns.mat;
        player = iplMostWkts.player;
        bowlAvg = iplMostWkts.bowlAvg;
        sr = iplMostWkts.sr;
        eco = iplMostWkts.eco;
        fiveWickets = iplMostWkts.fiveWickets;
        fourWickets = iplMostWkts.fourWickets;
        wkts = iplMostWkts.wkts;
        mat = iplMostWkts.mat;
    }
}
