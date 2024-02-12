package CollectionOfRequest.SortDB;

import CollectionOfRequest.rQfilters;
import CollectionOfRequest.rQcolumns;
import MainFunctional.Tour;
import MainFunctional.mainMenu;
import MyUtils.MyUtils;

public class RQSortByOnly extends rQfilters {
    public RQSortByOnly (rQcolumns column) {
        setName("Найти по значению", "Только", "Only", "Search");
        setColumn(column);
    }

    protected void requestMenu () {
        System.out.println("\n\u001B[0m...- " + "Введи желаемое значение из столбца '"
                + getColumn().getName()[0] + "', я найду его.");

        System.out.print("\n\u001B[32mВы - ");
        String myInput = mainMenu.scan.nextLine();

        StringBuilder str = new StringBuilder("\n\u001B[0m...- ");

        if (getTour().length > 0) {
            String[] buf = MyUtils.nameColomn();
            Tour[] tourDB2 = new Tour[getTour().length];
            int indx = 0;

            for (int f1 = 0; f1 < getTour().length; f1++) {
                boolean search = false;

                switch (getColumn().getType()) {
                    case text:
                    case option:
                        search = myInput.equalsIgnoreCase(getValS(getTour()[f1]));
                        break;
                    case number:
                        search = Double.parseDouble(myInput) == getValD(getTour()[f1]);
                        break;
                }

                if (search) {
                    buf = MyUtils.compareArr(f1, buf);
                    tourDB2[indx] = getTour()[f1];
                    indx++;
                }
            }

            if (indx > 0) {
                str.append("Вот список всех туров, со значением '").append(myInput).append("' из столбца '");
                str.append(getColumn().getName(0)).append("':\n");

                Tour[] tourDB3 = new Tour[indx];
                for (int f1 = 0; f1 < indx; f1++)
                    tourDB3[f1] = tourDB2[f1];
                str.append(MyUtils.drawMainStroke(getColumn().getIndex(), tourDB3, buf));
            } else {
                str.append("К сожалению, по твоему запросу '").append(myInput).append("' в столбце '");
                str.append(getColumn().getName(0)).append("' ничего не нашлось.");
            }
        } else {
            str.append("База данных пуста.");
        }

        System.out.println(str);
    }
}
