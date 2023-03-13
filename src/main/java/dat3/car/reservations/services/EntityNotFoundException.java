package dat3.car.reservations.services;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message){
        _message = message;
    }

    @Override
    public String getMessage() {
        return _message;
    }

    private final String _message;
}
