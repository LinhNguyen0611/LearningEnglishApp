package com.example.learnenglish;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.widget.Button;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * Created by Linh Nguyen on 12/10/2016.
 */

public class DictionaryActivity extends Activity {
    private EditText resultText;
    private ProgressDialog progressDialog;
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        final EditText editText_Search = (EditText)findViewById(R.id.editText_Search);
        Button buttonEN = (Button)findViewById(R.id.button_EN);
        Button buttonVN = (Button)findViewById(R.id.button_VN);
        resultText = (EditText)findViewById(R.id.resultText);

        buttonEN.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String WordSearch = editText_Search.toString();
                new PareseURL().execute(new String[]{WordSearch});
            }
        });
        buttonVN.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                String WordSearch = editText_Search.toString();
                new PareseURL().execute(new String[]{WordSearch});
            }
        });

    }
    private  class PareseURL extends AsyncTask<String, Void, String>{
        protected void onPreExecute() {
            super.onPreExecute();
            showProgessDialog();
        }

        protected String doInBạckground(String... params){
            String temp ="";
            return temp;
        }
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            hideProgressDialog();
            if (s != null){
                resultText.setText(s);
            } else {
                resultText.setText("Error ?");
            }
        }
    }
    private void showProgessDialog(){
        progressDialog = new ProgressDialog(DictionaryActivity.this);
        progressDialog.setMessage("waiting...");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }
    private void hideProgressDialog(){
        if (progressDialog!= null || progressDialog.isShowing()){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
