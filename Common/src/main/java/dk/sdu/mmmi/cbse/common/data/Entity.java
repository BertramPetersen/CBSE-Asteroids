package dk.sdu.mmmi.cbse.common.data;

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();
    
    private double[] polygonCoordinates;
    private double x;
    private double y;
    private double rotation;
    private double height;
    private double width;
    private double radius;
            

    public String getID() {
        return ID.toString();
    }


    public void setPolygonCoordinates(double... coordinates ) {
        // Calculate height and width from coordinates
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        for (int i = 0; i < coordinates.length; i+=2) {
            if (coordinates[i] > maxX) {
                maxX = coordinates[i];
            }
            if (coordinates[i] < minX) {
                minX = coordinates[i];
            }
            if (coordinates[i+1] > maxY) {
                maxY = coordinates[i+1];
            }
            if (coordinates[i+1] < minY) {
                minY = coordinates[i+1];
            }
        }
        this.height = maxY - minY;
        this.width = maxX - minX;
        this.polygonCoordinates = coordinates;
    }

    public double[] getPolygonCoordinates() {return polygonCoordinates;}
       

    public void setX(double x) {
        this.x =x;
    }

    public double getX() {
        return x;
    }

    
    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


}
