package CollectionOfRequest;

import CollectionOfRequest.RedactorDB.*;
import MainFunctional.*;
import MyUtils.MyUtils;

public class RQRedactorDB extends Request {
    private final Request[] operation = {
            new RQCreate(),
            new RQRefactor(),
            new RQDelete()
    };

    public RQRedactorDB () {
        setName("Редактор", "Redactor");
    }

    protected void requestMenu () {
        MyUtils.chooseMenu(operation, "Выбери что ты хочешь сделать с базой данных:");
    }
}
