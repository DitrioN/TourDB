package MainFunctional;

public class TourDataBase {
    private static Tour[] tour = new Tour[0];
    public static void AddTour(String country, String city, tourTransport transport, int days,
                        double price, int rating, tourFood food) {
        Tour[] bufferArr = new Tour[tour.length + 1];
        for (int i = 0; i < tour.length; i++)
            bufferArr[i] = tour[i];

        bufferArr[tour.length] = new Tour(country, city, transport, days, price, rating, food);
        tour = bufferArr;
    }
    public static void DelTour(int numberTour) {
        Tour[] bufferArr = new Tour[tour.length - 1];
        for (int i = 0, j = 0; i < tour.length; i++) {
            if (numberTour != i) {
                bufferArr[j] = tour[i];
                j++;
            }
        }

        tour = bufferArr;
    }
    public static void RedTour(int numberTour, String country, String city, tourTransport transport,
                        int days, double price, int rating, tourFood food) {
        tour[numberTour] = new Tour(country, city, transport, days, price, rating, food);
    }
    public static Tour[] getTour () {
        return tour;
    }
}
