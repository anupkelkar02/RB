package com.example.mypc.reshimbandh.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mypc.reshimbandh.Common.CommonClass;
import com.example.mypc.reshimbandh.Database.Database;
import com.example.mypc.reshimbandh.R;
import com.example.mypc.reshimbandh.Server.WebFunction;
import com.example.mypc.reshimbandh.Server.WebUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashScreenActivity extends AppCompatActivity {
    private JSONObject MASTER_JSON;
    private String url;
    String webResponse = "100";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
       // getSupportActionBar().hide();
        Button btn_login = (Button) findViewById(R.id.btn_login);
        Button btn_register = (Button) findViewById(R.id.btn_register);
        Database db = new Database(getApplicationContext());
        if (db.checkLogin()){
            Intent dashboard = new Intent(this, DashBoardActivity.class);
            startActivity(dashboard);
            finish();
        }else {
           // new webCall().execute();
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(SplashScreenActivity.this,LoginActivity.class);
                startActivity(login);
                finish();
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(SplashScreenActivity.this,RegisterActivity.class);
                startActivity(register);
                finish();
            }
        });
    }
    private class webCall extends AsyncTask<String, String, String> {
        private ProgressDialog nDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            nDialog = new ProgressDialog(SplashScreenActivity.this);
            // nDialog.setTitle("Please Wait");
            nDialog.setMessage("Loading..");
            nDialog.setIndeterminate(false);
            nDialog.setCancelable(true);
            nDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {

            JSONObject MasterData = new JSONObject();

            WebFunction serverConnection = new WebFunction();
            WebUrl serverUrl = new WebUrl();
            try {
                MasterData.put("tname", "masters");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MASTER_JSON = serverConnection.getJsonfromUrl(serverUrl.domainName + serverUrl.GernralData,MasterData);
           // M_TONGUE_MASTER_JSON = serverConnection.getJsonfromUrl(serverUrl.domainName + serverUrl.GernralData,MtongueData);
           //CASTE_MASTER_JSON = serverConnection.getJsonfromUrl(serverUrl.domainName + serverUrl.GernralData,CasteData);
           // SUB_CASTE_MASTER_JSON = serverConnection.getJsonfromUrl(serverUrl.domainName + serverUrl.GernralData,SubCasteData);
           // MARITAL_STATUS_MASTER_JSON = serverConnection.getJsonfromUrl(serverUrl.domainName + serverUrl.GernralData,MaritalData);
           // OCCUPATION_MASTER_JOSN = serverConnection.getJsonfromUrl(serverUrl.domainName + serverUrl.GernralData,AboveData);
           // QUALIFICATION_MASTER_JSON = serverConnection.getJsonfromUrl(serverUrl.domainName + serverUrl.GernralData,QualificationData);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            CommonClass commonClass = new CommonClass();
            if (MASTER_JSON !=null){saveMasters(MASTER_JSON);}
            nDialog.dismiss();
        }
    }
    protected void saveMasters(JSONObject jsonObject){
        Database db = new Database(getApplicationContext());
        try {

           // String result = jsonObject.toString();
           // JSONArray jsonArray =new JSONArray(result);
            JSONArray ALLArray = jsonObject.getJSONArray("ALL");
        for (int i=0;i< ALLArray.length();i++){
            JSONObject all_result_data = null;
            all_result_data = ALLArray.getJSONObject(i);
          if (i==0) {
//                JSONArray cityArray = all_result_data.getJSONArray("city");
//                for (int num=0;num< cityArray.length();num++){
//                    JSONObject result_data = null;
//                    result_data = cityArray.getJSONObject(num);
//                    String code = result_data.getString("ccode");
//                    String name = result_data.getString("cname");
//                    db.saveMaster(code,name,10);
//                }
          }else if(i==2) {
              JSONArray ReligionArray = all_result_data.getJSONArray("religion");
              for (int num = 0; num < ReligionArray.length(); num++) {
                  JSONObject result_data = null;
                  result_data = ReligionArray.getJSONObject(num);
                  String code = result_data.getString("ccode");
                  String name = result_data.getString("cname");
                  db.saveMaster(code, name, 3);
              }
          }else if(i==4) {
                JSONArray CasteArray = all_result_data.getJSONArray("caste");
                for (int num=0;num< CasteArray.length();num++){
                    JSONObject result_data = null;
                    result_data = CasteArray.getJSONObject(num);
                    String code = result_data.getString("ccode");
                    String name = result_data.getString("cname");
                    db.saveMaster(code,name,5);
                }
          }else if(i==5) {
                JSONArray SubCasteArray = all_result_data.getJSONArray("subcaste");
                for (int num=0;num< SubCasteArray.length();num++){
                    JSONObject result_data = null;
                    result_data = SubCasteArray.getJSONObject(num);
                    String code = result_data.getString("ccode");
                    String name = result_data.getString("cname");
                    db.saveMaster(code,name,5);
                }
          }else if(i==1) {
              JSONArray InfoArray = all_result_data.getJSONArray("info");
              for (int num = 0; num < InfoArray.length(); num++) {
                  JSONObject result_data = null;
                  result_data = InfoArray.getJSONObject(num);
                  String code = result_data.getString("ccode");
                  String name = result_data.getString("cname");
                  db.saveMaster(code, name, 2);
              }
          }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
 }
