package com.hackathon.adgitm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonalDetailsDoc extends AppCompatActivity {

    private EditText pname;
    private EditText page;
    private EditText phigherEducation;
    private EditText ptimings;
    private EditText pspecialities;
    private EditText phouseNo;
    private EditText ptown;
    private EditText pstate;
    private Button pnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details_doc);

        initView();

        pnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });


    }

    private void submit() {
        String name = pname.getText().toString().trim();
        String age = page.getText().toString().trim();
        String higherEducation = phigherEducation.getText().toString().trim();
        String timings = ptimings.getText().toString().trim();
        String specialities = pspecialities.getText().toString().trim();
        String houseno = phouseNo.getText().toString().trim();
        String town = ptown.getText().toString().trim();
        String state = pstate.getText().toString().trim();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(higherEducation) && !TextUtils.isEmpty(timings) &&
                !TextUtils.isEmpty(specialities) && !TextUtils.isEmpty(houseno) && !TextUtils.isEmpty(town) && !TextUtils.isEmpty(state)){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("name", name);
            editor.putString("age", age);
            editor.putString("higherEducation", higherEducation);
            editor.putString("timings", timings);
            editor.putString("specialities", specialities);
            editor.putString("houseno", houseno);
            editor.putString("town", town);
            editor.putString("state", state);
            editor.putBoolean("isLoggedIn", true);
            editor.apply();
            Intent intent = new Intent(PersonalDetailsDoc.this, HomeActivityDoc.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "All the fields are mandatory!", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        pname = findViewById(R.id.pname);
        page = findViewById(R.id.page);
        phigherEducation = findViewById(R.id.phigheredu);
        ptimings = findViewById(R.id.ptimings);
        pspecialities = findViewById(R.id.pspecialities);
        phouseNo = findViewById(R.id.phouseno);
        ptown = findViewById(R.id.ptown);
        pstate = findViewById(R.id.pstate);
        pnext = findViewById(R.id.pnext);
    }
}
