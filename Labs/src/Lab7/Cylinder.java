package Lab7;

public class Cylinder extends Circle {

    private double height;

    public Cylinder() {
        this.height = 1.0;
    }

    public Cylinder(double radius, double height) {
        super.setRadius(radius);
        this.height = height;
    }

    public Cylinder(double radius, double hight, String color) {
        super.setColor(color);
        super.setRadius(radius);
        this.height = height;

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBaseArea() {
        return super.getArea();
    }

    public double getArea() {
        return 2 * Math.PI * getRadius() * getHeight() + 2 * getBaseArea();
    }

    public double getVolume() {
        return getBaseArea() * getHeight();
    }

    public String toString() {
        return "Base " + super.toString() + ", height=" + height + ", base area=" + getBaseArea() + 
                "\nSurface area=" + getArea() + ", volume=" + getVolume();
    }

}
