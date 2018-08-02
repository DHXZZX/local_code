package com.dhxz.prospring5.ch5;

public class NewDocumentarist extends Documentarist{
    @Override
    public void execute() {
        guitaristS.sing();
        guitaristS.sing(new Guitar());
        guitaristS.talk();
    }
}
