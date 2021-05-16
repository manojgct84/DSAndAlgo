package com.ariba.sap.test.leecode.March;


/**
 * Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform random point in the circle.
 * <p>
 * Note:
 * <p>
 * input and output values are in floating-point.
 * radius and x-y position of the center of the circle is passed into the class constructor.
 * a point on the circumference of the circle is considered to be in the circle.
 * randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
 * Example 1:
 * <p>
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1,0,0],[],[],[]]
 * Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 * Example 2:
 * <p>
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[10,5,-7.5],[],[],[]]
 * Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has three arguments, the radius, x-position of the center, and y-position of the center of the circle. randPoint has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */

public class GenerateRandomPointCircle {

    double r, x, y;

    public GenerateRandomPointCircle(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * r;
        double deg = Math.random() * 2 * Math.PI;
        double x_curr = x + len * Math.cos(deg);
        double y_curr = y + len * Math.sin(deg);
        return new double[]{x, y};

       /*   Random rand = new Random();
        Double nx = x - r + rand.nextDouble() * 2 * r;
        double ny = y - r + rand.nextDouble() * 2 * r;
        double r2 = r * r;
        while(dis(nx, ny) >= r2){
            nx = x - r + rand.nextDouble() * 2 * r;
            ny = y - r + rand.nextDouble() * 2 * r;
        }
        return new double[]{nx, ny};*/

    }

    // it returns the square of the distance between the point and the center;
    double dis(double nx, double ny) {
        return (nx - x) * (nx - x) + (ny - y) * (ny - y);
    }
}
