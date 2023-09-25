package day01carssorted;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Day01CarsSorted {

    static ArrayList<Car> parking = new ArrayList<>();

    public static void main(String[] args) {
        // we will not get zero because 0.1 is a approximation of 0.1
        double x = 1.0;
        for (int i = 0; i < 10; i++) {
            x -= 0.1;
        }
        System.out.println("x = " + x);
        if (x == 0) {
            System.out.println("Zero");
        }

        readDataFromFile();
        System.out.println("--------Parking");
        for (Car car : parking) {
            System.out.println(car);
        }

        System.out.println("--------Natural sort by model using Comparable");
        // Sort cars by makeModel using Comparable<Car> interaface
        Collections.sort(parking);
        for (Car car : parking) {
            System.out.println(car);
        }

        System.out.println("--------Sort cars by prodYear using Comparator");
        // Sort cars by prodYear using Comparator
        Collections.sort(parking, Car.sortByProdYear);
        for (Car car : parking) {
            System.out.println(car);
        }

        System.out.println("--------Sort cars by prodYear using Lambda");
        // lambda is a method that doesn't has a name but can take parametres and returns a value
        parking.sort((Car c1, Car c2) -> {
            System.out.println("Calling Dr. Lambda!");
            return c2.prodYear - c1.prodYear;
        });
        // short notation, one expression
        parking.sort((Car c1, Car c2) -> c2.prodYear - c1.prodYear);
        for (Car car : parking) {
            System.out.println(car);
        }

        // Sort cars by prodYear then makeModel using lamba or Comparator::CONSTANTS and if prodYear is the same then by makeModel
        Comparator<Car> customComparator = Comparator.comparing(Car::getProdYear).thenComparing(Car::getMakeModel);
        for (Car car : parking) {
            System.out.println(car);
        }
    }

    static void readDataFromFile() {
        // add data by reading a file
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/src/day01carssorted/" + "cars.txt";
        File file = new File(path);

        try (Scanner inputFile = new Scanner(file)) {
            while (inputFile.hasNextLine()) {
                try {
                    String[] splitContent = inputFile.nextLine().split(";");
                    if (splitContent.length != 3) {
                        System.err.println("Error in line, skipping. ");
                        continue;
                    }
                    Car car = new Car();
                    car.setMakeModel(splitContent[0]);
                    car.setEngineSizeL(Double.parseDouble(splitContent[1]));
                    car.setProdYear(Integer.parseInt(splitContent[2]));
                    parking.add(car);
                } catch (NumberFormatException ex) {
                    System.out.println("Error in line, skipping, " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Fatal error: unable to read file, " + ex.getMessage());
        }
    }
}
