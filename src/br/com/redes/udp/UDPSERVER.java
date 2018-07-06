package br.com.redes.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSERVER {
	
	public static void main(String[] args) throws IOException {
		
		DatagramSocket serverSocket = new DatagramSocket(9876);
		
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		while(true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			
			String sentence = new String(receivePacket.getData());
			InetAddress address = receivePacket.getAddress(); 
			
			int port = receivePacket.getPort();
			String capitalizedSentence = sentence.toUpperCase();
			
			sendData = capitalizedSentence.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,address,port);
			serverSocket.send(sendPacket);
		}
		
	}

}
