package com.example.henry.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryActivity extends AppCompatActivity {
    private HashMap<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        dictionary = new HashMap<>();
        loadDict();
    }


    public void lookup(View view) {
        EditText input = (EditText)findViewById(R.id.input);
        String word = input.getText().toString();

        TextView definition = (TextView)findViewById(R.id.definition);
        String defn = dictionary.get(word);
        if(defn == null) {
            definition.setText("Word was not found");
        }
        else {
            definition.setText(defn);
        }
    }

    private void loadDict() {
        Scanner scan = new Scanner(getResources().openRawResource(R.id.filename));

        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String pieces[] = line.split("\t");

            dictionary.put(pieces[0], pieces[1]);
        }
    }

}
