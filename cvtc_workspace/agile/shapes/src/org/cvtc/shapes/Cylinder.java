package org.cvtc.shapes;
import javax.swing.JOptionPane;

public class Cylinder extends Shapes{

    // Cylinder radius.
    private float radius = 0.0f;
    // Cylinder height.
    private float height = 0.0f;

    // Cylinder constructor which accepts the following parameters radius and height as floats.
    public Cylinder(float radius, float height) {
        setHeight(height);
        setRadius(radius);
    }

    // Override superclass method for surfaceArea.
    @Override
    // Generate the surface area of a cylinder and return it as a float.
    public float surfaceArea() {
        return (float) ((2 * Math.PI * this.radius * this.height) + (2 * Math.PI * Math.pow(this.radius, 2)));
    }

    // Override superclass method for volume.
    @Override
    // Generate the volume of a cylinder and return it as a float.
    public float volume() {
        return (float) (Math.PI * Math.pow(this.radius, 2) * this.height);
    }

    // Override superclass method for render.
    @Override
    // Simple message box, display the cylinder's dimensions, surface area, and volume.
    public void render() {
        JOptionPane.showMessageDialog(null,
                "\nRadius: " + this.radius +
                        "\nHeight: " + this.height +
                        "\nSurface Area: " + surfaceArea() +
                        "\nVolume: " + volume(),

                "Cylinder Message Box", JOptionPane.PLAIN_MESSAGE);
    }

    // Return cylinder radius.
    public float getRadius() {
        return this.radius;
    }

    // Set cylinder radius.
    private void setRadius(float radius) {
        // check for negative number
        if (radius < 0) {
            throw new IllegalArgumentException(" Number can not be negative");}
        this.radius = radius;
    }

    // Return cylinder height.
    public float getHeight() {
        return this.height;
    }
    // Set cylinder height.
    private void setHeight(float height) {
        // check for negative number
        if (height < 0) {
            throw new IllegalArgumentException(" Number can not be negative");
        }
        this.height = height;
    }
}
