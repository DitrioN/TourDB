package CollectionOfRequest.SortDB;

import CollectionOfRequest.rQfilters;
import CollectionOfRequest.rQcolumns;
import MainFunctional.Tour;
import MyUtils.MyUtils;

public class RQSortByDescending extends rQfilters {
    public RQSortByDescending (rQcolumns req) {
        setName("По убыванию", "Descending");
        setColumn(req);
    }
    protected void requestMenu () {
        StringBuilder str = new StringBuilder("\n\u001B[0m...- ");

        if (getTour().length > 0) {
            String[] buf = MyUtils.nameColomn();
            Tour[] tourDB2 = getTour();

            for (int f1 = 0; f1 < getTour().length; f1++) {
                for (int f2 = f1; f2 < getTour().length; f2++) {
                    if (getValD(tourDB2[f1]) < getValD(tourDB2[f2])) {
                        Tour tourDB3 = tourDB2[f1];
                        tourDB2[f1] = tourDB2[f2];
                        tourDB2[f2] = tourDB3;
                    }
                }
                buf = MyUtils.compareArr(f1, buf);
            }

            str.append("Вот список всех туров, в убывающем порядке по столбцу '").append(getColumn().getName()[0]).append("':\n");
            str.append(MyUtils.drawMainStroke(getColumn().getIndex(), tourDB2, buf));
        } else {
            str.append("База данных пуста.");
        }

        System.out.println(str);
    }
}
