package com.hackathon.adgitm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.adgitm.model.Auth;
import com.hackathon.adgitm.retrofit.WebApiHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private TextView changeToDoc;
    private Button docProceed;
    private EditText docUname;
    private EditText docPwd;


    private TextView changeToUser;
    private Button userProceed;
    private EditText userUname;
    private EditText userPwd;

    private String uname;
    private String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn){
            String type = preferences.getString("type", "user");
            if (type.equals("doc")){
                Intent intent = new Intent(MainActivity.this, HomeActivityDoc.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }else {
                Intent intent = new Intent(MainActivity.this, HomeActivityUser.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }else {
            setContentView(R.layout.doc_layout);
            WebApiHelper.getInstance().init(getApplicationContext());
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            initDocView();
        }
    }

    public void initDocView(){
        changeToDoc = findViewById(R.id.doc_change);
        docProceed = findViewById(R.id.doc_proceed);
        docUname = findViewById(R.id.doc_uname);
        docPwd = findViewById(R.id.doc_pwd);


        changeToDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.user_layout);
                initUserView();
                overridePendingTransition( R.anim.slide_in, R.anim.slide_out);
            }
        });

        docProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "doc";
                String uname = docUname.getText().toString();
                String upwd = docPwd.getText().toString();
                proceedAuth(uname, upwd, id);
            }
        });

    }

    public void initUserView(){
        changeToUser = findViewById(R.id.user_change);
        userProceed = findViewById(R.id.user_proceed);
        userUname = findViewById(R.id.user_uname);
        userPwd = findViewById(R.id.user_pwd);


        changeToUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.doc_layout);
                initDocView();
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        userProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "user";
                String uname = userUname.getText().toString();
                String upwd = userPwd.getText().toString();
                proceedAuth(uname, upwd, id);
            }
        });
    }

    public void proceedAuth(final String uname, String upwd, final String id){

        if (!TextUtils.isEmpty(uname.trim()) && !TextUtils.isEmpty(upwd.trim())){
            if (upwd.length() >= 8){
                WebApiHelper.getInstance().auth(new Callback<Auth>() {
                    @Override
                    public void onResponse(Call<Auth> call, Response<Auth> response) {
                        Auth auth = response.body();
                        if (auth.getStatus() == 0){
                            WebApiHelper.getInstance().name = uname;
                            proceed(id,auth.getId());
                        }else {
                            Toast.makeText(MainActivity.this, auth.getErr(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Auth> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Some Error occurred!", Toast.LENGTH_SHORT).show();
                    }
                },id, uname, upwd);
            }else {
                Toast.makeText(this, "Invalid Password Length", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void proceed(String id, int status){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        if (id.equals("doc")){
            Intent intent;
            if (status == 0){
                editor.putBoolean("isLoggedIn", true);
                intent = new Intent(MainActivity.this, HomeActivityDoc.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }else{
                intent = new Intent(MainActivity.this, PersonalDetailsDoc.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
            editor.putString("type", "doc");
            editor.apply();
            startActivity(intent);
            finish();
        }else {
            Intent intent;
            if (status == 0){
                editor.putBoolean("isLoggedIn", true);
                intent = new Intent(MainActivity.this, HomeActivityUser.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }else {
                intent = new Intent(MainActivity.this, PersonalDeatilsUser.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
            editor.putString("type", "user");
            editor.apply();
            startActivity(intent);
            finish();
        }
    }
}
