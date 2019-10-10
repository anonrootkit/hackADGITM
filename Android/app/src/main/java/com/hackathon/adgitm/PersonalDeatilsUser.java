package com.hackathon.adgitm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.adgitm.retrofit.WebApiHelper;

public class PersonalDeatilsUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_deatils_user);

        final TextView tv = findViewById(R.id.editText1);
        Button next = findViewById(R.id.Next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tv.getText().toString();
                if (!TextUtils.isEmpty(name)){
                    WebApiHelper.getInstance().name = name ;
                    Intent intent = new Intent(PersonalDeatilsUser.this, HomeActivityUser.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(PersonalDeatilsUser.this, "Name is mandatory", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
