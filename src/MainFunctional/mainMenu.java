package MainFunctional;

import CollectionOfRequest.*;
import MyUtils.MyUtils;
import java.util.Scanner;

public class mainMenu {
    private static final Request[] asc = {
            new RQFilterDB(),
            new RQShowAllDB()
    };
    public static Scanner scan;

    public static void main (String[] args) {
        scan = new Scanner(System.in);
        TourDataBase.AddTour("Россия", "Москва", tourTransport.bus, 14, 45000, 4, tourFood.ai);
        TourDataBase.AddTour("Америка", "Флорида", tourTransport.ship, 21, 165000, 5, tourFood.no);
        TourDataBase.AddTour("Франция", "Париж", tourTransport.airplane, 14, 75000, 3, tourFood.fb);
        TourDataBase.AddTour("Россия", "Питер", tourTransport.train, 7, 30000, 3, tourFood.fb);
        TourDataBase.AddTour("Китай", "Пекин", tourTransport.train, 21, 90000, 4, tourFood.fb_plus);
        TourDataBase.AddTour("Америка", "Лос-Анджелес", tourTransport.airplane, 28, 150000, 3, tourFood.fb);
        TourDataBase.AddTour("Америка", "Нью-Йорк", tourTransport.airplane, 14, 120000, 4, tourFood.no);
        TourDataBase.AddTour("Китай", "Гуань Чжоу", tourTransport.train, 28, 120000, 5, tourFood.hb_plus);

        firstMenu();
    }

    public static void firstMenu () {
        MyUtils.chooseMenu(getAsc(), "Выбери операцию:");
    }

    public static Request[] getAsc () {
        return asc;
    }
}
