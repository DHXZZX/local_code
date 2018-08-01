package com.dhxz.prospring5.ch5;

public class NewGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Just keep me where the light is");
    }

    public void sing2() {
        System.out.println("Just keep me where the light is");
    }

    public void rest() {
        System.out.println("zzz");
    }
}
