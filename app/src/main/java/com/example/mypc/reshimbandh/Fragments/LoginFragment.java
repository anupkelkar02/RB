package com.example.mypc.reshimbandh.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.reshimbandh.Activity.DashBoardActivity;
import com.example.mypc.reshimbandh.Activity.RegisterActivity;
import com.example.mypc.reshimbandh.Database.Database;
import com.example.mypc.reshimbandh.R;
import com.example.mypc.reshimbandh.Server.ConnectionDetector;
import com.example.mypc.reshimbandh.Server.WebFunction;
import com.example.mypc.reshimbandh.Server.WebUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.R.id.list;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    TextView user_login_signup;
    Button btn_login;
    EditText user_login_username,user_login_password;
    private JSONObject jObj;
    private String url;
    String webResponse = "100";
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        user_login_signup = (TextView) view.findViewById(R.id.user_login_signup);
        btn_login = (Button) view.findViewById(R.id.btn_login);
        user_login_username = (EditText) view.findViewById(R.id.user_login_username);
        user_login_password = (EditText) view.findViewById(R.id.user_login_password);
        user_login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(getActivity(), RegisterActivity.class);
                startActivity(register);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_login_username.getText().toString().equals("")){
                    Toast.makeText(getActivity(),
                            "Username required", Toast.LENGTH_SHORT).show();
                }else if (user_login_password.getText().toString().equals("")){
                    Toast.makeText(getActivity(),
                            "Password required", Toast.LENGTH_SHORT).show();
                }else {
                    //Database database = new Database(getActivity());
                    ConnectionDetector connectionDetector = new ConnectionDetector(getContext());
                    if (connectionDetector.isConnectingToInternet()){
                        new webCall().execute();
                    }else {
                        Toast.makeText(getActivity(),
                                       "No internet Connection", Toast.LENGTH_SHORT).show();

                    }

                    //user =database.login(username,password);

                }


            }
        });
        return view;
    }


    private class webCall extends AsyncTask<String, String, String> {
        private ProgressDialog nDialog;
        String username = user_login_username.getText().toString();
        String password = user_login_password.getText().toString();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            nDialog = new ProgressDialog(getActivity());
           // nDialog.setTitle("Please Wait");
            nDialog.setMessage("Loading..");
            nDialog.setIndeterminate(false);
            nDialog.setCancelable(true);
            nDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            try {
                JSONObject UserParam = new JSONObject();
                JSONObject UserParamData = new JSONObject();
                UserParamData.put("tag", "login");
                // UserParam.put("Jahirnama", UserParamData);
                UserParamData.put("username", username);
                UserParamData.put("password", password);
                //UserParam.put("User", UserParamData);
                WebFunction serverConnection = new WebFunction();
                WebUrl serverUrl = new WebUrl();
                url = serverUrl.domainName + serverUrl.loginurl;
                jObj = serverConnection.getJsonfromUrl(url, UserParamData);
                // }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            JSONObject json_result = null;
            try {
                if (jObj !=null){
                    String result = jObj.toString();
                    if (result != null) {
                        json_result = new JSONObject(result);
                        String tag = json_result.getString("tag");
                        String status = json_result.getString("status");
                        if(status.equals("true")){
                            String mname = json_result.getString("mname");
                            String email = json_result.getString("email");
                            String age = json_result.getString("age");
                            Database db = new Database(getContext());
                            db.saveLogin(mname,username,email,age);
                            Toast.makeText(getActivity(),
                                    "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent dashboard = new Intent(getActivity(), DashBoardActivity.class);
                            startActivity(dashboard);
                            getActivity().finish();

                        }else {
                            Toast.makeText(getActivity(),
                                    "Invalid username and password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();

            }
            nDialog.dismiss();
        }
    }


}
