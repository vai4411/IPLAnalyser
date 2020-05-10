package com.bl.demo.dao;

import com.bl.demo.model.IPLClass;

public class cricketDAO {
public String player;
public float avg;
public float sr;
public int four;
public int six;

public cricketDAO(IPLClass iplClass) {
    player = iplClass.player;
    avg = iplClass.avg;
    sr = iplClass.sr;
    four = iplClass.four;
    six = iplClass.six;
}
}
