package com.meli.localization.util;

public class DistancesUtil {
    private static final double BUENOS_AIRES_LAT = -34.6037;
    private static final double BUENOS_AIRES_LON = -58.3816;

    public static double calculateDistanceswithPoints(double lat1, double lon1, double lat2, double lon2) {
        final int earthRadio = 6371;
        double latDistances = Math.toRadians(lat2 - lat1);
        double lonDistances = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistances / 2) * Math.sin(latDistances / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistances / 2) * Math.sin(lonDistances / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadio * c;
    }

    public static String calculateDistances(double lat, double lon) {
        double distanceMin = Double.MAX_VALUE;
        double distanceMax = Double.MIN_VALUE;

        double[][] coordinates = {{lat, lon}};

        for (double[] coordinate : coordinates) {
            double distanceWithBuenosAires = calculateDistanceswithPoints(BUENOS_AIRES_LAT, BUENOS_AIRES_LON, coordinate[0], coordinate[1]);

            if (distanceWithBuenosAires < distanceMin) {
                distanceMin = distanceWithBuenosAires;
            }

            if (distanceWithBuenosAires > distanceMax) {
                distanceMax = distanceWithBuenosAires;
            }
        }
        return "("+"Distancia minima "+distanceMin+", "+"Distancia maxima "+distanceMax+")";
    }
}
