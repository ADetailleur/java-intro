package example_07;

import java.util.Optional;

public class Program {
	
	public static void main(String[] args) {
		
		String location;
		if (args.length == 1) {
			location = args[0];
		}
		else {
			location = "Zurich, CH";
		}
	
		WeatherInformation weatherInformation = new OpenWeatherMapWeatherInformation();
		Optional<Double> temperature = weatherInformation.getTemperatureFor(location);
		if (temperature.isPresent()) {
			System.out.println("Temperature in '" + location + "': " + temperature.get() + " °C");
		}
		else {
			System.out.println("Place not found");
		}
	}
	
}
