import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			System.out.println("Server is running. Waiting for a client to connect...");

			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connected.");

			FileInputStream fileInputStream = new FileInputStream("resources/Sample_abc.jpg");
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			OutputStream outputStream = clientSocket.getOutputStream();

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			System.out.println("Image sent to the client.");
			clientSocket.close();
			serverSocket.close();
			bufferedInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
