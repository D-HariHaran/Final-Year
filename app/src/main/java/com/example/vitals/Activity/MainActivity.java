package com.example.vitals.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vitals.Beans.RegData;
import com.example.vitals.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name_,
                age_,
                gender_,
                currSmoker_,
                cigsPerDay_,
                bpMeds_,
                prevStroke_,
                prevHyp_,
                diab_,
                totchol_,
                height_,
                weight_,
                glucose_,
                tenYearCHD_,
                hardwareid_;
        int male=0;

        Button register_btn;

        getSupportActionBar().hide();

        SharedPreferences pref = getSharedPreferences("register",0);
        if(pref.getInt("ID",0)!=0 && pref.getString("patient_name",null)!="")
        {
            Intent intent = new Intent(MainActivity.this, Stats.class);
            startActivity(intent);
            finish();
        }

        name_= (EditText) findViewById(R.id.name);
        age_=findViewById(R.id.age);

        gender_=findViewById(R.id.gender);
        male=gender_.getText().toString().toLowerCase().equals("m") ? 1 : 0;

        currSmoker_=findViewById(R.id.currSmoker);
        cigsPerDay_=findViewById(R.id.cigsPerDay);
        bpMeds_=findViewById(R.id.bpMeds);
        prevStroke_=findViewById(R.id.prevStroke);
        prevHyp_=findViewById(R.id.prevHyp);
        diab_=findViewById(R.id.diab);
        totchol_=findViewById(R.id.totchol);
        height_=findViewById(R.id.height);
        weight_=findViewById(R.id.weight);
        glucose_=findViewById(R.id.glucose);
        tenYearCHD_=findViewById(R.id.tenYearCHD);
        register_btn= findViewById(R.id.register);
        hardwareid_= findViewById(R.id.hardwareid);

        final String bean_name=name_.getText().toString();
        final int bean_age=Integer.parseInt(age_.getText().toString());
        final int bean_male=male;
        final int bean_currSmoker=currSmoker_.getText().toString().toLowerCase().equals("yes") ? 1 : 0;
        final int bean_cigsPerDay=Integer.parseInt(cigsPerDay_.getText().toString());
        final int bean_bpMeds=bpMeds_.getText().toString().toLowerCase().equals("yes") ? 1 : 0;
        final int bean_prevStroke=prevStroke_.getText().toString().toLowerCase().equals("yes") ? 1 : 0;
        final int bean_prevHyp=prevHyp_.getText().toString().toLowerCase().equals("yes") ? 1 : 0;
        final int bean_diab=diab_.getText().toString().toLowerCase().equals("yes") ? 1 : 0;
        final int bean_tenYearCHD=tenYearCHD_.getText().toString().toLowerCase().equals("yes") ? 1 : 0;
        final double bean_totchol=Double.parseDouble(totchol_.getText().toString());
        final double bean_height=Double.parseDouble(height_.getText().toString());
        final double bean_weight=Double.parseDouble(weight_.getText().toString());
        final double bean_glucose=Double.parseDouble(glucose_.getText().toString());
        final int bean_hardwareid = Integer.parseInt(hardwareid_.getText().toString());







        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name_.getText().length() == 0 ||
                        age_.getText().length()==0 ||
                        gender_.getText().length()==0 ||
                        currSmoker_.getText().length()==0 ||
                        cigsPerDay_.getText().length()==0 ||
                        bpMeds_.getText().length()==0 ||
                        prevStroke_.getText().length()==0 ||
                        prevHyp_.getText().length()==0 ||
                        diab_.getText().length()==0 ||
                        totchol_.getText().length()==0 ||
                        height_.getText().length()==0 ||
                        weight_.getText().length()==0 ||
                        glucose_.getText().length()==0 ||
                        tenYearCHD_.getText().length()==0 ||
                        hardwareid_.getText().length()==0

                ) {
                    Toast.makeText(getApplicationContext(), "Please enter all the details", Toast.LENGTH_SHORT).show();
                } else {
                    RegData regdata = new RegData(bean_name,
                            bean_age,
                            bean_male,
                            bean_currSmoker,
                            bean_cigsPerDay,
                            bean_bpMeds,
                            bean_prevStroke,
                            bean_prevHyp,
                            bean_diab,
                            bean_tenYearCHD,
                            bean_totchol,
                            bean_height,
                            bean_weight,
                            bean_glucose,
                            bean_hardwareid);
                    final String name = regdata.getName();
                    final int age = regdata.getAge();
                    final int male = regdata.getMale();
                    final int currSmoker = regdata.getCurrSmoker();
                    final int cigsPerDay = regdata.getCigsPerDay();
                    final int bpMeds = regdata.getBpMeds();
                    final int prevStroke = regdata.getPrevStroke();
                    final int prevHyp = regdata.getPrevHyp();
                    final int diab = regdata.getDiab();
                    final int tenYearCHD = regdata.getTenYearCHD();
                    final double totchol = regdata.getTotchol();
                    final double bmi = (double)(regdata.getHeight()/regdata.getWeight());
                    final double glucose = regdata.getGlucose();
                    final int id_ref = regdata.getHardwareid();


                    SharedPreferences preferences=getSharedPreferences("register",0);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putBoolean("remember",true);
                    editor.putString("name",regdata.getName());
                    editor.apply();

                    AsyncHttpClient client = new AsyncHttpClient();
                    JSONObject jsonObject = new JSONObject();
                    StringEntity entity = null;
                    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    // SharedPreferences.Editor editor = settings.edit();
                    editor.commit();
                    try {
                        entity = new StringEntity("{}");
                        jsonObject.put("name", name);
                        jsonObject.put("age", age);
                        jsonObject.put("male", male);
                        jsonObject.put("currSmoker",currSmoker);
                        jsonObject.put("cigsPerDay",cigsPerDay);
                        jsonObject.put("bpMeds",bpMeds);
                        jsonObject.put("prevStroke",prevStroke);
                        jsonObject.put("prevHyp",prevHyp);
                        jsonObject.put("diab",diab);
                        jsonObject.put("totchol",totchol);
                        jsonObject.put("bmi",bmi);
                        jsonObject.put("glucose",glucose);
                        jsonObject.put("tenYearCHD",tenYearCHD);
                        jsonObject.put("id_ref",id_ref);
                        entity = new StringEntity(jsonObject.toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                    client.post(MainActivity.this, "http://3.143.127.94/storePatient", entity, "application/json", new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            try {
                                JSONObject jsonObject = new JSONObject(new String(responseBody, "UTF-8"));
                                SharedPreferences preferences = getSharedPreferences("register",0);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putInt("ID", jsonObject.getInt("id_ref"));
                                editor.putBoolean("remember",true);
                                editor.putInt("gender",male);
                                editor.putString("Patient_name",jsonObject.getString("name"));
                                editor.putInt("Patient-ID",jsonObject.getInt("patient_id"));
                                editor.putInt("Age",age);
                                editor.apply();
                                validate(jsonObject.getInt("id_ref"),jsonObject.getString("name"));
                                Log.d("Response is -> ",jsonObject.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            try {
                                JSONObject jsonObject = new JSONObject(new String(responseBody, "UTF-8"));
                                Toast.makeText(getApplicationContext(), jsonObject.toString()+"OnFailure", Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }
        });
    }



    public void validate(int id_ref, String name) {
        if (id_ref != 0 && name.length()!=0) {
            Intent intent = new Intent(MainActivity.this, Stats.class);
            startActivity(intent);
        }
    }



    }
