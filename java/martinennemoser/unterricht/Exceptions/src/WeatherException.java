import java.io.FileWriter;
import java.io.IOException;

public class WeatherException extends Exception {
    public WeatherException(String msg) {
        super(msg);
        try {
            FileWriter logger = new FileWriter("log.txt", true);
            logger.write(msg);
            logger.write("\n");
            logger.close();
        }
        catch(IOException e) {

        }
    }
}
