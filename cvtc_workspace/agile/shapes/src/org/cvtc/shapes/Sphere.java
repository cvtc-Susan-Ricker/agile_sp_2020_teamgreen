package org.cvtc.shapes;
import javax.swing.JOptionPane;

public class Sphere extends Shapes{

    // Sphere radius.
    private float radius = 0.0f;

    // Sphere constructor which accepts one parameter radius as a float.
    public Sphere(float radius) {
        setRadius(radius);
    }

    // Override superclass method, surfaceArea.
    @Override
    // Generate the surface area of a sphere and return it as a float.
    public float surfaceArea() {
        return (float) (4 * Math.PI + Math.pow(radius, 2));
    }

    // Override superclass method, volume.
    @Override
    // Generate the volume of a sphere and return it as a float.
    public float volume() {
        return (float) ( 4 /3 * Math.PI * Math.pow(radius, 3));
    }

    // Override superclass method, render.
    @Override
    // Simple message box, display the sphere's dimensions, surface area, and volume.
    public void render() {
        JOptionPane.showMessageDialog(null,
                "\nRadius: " + this.radius +
                        "\nSurface Area: " + surfaceArea() +
                        "\nVolume" + volume(),
                "Sphere Message Box: ", JOptionPane.PLAIN_MESSAGE);
    }

    // Return sphere radius.
    public float getRadius() {
        return this.radius;
    }

    // Set sphere radius.
    private void setRadius(float radius) {
        if (radius < 0) {
            // check for negative number
            throw new IllegalArgumentException(" Number can not be negative");
        }
        this.radius = radius;
    }

}
