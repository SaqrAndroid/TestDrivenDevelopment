package com;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

/**
 * POJO to represent a rectangle
 */
public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * The aspect ratio is a number representing how square or rectangular
     * something is. The closer to 1, the more square.
     * @return aspect ratio
     */
    public double getAspectRatio() {
        return (double)width / height;
    }

    /**
     * @return true if the rectangle is a perfect square
     */
    public boolean isSquare() {
        return width == height;
    }

    /**
     * @return the area of the rectangle
     */
    public int getArea() {
        return width * height;
    }

    /**
     * @return the lengths of the sides as an array
     */
    public int[] getSides() {
        return new int[] { width, height };
    }

    /**
     * @return the lengths of the sides as a list
     */
    public List<Integer> getSidesList() {
        return asList(width, height);
    }

    // generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width &&
                height == rectangle.height;
    }

    // generated
    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
