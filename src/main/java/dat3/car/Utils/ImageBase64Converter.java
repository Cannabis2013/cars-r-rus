package dat3.car.Utils;

import dat3.car.contracts.Utils.IImageConverter;
import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@Service
public class ImageBase64Converter implements IImageConverter<String> {
    @Override
    public String convert(String filePath) {
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(filePath));
        } catch (IOException e) {
            return "";
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
