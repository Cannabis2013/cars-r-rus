package dat3.car.services.reservations;

public class CarReserveFailedException extends Exception{

    public CarReserveFailedException(String message) {
        _message = message;
    }

    @Override
    public String getMessage() {
        return _message;
    }

    private final String _message;
}
