package com.example.se2_einzelaufgabe_szolderits;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    String studentNumber;
    String serverAnswer;

    //String  = inp.getText().toString();
    String answer;

    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
    Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    /*
    answer = inFromUser.readLine();
        outToServer.writeBytes(answer);

    clientNumber = inFromServer.readLine();
        System.out.println("FROM SERVER" + clientNumber);

        clientSocket.close();
        */


        public void setStudentNumber() {
            this.studentNumber = studentNumber;
        }

        public void setServerAnswer() {
            this.serverAnswer = serverAnswer;
        }

        public String getStudentNumber() {
            return studentNumber;
        }

        public String getServerAnswer() {
            return serverAnswer;
        }


}
