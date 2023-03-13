package dat3.car.shared.services.Http;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HttpJsonResult extends IHttpResult<String> {
    @Override
    public ResponseEntity<String>  ok() {
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @Override
    public <TEntity>ResponseEntity<String> ok(TEntity entity) {
        var json = new JSONObject(entity).toString();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @Override
    public <TEntity>  ResponseEntity<String> ok(List<TEntity> objects) {
        var json = new JSONArray(objects).toString();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @Override
    public <TEntity> ResponseEntity<String> created() {
        return new ResponseEntity<>("Resource created",HttpStatus.CREATED);
    }

    @Override
    public <TEntity> ResponseEntity<String> created(TEntity entity) {
        var json = new JSONObject(entity).toString();
        return new ResponseEntity<>(json,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> badRequest(String message) {
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> notFound() {
        return new ResponseEntity<String>("Resource not found",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> notFound(String message) {
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> notUpdated() {
        return new ResponseEntity<>("Resource not updated",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> notUpdated(String message) {
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
}
