import processing.core.*;
import processing.net.*;

public class App extends PApplet{

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
		App mySketch = new App();
		PApplet.runSketch(processingArgs, mySketch);
    }

    Client client;

    public void settings() {
        size(640, 360);
    }

    public void setup() {
        client = new Client(this, "127.0.0.1", 12345);
        background(102);
    }

    public void draw() {
        if (client.available() > 0){
            String input = client.readString();
            println(input);
        }

        client.write(500);
    }
}
