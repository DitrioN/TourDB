package CollectionOfRequest.SortDB;

import CollectionOfRequest.rQfilters;
import CollectionOfRequest.rQcolumns;
import MainFunctional.Tour;
import MyUtils.MyUtils;

public class RQSortByAlphabet extends rQfilters {
    public RQSortByAlphabet (rQcolumns req) {
        setName("В алфавитном порядке", "Алфавит", "Alphabet");
        setColumn(req);
    }
    protected void requestMenu () {
        StringBuilder str = new StringBuilder("\n\u001B[0m...- ");
        String alphabet = "-abcdefghijklmnopqrstuvwxyz абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        if (getTour().length > 0) {
            String[] buf = MyUtils.nameColomn();
            Tour[] tourDB2 = getTour();

            for (int f1 = 0; f1 < getTour().length; f1++) {
                for (int f2 = f1; f2 < getTour().length; f2++) {
                    if (!getValS(tourDB2[f1]).equals(getValS(tourDB2[f2]))) {
                        for (int f3 = 0; f3 < Math.min(getValS(tourDB2[f1]).length(), getValS(tourDB2[f2]).length()); f3++) {
                            int word1 = alphabet.indexOf(getValS(tourDB2[f1]).toCharArray()[f3]);
                            int word2 = alphabet.indexOf(getValS(tourDB2[f2]).toCharArray()[f3]);
                            if (word1 > word2) {
                                Tour tourDB3 = tourDB2[f1];
                                tourDB2[f1] = tourDB2[f2];
                                tourDB2[f2] = tourDB3;
                                break;
                            } else if (word1 < word2) {
                                break;
                            }
                        }
                    }
                }
                buf = MyUtils.compareArr(f1, buf);
            }

            str.append("Вот список всех туров, отсортированных в алфавитном порядке по столбцу '").append(getColumn().getName()[0]).append("':\n");
            str.append(MyUtils.drawMainStroke(getColumn().getIndex(), tourDB2, buf));
        } else {
            str.append("База данных пуста.");
        }

        System.out.println(str);
    }
}
