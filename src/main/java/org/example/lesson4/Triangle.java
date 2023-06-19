package org.example.lesson4;

class Triangle {
    private final int a, b, c;

    public Triangle(int a, int b, int c) throws IllegalTriangleException {
        if (a >= b + c)
            throw new IllegalTriangleException(a);
        else if (b >= a + c)
            throw new IllegalTriangleException(b);
        else if (c >= a + b)
            throw new IllegalTriangleException(c);
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public double area() {
        double halfPerimeter = (this.a + this.b + this.c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - this.a) * (halfPerimeter - this.b) * (halfPerimeter - this.c));
    }
}
