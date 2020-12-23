import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Java distinguishes between:
// - checked exceptions (compile-time exceptions)
// Example for checked exceptions: Exception

// - unchecked exceptions (runtime exceptions)
// Example: NullpointerException

public class ThrowsExample {
    public static void main(String[] args) {
        try {
            String weatherState = ThrowsExample.askForWeather(5);
            weatherForecast(3);
            System.out.println(weatherState);
        }
        catch (IllegalArgumentException | WeatherException e) {
            System.out.println(e.toString());
        } catch (Exception e) {

        }
        // It is not possible to catch the same exception twice multiple times
        //catch(IllegalArgumentException e1) {
        //
        //}
    }

    private static String weatherForecast(int dayOfYear) throws WeatherException {
        if((dayOfYear < 0 || dayOfYear > 364)) {
            IllegalArgumentException myException = new IllegalArgumentException("Day of year is " + dayOfYear + " . But should be 0-364.");
            throw myException;
        }

        System.out.println("Get weather for day " + dayOfYear + 1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("How is the weather on day " + dayOfYear + "?");
        String weatherState = scanner.nextLine();

        if(weatherState.equals("sunny")) {
            return "sunny";
        } else if (weatherState.equals("rainy")) {
            return "sunny";
        } else if (weatherState.equals("snowing")) {
            return "cloudy";
        } else {
            throw new WeatherException("Weather cannot be determined");
        }

    }

    private static String askForWeather(int dayOfYear) throws Exception, Error {
        if((dayOfYear < 0 || dayOfYear > 364)) {
            IllegalArgumentException myException = new IllegalArgumentException("Day of year is " + dayOfYear + " . But should be 0-364.");
            throw myException;
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("How is the weather on day " + dayOfYear + "?");
        String weatherState = scanner.nextLine();
        FileWriter myWriter = null;
        if(!weatherState.equals("")) {
            myWriter = new FileWriter("weatherdata/data.txt");
        }
        if(weatherState.equals("bad")) {
            throw new WeatherException("Weather must not be bad.");
        }
        if(weatherState.equals("rainy")) {
            throw new WeatherException("Weather must not be rainy.");
        }

        //if(myWriter == null) {
        //    throw new NullPointerException("Our writer is null.");
        //}


        myWriter.write("The weather is " + weatherState + ".");
        myWriter.close();

        return weatherState;
    }
}
