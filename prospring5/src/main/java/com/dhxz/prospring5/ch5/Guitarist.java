package com.dhxz.prospring5.ch5;

public class Guitarist implements Singer {

    private String lyric = "You're gonna live foreve in me";
    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
