package com.isa.jjdzr;
import java.util.Scanner;

public class SearchFields {
    public String Name() {
        System.out.println("Podaj nazwe ośrodka:");
        Scanner scanner = new Scanner(System.in);
        String name;
        try {
            name = scanner.next();
        } catch (Exception ignored) {
            System.out.println("Podano niepoprawna nazwę");
            return Name();
        }
        return name;
    }

    public String Region() {
        System.out.println("Podaj region jaki Cie interesuje:");
        Scanner scanner = new Scanner(System.in);
        String region;
        try {
            region = scanner.next();
        } catch (Exception ignored){
            System.out.println("Podano niepoprawną nazwę");
            return Region();
        }
        return region;
    }

    public Double Radius() {
        System.out.println("Podaj w jakiej odległości max wyszukiwać:");
            Scanner scanner = new Scanner(System.in);
            double radius;
            try {
                radius = scanner.nextInt();
        } catch (Exception ignored) {
            System.out.println("Podaj wartość liczbową");
            return Radius();
        }
        return radius;
    }

    public Double Latitude() {
        System.out.println("Podaj szerokość geograficzną:");
        Scanner scanner = new Scanner(System.in);
        double userLatitude;
        try {
            userLatitude = scanner.nextInt();
        } catch (Exception ignored) {
            System.out.println("Podaj wartość liczbową");
            return Latitude();
        }
        return userLatitude;
    }

    public Double Longitude() {
        System.out.println("Podaj długość geograficzną:");
        Scanner scanner = new Scanner(System.in);
        double userLongitude;
        try {
            userLongitude = scanner.nextInt();
        } catch (Exception ignored) {
            System.out.println("Podaj wartość liczbową");
            return Longitude();
        }
        return userLongitude;
    }


}
