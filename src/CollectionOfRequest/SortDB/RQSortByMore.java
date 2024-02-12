package CollectionOfRequest.SortDB;

import CollectionOfRequest.rQfilters;
import CollectionOfRequest.rQcolumns;
import MainFunctional.Tour;
import MainFunctional.mainMenu;
import MyUtils.MyUtils;

public class RQSortByMore extends rQfilters {
    public RQSortByMore (rQcolumns req) {
        setName("Большее", "More");
        setColumn(req);
    }

    protected void requestMenu () {
        System.out.println("\n\u001B[0m...- " + "Введи значение из столбца '" +
                getColumn().getName()[0] + "', я покажу большие значения, либо равные ему.");

        System.out.print("\n\u001B[32mВы - ");
        String myInput = mainMenu.scan.nextLine();

        StringBuilder str = new StringBuilder("\n\u001B[0m...- ");

        if (getTour().length > 0) {
            String[] buf = MyUtils.nameColomn();
            Tour[] tourDB2 = new Tour[getTour().length];
            int indx = 0;

            for (int f1 = 0; f1 < getTour().length; f1++) {
                if (Double.parseDouble(myInput) <= getValD(getTour()[f1])) {
                    buf = MyUtils.compareArr(f1, buf);
                    tourDB2[indx] = getTour()[f1];
                    indx++;
                }
            }

            if (indx > 0) {
                str.append("Вот список всех туров, превышающих или равных значению '").append(myInput).append("' из столбца '");
                str.append(getColumn().getName()[0]).append("':\n");

                Tour[] tourDB3 = new Tour[indx];
                for (int f1 = 0; f1 < indx; f1++)
                    tourDB3[f1] = tourDB2[f1];
                str.append(MyUtils.drawMainStroke(getColumn().getIndex(), tourDB3, buf));
            } else {
                str.append("К сожалению, значения больше чем '").append(myInput).append("' в столбце '");
                str.append(getColumn().getName(0)).append("' нет.");
            }
        } else {
            str.append("База данных пуста.");
        }

        System.out.println(str);
    }
}
