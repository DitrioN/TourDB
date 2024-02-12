package CollectionOfRequest;

import MainFunctional.*;

public class rQfilters extends Request {
    private rQcolumns column;

    public rQfilters () {

    }

    public void setColumn (rQcolumns column) {
        this.column = column;
    }

    public rQcolumns getColumn () {
        return column;
    }
    public String getValS (Tour tour) {
        return tour.getTextData(column.getIndex()).toLowerCase();
    }
    public double getValD (Tour tour) {
        return Double.parseDouble(tour.getTextData(column.getIndex()));
    }
    public Tour[] getTour () {
        return TourDataBase.getTour();
    }
}
