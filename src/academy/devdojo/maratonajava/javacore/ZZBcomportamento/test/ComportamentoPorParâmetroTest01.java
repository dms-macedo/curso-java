package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParâmetroTest01 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red" , 2019));

    public static void main(String[] args) {
        System.out.println(filterGreenCars(cars));
        System.out.println(filterRedCars(cars));
        System.out.println(filterCars(cars, "black"));
        System.out.println("-----------------------------");
        System.out.println(filterCarsByYearBefore(cars, 2015));
    }

    private static List<Car> filterGreenCars(List<Car> cars){
        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getColor().equals("green")){
                filteredCars.add(car);
            }
        }

        return filteredCars;
    }

    private static List<Car> filterRedCars(List<Car> cars){
        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getColor().equals("red")){
                filteredCars.add(car);
            }
        }

        return filteredCars;
    }

    private static List<Car> filterCars(List<Car> cars, String cor){
        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getColor().equals(cor)){
                filteredCars.add(car);
            }
        }

        return filteredCars;
    }

    private static List<Car> filterCarsByYearBefore(List<Car> cars, int age){
        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getYear() < age){
                filteredCars.add(car);
            }
        }

        return filteredCars;
    }
}
