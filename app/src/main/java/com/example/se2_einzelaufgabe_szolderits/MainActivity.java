package com.example.se2_einzelaufgabe_szolderits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inp;
    TextView txtOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inp = findViewById(R.id.student_number);
        txtOut = findViewById(R.id.solution);
    }


    public void calculate(View view) {

        String studentNumber = inp.getText().toString();

        if (studentNumber.isEmpty()) {
            txtOut.setText("Bitte Matrikelnummer eingeben!");
        } else {
            int[] zahlArray = new int[studentNumber.length()];

            for (int i = 0; i < studentNumber.length(); i++) {
                zahlArray[i] = Integer.parseInt(studentNumber.substring(i, i + 1));
            }

            int product = 1;
            int j = 0;

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
            txtOut.setText(solution);
        }
    }


}






