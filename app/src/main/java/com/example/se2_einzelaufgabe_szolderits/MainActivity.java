package com.example.se2_einzelaufgabe_szolderits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inp;
    TextView serverAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inp = findViewById(R.id.student_number);
        serverAnswer = findViewById(R.id.antwort_vom_server);
    }


    public void calculate(View view) {

        String studentNumber = inp.getText().toString();
        int[] zahlArray = new int[studentNumber.length()];

        if (studentNumber.isEmpty()) {
            inp.setText("Bitte Matrikelnummer eingeben!");
        } else {

            for (int i = 0; i < studentNumber.length(); i++) {
                zahlArray[i] = Integer.parseInt(studentNumber.substring(i, i + 1));
            }

            int product = 1;
            int j = 1;

            while (j < zahlArray.length) {
                if (zahlArray[j] % 2 == 0) {
                    product = j * product;
                    j++;
                    //1. 2*1 = 2
                    //2. 4*2 = 8
                    //3. 6*8=48
                } else
                    j++;
            }
            String solution = Integer.toString(product);
            inp.setText(solution);
        }
    }


    //Network
    public void sendToServer(View v) {
        String studentNumber = inp.getText().toString();
        String sendedAnswer;
        TCPClient tcpClient = new TCPClient();

        tcpClient.setStudentNumber(studentNumber);

        tcpClient.start(); //start Thread

        try {
            tcpClient.join(1000); //wait max. 10 millisec for the end of thread
            sendedAnswer = tcpClient.getServerAnswer();


        } catch (InterruptedException e) {
            sendedAnswer = "Could not reach port. Check your internet connection!";
        }

        serverAnswer.setText(sendedAnswer);


    }
}






