package br.com.redes.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		
		InetAddress iAddress = InetAddress.getByName("127.1.1.1");
		
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		
		String  sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,iAddress,9876);
		
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		
		String modifiedSentence = new String(receivePacket.getData());
		
		System.out.println("FROM SeRVER: " + modifiedSentence);
		clientSocket.close();
		
		

	}

}
