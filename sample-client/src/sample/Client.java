package sample;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;


public class Client {
	
	public static void main(String[] args) throws IOException, InterruptedException {
	
		try {
            Socket clientSocket = new Socket("localhost", 1234); // Replace with the actual server address

            InputStream inputStream = clientSocket.getInputStream();
            BufferedImage image = ImageIO.read(inputStream);
            System.out.print(image);
            JFrame frame = new JFrame("Received Image");
            frame.setSize(800, 600);
            JLabel label = new JLabel(new ImageIcon(image));
            frame.add(label, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            TimeUnit.SECONDS.sleep(5);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}

