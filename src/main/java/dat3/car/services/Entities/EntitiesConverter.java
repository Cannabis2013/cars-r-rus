package dat3.car.services.Entities;

import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;


public class EntitiesConverter<TEntity> {
    public List<TEntity> toList(Iterable<TEntity> ite)
    {
        return _toList(ite);
    }

    public String toJson(Iterable<TEntity> ite)
    {
        var entities = _toList(ite);
        var jsonArray = new JSONArray(entities);
        return jsonArray.toString();
    }

    private List<TEntity> _toList(Iterable<TEntity> ite)
    {
        var list = new ArrayList<TEntity>();
        for (var entity : ite)
            list.add(entity);
        return list;
    }
}
