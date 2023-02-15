package dat3.car.services.Http;

import dat3.car.SLA.Http.IHttpResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
public class HttpJsonResult implements IHttpResult<String> {
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
    public ResponseEntity<String> badRequest(String message) {
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> notFound() {
        return new ResponseEntity<String>("Resource not found",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> notFound(String message) {
        return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
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
