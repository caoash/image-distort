import java.awt.*;
import java.io.*;
import java.util.*;

/*
Solution Sketch:
*/

public class Heatmap {
//    public static void main(String[] args){
//        ArrayList<Point> poly = new ArrayList<>();
//        poly.add(new Point(1,3)); poly.add(new Point(2,2));
//        Heatmap h = new Heatmap(poly, 10, 10);
//        h.init();
////        for(int i = 0; i < 10; i++){
////            for(int j = 0; j < 10; j++){
////                System.out.println(i + " " + j);
////                System.out.println(h.mvc(new Point(i,j), 0));
//            }
//        }
//    }
    ArrayList<Point> polygon;
    int xDimension, yDimension;
    double[][][] weight;
    double[][][] u;

    public class Coordinate {
        int xPos, yPos, weight;

        public Coordinate(int xPos, int yPos, int weight) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.weight = weight;
        }
    }

    public Heatmap(ArrayList<Point> polygon2, int xDimension, int yDimension) {
        polygon = new ArrayList<>();
        for (Point p : polygon2) {
            polygon.add(p);
        }
        this.xDimension = xDimension;
        this.yDimension = yDimension;
    }

    public void init(){
        u = new double[xDimension+1][yDimension+1][polygon.size()+1];
        weight = new double[xDimension + 1][yDimension + 1][polygon.size()+1];
        for(int i = 0; i < xDimension; i++){
            for(int j = 0; j < yDimension; j++){
                for(int k = 0; k < polygon.size(); k++) {
                    u[i][j][k] = mvc(new Point(i, j), k);
                }
            }
        }
        for(int i = 0; i < xDimension; i++){
            for(int j = 0; j < yDimension; j++){
                double sum = 0;
                for(int k = 0; k < polygon.size(); k++){
                    sum += u[i][j][k];
                }
                for(int k = 0; k < polygon.size(); k++){
                    weight[i][j][k] = u[i][j][k] / sum;
                }
            }
        }
    }
    public double[][] getWeight(int ind){
        double[][] ret = new double[xDimension+1][yDimension+1];
        for(int i = 0; i < xDimension; i++){
            for(int j = 0; j < yDimension; j++){
                ret[i][j] = weight[i][j][ind];
            }
        }
        return ret;
    }
    public double mvc(Point p, int i) {
        Point curr = polygon.get(i);
        Point prev;
        Point next;
            if (i == 0) {
                next = polygon.get(i + 1);
                prev = polygon.get(polygon.size() - 1);
            } else if (i == polygon.size() - 1) {
                next = polygon.get(0);
                prev = polygon.get(i - 1);
            } else {
                next = polygon.get(i + 1);
                prev = polygon.get(i - 1);
            }
//            System.out.println(p + " " + curr + " " + prev + " " + next);
            Point v1 = subtract(prev, p);
            double a1 = area(p, curr, next);
            Point v2 = subtract(next, p);
        double a2 = area(p, prev, curr);
            Point v3 = subtract(curr, p);
        double a3 = area(p, prev, next);
        double a4 = area(p, prev, curr);
        double a5 = area(p, curr, next);
//        System.out.println(length(v1) + " " + a1 + " " + length(v2) + " " + a2 + " " + length(v3) + " " + a3 + " " + a4 + " " + a5);
            double weight = ((length(v1) * a1 + length(v2) * a2 - length(v3) * a3) / (a4 * a5));
            return weight;
    }

    public double length(Point p){
        return Math.round(Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y,2)) * 1000d)/1000d;
    }

    public Point subtract(Point a, Point b) {
        return new Point(a.x - b.x, a.y - b.y);
    }


    public Point computeDeform(Point q, ArrayList<Point> newPolygon){
        DoublePoint qNew = new DoublePoint(0,0);
        for(int i = 0; i < newPolygon.size(); i++){
            double currWeight = weight[q.x][q.y][i];
             DoublePoint addition = new DoublePoint(newPolygon.get(i).x * currWeight, (newPolygon.get(i).y * currWeight));
             qNew = add(qNew, addition);
        }
        if(qNew.x < 0 || qNew.y < 0 || qNew.x >= xDimension || qNew.y >= yDimension){
            return new Point(-1,-1);
        }
        return new Point((int)Math.floor(qNew.x), (int)Math.floor(qNew.y));
//        DoublePoint qNew = new DoublePoint(0,0);
//        for(int i = 0; i < Math.min(newPolygon.size(), polygon.size()); i++){
//            double[][] w = getWeight(i);
//            DoublePoint addition = new DoublePoint(newPolygon.get(i).x * w[q.x][q.y], (newPolygon.get(i).y * w[q.x][q.y]));
//            qNew = add(qNew, addition);
//        }
//        qNew = new DoublePoint((int)Math.floor(qNew.x), (int)Math.floor(qNew.y));
//        if(qNew.x <= 0 || qNew.y <= 0 || qNew.x >= xDimension || qNew.y >= yDimension){
//            return q;
//        }
//        return new Point((int)Math.floor(qNew.x), (int)Math.floor(qNew.y));
    }
    public class DoublePoint{
        double x,y;
        public DoublePoint(double x, double y){
            this.x = x; this.y = y;
        }
    }
    public DoublePoint add(DoublePoint p, DoublePoint q){
        return new DoublePoint(p.x+q.x, p.y+q.y);
    }
    public double area(Point a, Point b, Point c){
        return Math.round((((a.x - c.x) * (b.y - a.y) - (a.x-b.x)* (c.y - a.y))/2) * (1000d))/1000d;
    }
}
