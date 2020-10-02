package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import processing.core.PApplet;

public class Main extends PApplet {
	
	private Socket socket;
	
	

	public static void main(String[] args) {
		PApplet.main("main.Main");

	}

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		Init();
	}

	public void draw() {
		background(0);
	}

	public void Init() {
		new Thread(
				()->{
					try {
						ServerSocket server = new ServerSocket(5000);
						System.out.println("Perate");
						socket=server.accept();
						System.out.println("Listo mi rey");
						
						InputStream is = socket.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader reader = new BufferedReader(isr);
						
						while(true) {
						System.out.println("perate pue..");
						String line=reader.readLine();
						System.out.println("Recibido...");
						System.out.println("Recibido:"+line);
						}
					
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				).start();

}
}
