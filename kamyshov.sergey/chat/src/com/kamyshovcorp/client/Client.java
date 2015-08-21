package com.kamyshovcorp.client;

import com.kamyshovcorp.ClientInfo;
import com.kamyshovcorp.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Client {
	private static final String SERVER_HOSTNAME = "localhost";
	private static final int SERVER_PORT = 1234;
	private static String clientHostName;
	private static int clientPort;
	private static String userName;

	public static void main(String[] args) {
		try {
			clientHostName = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите порт клиента: ");
		// TODO: Почему при использовании scanner.nextInt() проблема?
		clientPort = Integer.valueOf(scanner.nextLine());

		System.out.print("Введите имя пользователя: ");
		userName = scanner.nextLine();

		// Writer
		new Thread(new Runnable() {
			@Override
			public void run() {
				Message message;
				ClientInfo clientInfo;
				ObjectOutputStream outputStream;
				String textMessage;

				while (true) {
					textMessage = scanner.nextLine();
					clientInfo = new ClientInfo(userName, clientHostName, clientPort);
					message = new Message(textMessage, clientInfo);
					// socket закроется автоматически, а с ним и outputStream
					try (Socket socket = new Socket(SERVER_HOSTNAME, SERVER_PORT)) {
						outputStream = new ObjectOutputStream(socket.getOutputStream());
						outputStream.writeObject(message);
						// можно не указывать, т.к. при закрытии socket метод flush() вызывается автоматически
						outputStream.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		// Reader
		new Thread(new Runnable() {
			@Override
			public void run() {
				try (ServerSocket serverSocket = new ServerSocket(clientPort)) {
					ObjectInputStream inputStream;
					Message message;

					while (true) {
						try (Socket socket = serverSocket.accept()) {
							inputStream = new ObjectInputStream(socket.getInputStream());
							message = (Message) inputStream.readObject();
							System.out.println(message.getText());
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
