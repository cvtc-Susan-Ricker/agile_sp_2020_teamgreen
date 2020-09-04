package org.cvtc.shapes;
import javax.swing.JOptionPane;

public class Cuboid extends Shapes{

    // Cuboid width.
    private float width = 0.0f;

    // Cuboid height.
    private float height = 0.0f;

    // Cuboid depth.
    private float depth = 0.0f;


    // Cuboid constructor accepts the following parameters width, height and depth as floats.
    public Cuboid(float width, float height, float depth) {
        setWidth(width);
        setHeight(height);
        setDepth(depth);
    }

    // Override superclass method for surfaceArea.
    @Override
    // Generate the surface area of a cuboid and return it as a float.
    public float surfaceArea() {
        return (2 * ((this.depth * this.width) + (this.width *this.height) + (this.depth * this.height)));

    }

    // Override superclass method for volume.
    @Override
    // Generate the volume of a cuboid and return it as a float.
    public float volume() {
        return (float) (this.height * this.depth * this.width);
    }

    // Override superclass method for render.
    @Override
    // Simple message box, display the cuboid's dimensions, surface area, and volume.
    public void render() {
        JOptionPane.showMessageDialog(null,
                "\nWidth: " + this.width +
                        "\nHeight: " + this.height +
                        "\nDepth: " + this.depth +
                        "\nSurface area: " + surfaceArea() +
                        "\nVolume: " + volume(),
                "Cuboid Message Box",
                JOptionPane.PLAIN_MESSAGE);
    }

    // Return cuboid width.
    public float getWidth() {
        return this.width;
    }

    // Set cuboid width.
    private void setWidth(float width) {
        if (width < 0 ) {
            // check for negative number
            throw new IllegalArgumentException(" Width can not be negative");
        }
        this.width = width;
    }

    // Return cuboid height.
    public float getHeight() {
        return this.height;
    }

    // Set cuboid height.
    private void setHeight(float height) {
        if(height < 0){
            // check for negative number
            throw new IllegalArgumentException(" Height can not be negative");
        }
        this.height = height;
    }

    // Return cuboid depth.
    public float getDepth() {
        return this.depth;
    }

    // Set cuboid depth.
    private void setDepth(float depth) {
        if (depth < 0){
            // check for negative number
            throw new IllegalArgumentException(" Depth can not be negative");
        }
        this.depth = depth;
    }


}
