package example_08;

import java.io.IOException;

import example_08.WebServer.RequestHandler;

public class HelloWorldWebserver {

  public static void main(String[] args) throws IOException {
    WebServer webServer = new WebServer("localhost", 8080);
    webServer.registerHandler(new RequestHandler() {

      @Override
      public String handle(String query) {

        // Currently, this web server just returns 'Hello', when you use a browser to surf to the page.
        return "Hello " + query;

        
        // Make it a little more interesting:
        // 1. Return the current time. Can you find out how to do it? (Hint: There is a 'Date' class.)

        
        
        
        // 2. Return a random number from 1 to 6 (a dice).

        
        
        
        // 3. Return a random number from 0 to the number provided as query:
        // 
        // 		http://localhost:8080/38 would generate a number between 0 and 38.
        // 
        // Use this expression to convert the query string into an actual number: Integer.valueOf(query)
        

      }

    });

    webServer.startServer();
  }

}
