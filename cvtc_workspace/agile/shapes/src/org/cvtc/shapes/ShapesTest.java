package org.cvtc.shapes;



public class ShapesTest {
    // Test the cylinder, sphere, and cuboid classes by calling each of their constructors and render functions.
    public static void main(String[] args) {

        // Generate a Cuboid object.
        Cuboid cuboid = new Cuboid(5, 10, 15);

        // Generate a Cuboid cylinder.
        Cylinder cylinder = new Cylinder(5, 10);

        // Generate a sphere object.
        Sphere sphere = new Sphere(5);

        // Generate message box to display the cuboid's dimensions, surface area, and volume.
        cuboid.render();
        // Generate message box to display the cylinder's dimensions, surface area, and volume.
        cylinder.render();
        // Generate message box to display the sphere's dimensions, surface area, and volume.
        sphere.render();
    }


}
