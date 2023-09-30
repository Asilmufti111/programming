
public class Rectangle {

    private double width;
    private double height;

    public Rectangle() {
        this.height = 1;
        this.width = 1;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public String toString() {
        return "width = " + getWidth()
                + "\nHight = " + getHeight()
                + "\nArea = " + getArea()
                + "\nPerimeter = " + getPerimeter() + "\n";

    }
}
