package ru.vvv.AtomicSubmarine;

public class AtomicSubmarine {
    private class Engine{
        private int power;
        public void powerItUp(){
            System.out.println("Brrrr");
        }
    }

    private Engine engine = new Engine();


    /**
     * Annotate
     * @param i - some annot
     * @return 0 - return value
     */
    public int sale(int i){
        engine.powerItUp();
        System.out.println("Arr");
        return 0;
    }

}
