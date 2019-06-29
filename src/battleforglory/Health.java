
package battleforglory;

import javafx.scene.paint.Color;

public class Health {
    private double value;
    private final double width;
    private final double height;
    
    private Color color;
    
    public Health(double value){
        this.value = value;
        this.height = 10.0;
        this.width = 250;
        this.color = Color.rgb(0, 255, 0);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWidth() {
        return width;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
}
