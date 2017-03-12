package com.example.manav.tindermaths;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EditCustomQuiz extends AppCompatActivity {

    String fileName = "";
    String userID, userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_custom_quiz);
        addItemsOnSpinner();
        Bundle b = getIntent().getExtras();
        userID = b.getString("userID");
        userName = b.getString("userName");


    }

    public void addItemsOnSpinner() {

        Spinner spinner = (Spinner) findViewById(R.id.quizNames);
        ArrayList<String> CustomQuizNames = readFile("customquiznames.txt");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CustomQuizNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);spinner.setAdapter(dataAdapter);
    }

    public ArrayList<String> readFile(String filename) {
        FileInputStream fis;
        ArrayList<String> files = new ArrayList<String>();
        try {

            fis = openFileInput(filename);
            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                String string =new String(buffer, 0, n);
                String[] stringTrimmed = string.split("\n");
                for(int i = 0; i < stringTrimmed.length; i++){
                    files.add(stringTrimmed[i]);
                }
            }
        } catch(IOException e) {
            System.out.println("No Quizzes made");
        }
        return files;
    }

    public void readQuiz(View view){
        Spinner spinner = (Spinner) findViewById(R.id.quizNames);
        fileName = String.valueOf(spinner.getSelectedItem());
        FileInputStream fis;
        ArrayList<String> files = new ArrayList<String>();
        try {

            fis = openFileInput(fileName + ".txt");
            byte[] buffer = new byte[1024];
            int n;
            String[] qAnda = null;
            while ((n = fis.read(buffer)) != -1) {
                String string =new String(buffer, 0, n);
                String[] stringTrimmed = string.split("\n");
                qAnda = new String[stringTrimmed.length*2];
                for(int i = 0; i < stringTrimmed.length; i++){
                    for(int j = 0; j < 2;  j ++){
                        String[] stringSeperatedinQandA = stringTrimmed[i].split(",");
                        qAnda[(2*i)+j] = stringSeperatedinQandA[j];
                    }
                }
            }
            fis.close();
            ((EditText) findViewById(R.id.q1q)).setText(qAnda[0]);
            Spinner answer = (Spinner) findViewById(R.id.q1a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[1]));
            ((EditText) findViewById(R.id.q2q)).setText(qAnda[2]);
            answer = (Spinner) findViewById(R.id.q2a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[3]));
            ((EditText) findViewById(R.id.q3q)).setText(qAnda[4]);
            answer = (Spinner) findViewById(R.id.q3a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[5]));
            ((EditText) findViewById(R.id.q4q)).setText(qAnda[6]);
            answer = (Spinner) findViewById(R.id.q4a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[7]));
            ((EditText) findViewById(R.id.q5q)).setText(qAnda[8]);
            answer = (Spinner) findViewById(R.id.q5a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[9]));
            ((EditText) findViewById(R.id.q6q)).setText(qAnda[10]);
            answer = (Spinner) findViewById(R.id.q6a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[11]));
            ((EditText) findViewById(R.id.q7q)).setText(qAnda[12]);
            answer = (Spinner) findViewById(R.id.q7a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[13]));
            ((EditText) findViewById(R.id.q8q)).setText(qAnda[14]);
            answer = (Spinner) findViewById(R.id.q8a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[15]));
            ((EditText) findViewById(R.id.q9q)).setText(qAnda[16]);
            answer = (Spinner) findViewById(R.id.q9a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[17]));
            ((EditText) findViewById(R.id.q10q)).setText(qAnda[18]);
            answer = (Spinner) findViewById(R.id.q10a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[19]));
            ((EditText) findViewById(R.id.q11q)).setText(qAnda[20]);
            answer = (Spinner) findViewById(R.id.q11a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[21]));
            ((EditText) findViewById(R.id.q12q)).setText(qAnda[22]);
            answer = (Spinner) findViewById(R.id.q12a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[23]));
            ((EditText) findViewById(R.id.q13q)).setText(qAnda[24]);
            answer = (Spinner) findViewById(R.id.q13a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[25]));
            ((EditText) findViewById(R.id.q14q)).setText(qAnda[26]);
            answer = (Spinner) findViewById(R.id.q14a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[27]));
            ((EditText) findViewById(R.id.q15q)).setText(qAnda[28]);
            answer = (Spinner) findViewById(R.id.q15a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[29]));
            ((EditText) findViewById(R.id.q16q)).setText(qAnda[30]);
            answer = (Spinner) findViewById(R.id.q16a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[31]));
            ((EditText) findViewById(R.id.q17q)).setText(qAnda[32]);
            answer = (Spinner) findViewById(R.id.q17a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[33]));
            ((EditText) findViewById(R.id.q18q)).setText(qAnda[34]);
            answer = (Spinner) findViewById(R.id.q18a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[35]));
            ((EditText) findViewById(R.id.q19q)).setText(qAnda[36]);
            answer = (Spinner) findViewById(R.id.q19a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[37]));
            ((EditText) findViewById(R.id.q20q)).setText(qAnda[38]);
            answer = (Spinner) findViewById(R.id.q20a);
            answer.setSelection(((ArrayAdapter)answer.getAdapter()).getPosition(qAnda[39]));
        } catch(IOException e) {
            System.out.println("No Quizzes made");
        }


    }
    public void getQuizDetails(View view){
        try {
            if(!(((EditText)findViewById(R.id.q1q)).getText().toString()).trim().equals("")) {
                if(!(((EditText)findViewById(R.id.q2q)).getText().toString()).trim().equals("")) {
                    if (!(((EditText) findViewById(R.id.q3q)).getText().toString()).trim().equals("")) {
                        if (!(((EditText) findViewById(R.id.q4q)).getText().toString()).trim().equals("")) {
                            if (!(((EditText) findViewById(R.id.q5q)).getText().toString()).trim().equals("")) {
                                if (!(((EditText) findViewById(R.id.q6q)).getText().toString()).trim().equals("")) {
                                    if (!(((EditText) findViewById(R.id.q7q)).getText().toString()).trim().equals("")) {
                                        if (!(((EditText) findViewById(R.id.q8q)).getText().toString()).trim().equals("")) {
                                            if (!(((EditText) findViewById(R.id.q9q)).getText().toString()).trim().equals("")) {
                                                if (!(((EditText) findViewById(R.id.q10q)).getText().toString()).trim().equals("")) {
                                                    if (!(((EditText) findViewById(R.id.q11q)).getText().toString()).trim().equals("")) {
                                                        if (!(((EditText) findViewById(R.id.q12q)).getText().toString()).trim().equals("")) {
                                                            if (!(((EditText) findViewById(R.id.q13q)).getText().toString()).trim().equals("")) {
                                                                if (!(((EditText) findViewById(R.id.q14q)).getText().toString()).trim().equals("")) {
                                                                    if (!(((EditText) findViewById(R.id.q15q)).getText().toString()).trim().equals("")) {
                                                                        if (!(((EditText) findViewById(R.id.q16q)).getText().toString()).trim().equals("")) {
                                                                            if (!(((EditText) findViewById(R.id.q17q)).getText().toString()).trim().equals("")) {
                                                                                if (!(((EditText) findViewById(R.id.q18q)).getText().toString()).trim().equals("")) {
                                                                                    if (!(((EditText) findViewById(R.id.q19q)).getText().toString()).trim().equals("")) {
                                                                                        if (!(((EditText) findViewById(R.id.q20q)).getText().toString()).trim().equals("")) {
                                                                                            FileOutputStream outputStream = openFileOutput((fileName + ".txt"), Context.MODE_PRIVATE); // TODO: Make sure this can be read
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q1q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q1a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q2q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q2a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q3q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q3a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q4q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q4a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q5q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q5a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q6q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q6a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q7q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q7a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q8q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q8a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q9q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q9a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q10q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q10a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q11q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q11a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q12q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q12a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q13q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q13a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q14q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q14a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q15q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q15a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q16q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q16a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q17q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q17a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q18q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q18a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q19q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q19a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.write(((((EditText) findViewById(R.id.q20q)).getText().toString()) + "," + String.valueOf(((Spinner) findViewById(R.id.q20a)).getSelectedItem() + "\n")).getBytes());
                                                                                            outputStream.close();
                                                                                            Intent i = new Intent(this, MainActivity.class);
                                                                                            i.putExtra("userID", userID);
                                                                                            i.putExtra("userName", userName);
                                                                                            startActivity(i);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            TextView error = (TextView) findViewById(R.id.errorText);
            error.setText("You have left questions blank");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
