package dat3.car.config.dbInit.cars;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class ImageBuilder {
    public static byte[] rawBinary(String path){
        var buff = new ByteArrayOutputStream();
        try {
            var img = ImageIO.read(new File(path));
            ImageIO.write(img,"png",buff);
            return buff.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }
}
