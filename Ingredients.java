package present;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {
    protected List<String> name;

    public Ingredients (){
        this.name=new ArrayList<>();
    }
    public List<String> getName() {
        return name;
    }
}
