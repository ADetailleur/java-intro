package example_07;

import java.util.Optional;

public interface WeatherInformation {

	/**
	 * Returns the temperature in Celsius for the city provided as argument.
	 */
	Optional<Double> getTemperatureFor(String city);
	
	// ...
}
