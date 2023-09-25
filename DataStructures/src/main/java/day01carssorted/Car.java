package day01carssorted;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author xiaoxingpan
 */
public class Car implements Comparable<Car> {

    static final double FP_THRESHOLD = 0.000000001;

    String makeModel;
    double engineSizeL;
    int prodYear;

    public Car(String makeModel, double engineSizeL, int prodYear) {
        this.makeModel = makeModel;
        this.engineSizeL = engineSizeL;
        this.prodYear = prodYear;
    }

    public Car() {

    }

    public String getMakeModel() {
        return makeModel;
    }

    public double getEngineSizeL() {
        return engineSizeL;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setEngineSizeL(double engineSizeL) {
        this.engineSizeL = engineSizeL;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    @Override
    public String toString() {
        return "Car{" + "makeModel=" + makeModel + ", engineSizeL=" + engineSizeL + ", prodYear=" + prodYear + '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.makeModel.compareTo(o.makeModel);
    }

    public static final CarsSortByProdYear sortByProdYear = new CarsSortByProdYear();

    static class CarsSortByProdYear implements Comparator<Car> {

        @Override
        public int compare(Car o1, Car o2) {
            return o1.prodYear - o2.prodYear;
        } // if they are the same, return 0, if o1.prodYear is higher, return a positive value
    }

    public static final CarsSortByEngineSize sortByEngineSize = new CarsSortByEngineSize();

    static class CarsSortByEngineSize implements Comparator<Car> {

        @Override
        public int compare(Car car1, Car car2) {
            // simplest
//            if (car1.engineSizeL == car2.engineSizeL) {
//                return 0;
//            }
//            return (car1.engineSizeL > car2.engineSizeL) ? 1 : -1;

            // TOLERANCE version 1
//            if (Math.abs(car1.engineSizeL - car2.engineSizeL) < FP_THRESHOLD) return 0;
//            return (car1.engineSizeL > car2.engineSizeL) ? 1 : -1;
//             
            return (int) (1000000 * car1.engineSizeL) - (int) (1000000 * car2.engineSizeL);
        }
    }
}
