package com.example.mypc.reshimbandh.Fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.reshimbandh.Activity.DashBoardActivity;
import com.example.mypc.reshimbandh.Common.CommonClass;
import com.example.mypc.reshimbandh.Database.Database;
import com.example.mypc.reshimbandh.R;
import com.example.mypc.reshimbandh.Server.WebFunction;
import com.example.mypc.reshimbandh.Server.WebUrl;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepOneRegFragment extends Fragment {
        Spinner genderSpinner;
        private JSONObject jObj;
        private String url;

    public StepOneRegFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_one_reg, container, false);
        Database db = new Database(getContext());
        CommonClass CC = new CommonClass();
        Button btn_stepone_next = (Button)view.findViewById(R.id.btn_stepone_next);
        //EditText edit_reg_step1_dob = (EditText)view.findViewById(R.id.edit_reg_step1_dob);
        Spinner spinner = (Spinner) view.findViewById(R.id.register_gender_spinner);
        Spinner spinner_reg_step1_p_live_city = (Spinner) view.findViewById(R.id.spinner_reg_step1_p_live_city);
        Spinner spinner_reg_step1_know_abt = (Spinner) view.findViewById(R.id.spinner_reg_step1_know_abt);
        List<String> categories = new ArrayList<String>();
        categories.add("Male");
        categories.add("Female");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        ArrayAdapter<String> Living_city_Adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, db.getMaster(CC.CITY_MASTER));
        Living_city_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_reg_step1_p_live_city.setAdapter(Living_city_Adapter);

        ArrayAdapter<String> know_abt_Adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, db.getMaster(CC.ABOVE_APP_MASTER));
        know_abt_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_reg_step1_know_abt.setAdapter(know_abt_Adapter);



        btn_stepone_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepTwoRegFragment stepTwoRegFragment = new StepTwoRegFragment();
                android.support.v4.app.FragmentTransaction steponefragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                steponefragmentTransaction.replace(R.id.steps,stepTwoRegFragment);
                steponefragmentTransaction.commit();
            }
        });
        view.findViewById(R.id.edit_reg_step1_dob).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerFrag dFragment = new DatePickerFrag();
               // showDatePicker();
                dFragment.show(getFragmentManager(), "Date Picker");
            }
        });
        return view;
    }

    public static class DatePickerFrag extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            /*
                Initialize a new DatePickerDialog

                DatePickerDialog(Context context, DatePickerDialog.OnDateSetListener callBack,
                    int year, int monthOfYear, int dayOfMonth)
             */
            DatePickerDialog dpd = new DatePickerDialog(getActivity(),this,year,month,day);
            return  dpd;
        }

        public void onDateSet(DatePicker view, int year, int month, int day){
            // Do something with the chosen date
            TextView tv = (TextView) getActivity().findViewById(R.id.edit_reg_step1_dob);

            // Create a Date variable/object with user chosen date
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(0);
            cal.set(year, month, day, 0, 0, 0);
            Date chosenDate = cal.getTime();

            // Format the date using style and locale
            //DateFormat df = DateFormat.getDateInstance();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = df.format(chosenDate);

            // Display the chosen date to app interface
            tv.setText(formattedDate);
        }
    }
    private class webCall extends AsyncTask<String, String, String> {
        private ProgressDialog nDialog;
       // String username = user_login_username.getText().toString();
        //String password = user_login_password.getText().toString();


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
               // UserParamData.put("username", username);
                //UserParamData.put("password", password);
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
                  //          db.saveLogin(mname,username,email,age);
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
