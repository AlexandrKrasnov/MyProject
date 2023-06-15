package org.example.lesson4;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(int side) {
        super(side + " is larger than the sum of 2 other side lengths");
    }
}
