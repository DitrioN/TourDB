package CollectionOfRequest.SortDB;

import CollectionOfRequest.rQfilters;
import CollectionOfRequest.rQcolumns;
import MainFunctional.Tour;
import MainFunctional.mainMenu;
import MyUtils.MyUtils;

public class RQSortByExclude extends rQfilters {
    public RQSortByExclude (rQcolumns column) {
        setName("Исключить из списка", "Исключить", "Exclude");
        setColumn(column);
    }

    protected void requestMenu () {
        System.out.println("\n\u001B[0m...- " + "Введи желаемое значение из столбца '"
                + getColumn().getName()[0] + "', я исключу его из списка.");

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
                if (!search) {
                    buf = MyUtils.compareArr(f1, buf);
                    tourDB2[indx] = getTour()[f1];
                    indx++;
                }
            }

            if (tourDB2.length != getTour().length) {
                str.append("Вот список всех туров, исключая '").append(myInput).append("' из столбца '");
                str.append(getColumn().getName()[0]).append("':\n");
            } else {
                str.append("Вот список всех туров, но он без изменений т.к. исключить несуществующее '").append(myInput).append("' из столбца '");
                str.append(getColumn().getName()[0]).append("' не удалось:\n");
            }

            Tour[] tourDB3 = new Tour[indx];
            for (int f1 = 0; f1 < indx; f1++)
                tourDB3[f1] = tourDB2[f1];
            str.append(MyUtils.drawMainStroke(getColumn().getIndex(), tourDB3, buf));
        } else {
            str.append("База данных пуста.");
        }

        System.out.println(str);
    }
}
