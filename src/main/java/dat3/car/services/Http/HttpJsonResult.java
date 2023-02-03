package dat3.car.services.Http;

import dat3.car.SLA.Http.HttpResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HttpJsonResult implements HttpResult<String> {
    @Override
    public <TEntity> ResponseEntity<String> ok() {
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @Override
    public <TEntity>ResponseEntity<String> ok(TEntity entity) {
        var json = new JSONObject(entity).toString();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @Override
    public <TEntity>  ResponseEntity<String> ok(List<TEntity> entities) {
        var json = new JSONArray(entities).toString();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @Override
    public <TEntity> ResponseEntity<String> created(TEntity entity) {
        var json = new JSONObject(entity).toString();
        return new ResponseEntity<>(json,HttpStatus.CREATED);
    }

    @Override
    public  ResponseEntity<String> bad(String message) {
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> notFound() {
        return new ResponseEntity<String>("Resource not found",HttpStatus.NOT_FOUND);
    }
}
