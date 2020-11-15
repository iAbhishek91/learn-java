package javaBasics.composition;

public class Main {
    public static void main(String[] args) {
        Resolution braviaResolution = new Resolution(900, 1200 );
        Monitor bravia = new Monitor("Sony", 400, braviaResolution);

        bravia.setPrice(300d);
        bravia.showFeatures();

        // way to access method of composition class
        // FIRST way - using getters ( possible when there is public getters
        // bravia.getResolution().configureResolution(); // make getters public in Monitor class

        // SECOND way
        bravia.configureResolution();
    }
}
