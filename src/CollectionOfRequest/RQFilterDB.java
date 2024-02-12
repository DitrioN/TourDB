package CollectionOfRequest;

import CollectionOfRequest.SortDB.*;
import MainFunctional.*;
import MyUtils.MyUtils;

public class RQFilterDB extends Request {
    private static final rQcolumns[] column = {
            new rQcolumns(tourIndex.country, tourTypeData.text, "Страна", "По стране", "Country", "By country"),
            new rQcolumns(tourIndex.city, tourTypeData.text, "Город", "По городу", "City", "By city"),
            new rQcolumns(tourIndex.transport, tourTypeData.option, "Транспорт", "По транспорту", "Transport", "By transport"),
            new rQcolumns(tourIndex.days, tourTypeData.number, "Продолжительность", "По дню", "Days", "By days"),
            new rQcolumns(tourIndex.price, tourTypeData.number, "Стоимость", "По цене", "Price", "By price"),
            new rQcolumns(tourIndex.rating, tourTypeData.number, "Оценка", "По оценке", "Rating", "By rating"),
            new rQcolumns(tourIndex.food, tourTypeData.option, "Питание", "По питанию", "Food", "By food")
    };

    public RQFilterDB () {
        setName("Фильтрация", "Фильтр", "Сортировка", "Filter", "Sorted");
    }

    protected void requestMenu () {
        MyUtils.chooseMenu(column, "По какому столбцу фильтровать:");
    }

    public void filterMenu (rQcolumns req) {
        StringBuilder str = new StringBuilder("По какому принципу фильтровать столбец '");
        str.append(req.getName()[0]).append("'?");

        rQfilters[] filter;

        switch (req.getType()) {
            case text:
                filter = new rQfilters[]{new RQSortByAlphabet(req), new RQSortByExclude(req), new RQSortByOnly(req)};
                MyUtils.chooseMenu(filter, str.toString());
                break;
            case number:
                filter = new rQfilters[]{new RQSortByAscending(req), new RQSortByDescending(req), new RQSortByExclude(req),
                        new RQSortByOnly(req), new RQSortByMore(req), new RQSortByLess(req)};
                MyUtils.chooseMenu(filter, str.toString());
                break;
            case option:
                filter = new rQfilters[]{new RQSortByExclude(req), new RQSortByOnly(req)};
                MyUtils.chooseMenu(filter, str.toString());
                break;
        }
    }

    public static rQcolumns[] getColumn () {
        return column;
    }
    public static rQcolumns getColumn (int i) {
        return column[i];
    }
}
