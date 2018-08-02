package com.dhxz.prospring5.ch5;

public class Documentarist {
    protected GrammyGuitaristS guitaristS;

    public void execute() {
        guitaristS.sing();
        guitaristS.talk();
    }

    public void setDep(GrammyGuitaristS guitaristS) {
        this.guitaristS = guitaristS;
    }
}
