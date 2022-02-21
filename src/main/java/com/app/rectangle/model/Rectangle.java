package com.app.rectangle.model;

public class Rectangle {

    private float xCoordinates;
    private float yCooridnates;
    private float height;
    private float width;

    public Rectangle() {
    }

    public Rectangle(float xCoordinates, float yCooridnates, float height, float width) {
        this.xCoordinates = xCoordinates;
        this.yCooridnates = yCooridnates;
        this.height = height;
        this.width = width;
    }

    public float getxCoordinates() {
        return xCoordinates;
    }

    public void setxCoordinates(float xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    public float getyCooridnates() {
        return yCooridnates;
    }

    public void setyCooridnates(float yCooridnates) {
        this.yCooridnates = yCooridnates;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "xCoordinates=" + xCoordinates +
                ", yCooridnates=" + yCooridnates +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
