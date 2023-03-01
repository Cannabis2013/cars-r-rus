package dat3.car.contracts.Utils;

public interface IImageConverter<TFormat> {
    TFormat convert(String filePath);
}
