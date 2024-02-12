package CollectionOfRequest;

import MainFunctional.*;

public class rQcolumns extends Request {
    private final tourTypeData type;
    private final tourIndex index;

    public rQcolumns (tourIndex index, tourTypeData type, String... name) {
        this.type = type;
        this.index = index;
        setName(name);
    }

    protected void requestMenu() {
        new RQFilterDB().filterMenu(this);
    }

    public tourTypeData getType () {
        return type;
    }

    public tourIndex getIndex () {
        return index;
    }
}
