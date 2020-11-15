package javaBasics.composition;

public class Resolution {
    private int height;
    private int width;

    public Resolution(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    // this method shows, how to access methods of composition class
    public void configureResolution() {
        System.out.println("Configuring resolution");
    }
}
