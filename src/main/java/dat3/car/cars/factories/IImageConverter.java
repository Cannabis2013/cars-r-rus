package dat3.car.cars.factories;

public interface IImageConverter<TFormat> {
    TFormat convert(String filePath);
}
