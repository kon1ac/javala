package org.example;

import java.util.Scanner;

public class Main {
    private static final double EARTH_RADIUS = 6371; // Радиус Земли в километрах

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты первой точки (широта, долгота):");
        double lat1 = scanner.nextDouble();
        double lon1 = scanner.nextDouble();

        System.out.println("Введите координаты второй точки (широта, долгота):");
        double lat2 = scanner.nextDouble();
        double lon2 = scanner.nextDouble();

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Расстояние между точками: " + distance + " км");
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Переводим градусы в радианы
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Вычисляем разницу координат
        double dlon = lon2Rad - lon1Rad;
        double dlat = lat2Rad - lat1Rad;

        // Вычисляем расстояние между точками по формуле гаверсинусов
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Умножаем на радиус Земли для получения расстояния в километрах
        double distance = EARTH_RADIUS * c;

        return distance;
    }
}
