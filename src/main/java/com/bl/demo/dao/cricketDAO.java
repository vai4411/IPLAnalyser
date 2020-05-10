package com.bl.demo.dao;

import com.bl.demo.model.IPLMostRuns;
import com.bl.demo.model.IPLMostWkts;

public class cricketDAO {
public String player;
public float avg;
public float sr;
public int four;
public int six;
public int mat;
public int runs;

public cricketDAO(IPLMostRuns iplMostRuns) {
    player = iplMostRuns.player;
    avg = iplMostRuns.avg;
    sr = iplMostRuns.sr;
    four = iplMostRuns.four;
    six = iplMostRuns.six;
    mat = iplMostRuns.mat;
    runs = iplMostRuns.run;
}

    public cricketDAO(IPLMostWkts iplMostWkts) {
        player = iplMostWkts.player;
        avg = iplMostWkts.avg;
        sr = iplMostWkts.sr;
        runs = iplMostWkts.runs;
    }
}
