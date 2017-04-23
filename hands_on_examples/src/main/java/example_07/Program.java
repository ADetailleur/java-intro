package example_07;

public class Program {
	
	public static void main(String[] args) {
		
		String location = "Zurich City, CH";
	
		WeatherInformation weatherInformation = new OpenWeatherMapWeatherInformation();
		double temperature = weatherInformation.getTemperatureFor(location);
		
		System.out.println("Temperature in '" + location + "': " + temperature);
	}
	
}
