package Repository;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public abstract class BaseRepository <T,ID> {
    HashMap<ID,T>
    protected ArrayList<T> List = new ArrayList<T>;

    public void findbyid(ID id){
        return;
    }

    public void findAll(){
        return;
    }

    public abstract save(T entity){}
    pubblic abstract save(ID entitiy){}

}
