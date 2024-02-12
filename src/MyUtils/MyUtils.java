package MyUtils;

import CollectionOfRequest.RQFilterDB;
import MainFunctional.*;

public class MyUtils {
    public static void chooseMenu (Request[] request, String text) {
        StringBuilder str1 = new StringBuilder("\n\u001B[0m...- ").append(text);
        for (int f1 = 0; f1 < request.length; f1++) {
            str1.append("\n   ").append(f1 + 1).append(". ");
            str1.append(request[f1].getName(0));
            str1.append((f1 + 1 < request.length) ? "," : ".");
        }

        System.out.println(str1);

        System.out.print("\n\u001B[32mВы - ");
        String myInput = mainMenu.scan.nextLine();
        boolean error = true;

        for (int f1 = 0; f1 < request.length; f1++) {
            for (String f2 : request[f1].getName()) {
                if (myInput.equalsIgnoreCase(f2) || myInput.equals(f1 + 1 + "")) {
                    request[f1].callMenu();
                    error = false;
                    break;
                }
            }
        }

        if (error) {
            StringBuilder str2 = new StringBuilder("\n\u001B[0m...- ");
            System.out.println(str2.append("Эм... Повтори-ка, я не понял."));
            mainMenu.firstMenu();

            /*switch (myInput.toLowerCase()) {
                case "выход":
                    System.out.println(str.append("В окно что-ли? Ну да ладно, пока."));
                    break;
                case "пока":
                    System.out.println(str.append("Пока!"));
                    break;
                case "назад":
                    if (mainMenu.menu == menuLocation.main_menu) {
                        System.out.println(str.append("Так ты же уже в главном меню!"));
                        mainMenu.firstMenu();
                    } else {
                        System.out.println(str.append("Выхожу в главное меню..."));
                        mainMenu.firstMenu();
                    }
                    break;
                default:
                    System.out.println(str.append("Эм... Повтори-ка, я не понял."));
                    mainMenu.firstMenu();
            }*/
        }
    }
    public boolean checkInt(int i, String[] s) {
        boolean result = true;
        for (int f1 = 0; f1 < s.length; f1++) {
            try {
                Integer.parseInt(s[f1]);
            } catch (NumberFormatException e) {
                result = false;
                break;
            }
        }
        return result && (i == s.length);
    }
    public static String trans (tourTransport transport) {
        switch (transport) {
            case bus:
                return "Автобус";
            case ship:
                return "Корабль";
            case airplane:
                return "Самолёт";
            case train:
                return "Поезд";
            default:
                return "";
        }
    }
    public static String trans (tourFood food) {
        switch (food) {
            case no:
                return "Без питания";
            case bb:
                return "Завтрак";
            case hb:
                return "Полупансион";
            case fb:
                return "Полный пансион";
            case hb_plus:
                return "Полупансион с напитками";
            case fb_plus:
                return "Полный пансион с напитками";
            case ai:
                return "Всё включено";
            case uai:
                return "Ультра всё включено";
            default:
                return "";
        }
    }
    public static String drawMainStroke (tourIndex index, Tour[] tour, String[] buf) {
        StringBuilder str = new StringBuilder();

        str.append("\u001B[37m").append(MyUtils.nameColomn()[0]).append("\u001B[0m");
        str.append((" ").repeat(buf[0].length() - MyUtils.nameColomn()[0].length())).append(" | ");

        for (int f1 = 0; f1 < RQFilterDB.getColumn().length; f1++) {
            boolean tru = (RQFilterDB.getColumn(f1).getIndex() == index);
            str.append(tru ? "" : "\u001B[37m").append(RQFilterDB.getColumn(f1).getName(0));
            str.append(" ".repeat(buf[f1 + 1].length() - RQFilterDB.getColumn(f1).getName(0).length()));
            str.append(tru ? " | " : "\u001B[0m | ");
        }

        str.append("\n");

        for (int f1 = 0; f1 < tour.length; f1++) {
            str.append(MyUtils.drawTourStroke(f1, tour[f1], buf));
            if (f1 + 1 < tour.length)
                str.append("\n");
        }

        return str.toString();
    }
    public static String drawTourStroke (int i, Tour tour, String[] buf) {
        StringBuilder str = new StringBuilder();

        str.append("\u001B[37m").append((i + 1)).append("\u001B[0m");
        str.append(printSpace(buf[0], String.valueOf(i + 1))).append(" . ");

        str.append(tour.getTextData(tourIndex.country));
        str.append(printSpace(buf[1], tour.getTextData(tourIndex.country))).append(" - ");

        str.append(tour.getTextData(tourIndex.city));
        str.append(printSpace(buf[2], tour.getTextData(tourIndex.city))).append(" : ");

        str.append("\u001B[35m").append(tour.getTextData(tourIndex.transport));
        str.append(printSpace(buf[3], tour.getTextData(tourIndex.transport)));
        str.append("\u001B[0m - ");

        str.append(textDay(tour.getTextData(tourIndex.days)));
        str.append(printSpace(buf[4], textDay(tour.getTextData(tourIndex.days)))).append(" - ");

        str.append("\u001B[32m").append(tour.getTextData(tourIndex.price)).append("\u001B[0m руб.");
        str.append(printSpace(buf[5], tour.getTextData(tourIndex.price) + " руб.")).append(" - ");

        int r = Integer.parseInt(tour.getTextData(tourIndex.rating));
        str.append("\u001B[33m").append("*".repeat(r));
        str.append("\u001B[30m").append("*".repeat(5 - r));
        str.append(printSpace(buf[6], "*****")).append("\u001B[0m - ");

        str.append("\u001B[35m").append(tour.getTextData(tourIndex.food));
        str.append(printSpace(buf[7], tour.getTextData(tourIndex.food))).append("\u001B[0m |");

        return str.toString();
    }
    private static String printSpace (String str1, String str2) {
        return " ".repeat(str1.length() - str2.length());
    }
    public static String[] compareArr (int i, String[] buf) {
        Tour tour = TourDataBase.getTour()[i];

        if (String.valueOf(i).length() > buf[0].length())
            buf[0] = String.valueOf(i);

        if (tour.getTextData(tourIndex.country).length() > buf[1].length())
            buf[1] = tour.getTextData(tourIndex.country);

        if (tour.getTextData(tourIndex.city).length() > buf[2].length())
            buf[2] = tour.getTextData(tourIndex.city);

        if (tour.getTextData(tourIndex.transport).length() > buf[3].length())
            buf[3] = tour.getTextData(tourIndex.transport);

        if ((textDay(tour.getTextData(tourIndex.days))).length() > buf[4].length())
            buf[4] = textDay(tour.getTextData(tourIndex.days));

        if ((tour.getTextData(tourIndex.price) + " руб.").length() > buf[5].length())
            buf[5] = tour.getTextData(tourIndex.price) + " руб.";

        if ("*****".length() > buf[6].length())
            buf[6] = "*****";

        if (tour.getTextData(tourIndex.food).length() > buf[7].length())
            buf[7] = tour.getTextData(tourIndex.food);

        return buf;
    }
    public static String[] nameColomn () {
        String[] str = new String[RQFilterDB.getColumn().length + 1];
        str[0] = "№ тура";
        for (int f1 = 1; f1 < str.length; f1++) {
            str[f1] = RQFilterDB.getColumn(f1 - 1).getName(0);
        }
        return str;
    }
    public static String textDay (String days) {
        int num01 = Integer.parseInt(days.charAt(days.length() - 1) + "");
        int num20 = (days.length() > 1) ? Integer.parseInt(days.charAt(days.length() - 2) + "") : 0;

        return days + (num01 == 1 ? " день" : (((num01 == 0 || num01 >= 5) || num20 == 1) ? " дней" : " дня"));
    }
}
