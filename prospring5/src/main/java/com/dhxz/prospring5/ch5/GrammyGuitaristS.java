package com.dhxz.prospring5.ch5;

public class GrammyGuitaristS implements Singer {
    @Override
    public void sing() {
        System.out.println("sing: Gravity is working against me\n" +
                "And gravity wants to bring me down");
    }
    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }
    public void rest(){
        System.out.println("zzz");
    }
    public void talk(){
        System.out.println("talk");
    }
}