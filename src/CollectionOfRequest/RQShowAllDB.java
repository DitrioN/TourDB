package CollectionOfRequest;

import MainFunctional.*;
import MyUtils.MyUtils;

public class RQShowAllDB extends Request {
    public RQShowAllDB () {
        setName("Показать всё", "Show All");
    }

    protected void requestMenu () {
        StringBuilder str = new StringBuilder("\n\u001B[0m...- ");

        if (TourDataBase.getTour().length > 0) {
            String[] buf = MyUtils.nameColomn();

            str.append("Вот список всех туров:\n");

            for (int f1 = 0; f1 < TourDataBase.getTour().length; f1++) {
                buf = MyUtils.compareArr(f1, buf);
            }

            for (int f1 = 0; f1 < MyUtils.nameColomn().length; f1++) {
                str.append(MyUtils.nameColomn()[f1]);
                str.append(" ".repeat(buf[f1].length() - MyUtils.nameColomn()[f1].length()));
                str.append(" | ");
            }

            str.append("\n");

            for (int f1 = 0; f1 < TourDataBase.getTour().length; f1++) {
                str.append(MyUtils.drawTourStroke(f1, TourDataBase.getTour()[f1], buf));
                if (f1 + 1 < TourDataBase.getTour().length)
                    str.append("\n");
            }
        } else {
            str.append("База данных пуста.");
        }

        System.out.println(str);
    }
}
