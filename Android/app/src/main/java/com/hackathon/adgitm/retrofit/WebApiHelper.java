package com.hackathon.adgitm.retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackathon.adgitm.model.Auth;
import com.hackathon.adgitm.model.Search;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebApiHelper {
    public static final WebApiHelper ourInstance = new WebApiHelper();
    public String name;

    public static WebApiHelper getInstance() {
        return ourInstance;
    }

    private WebApiHelper() {
    }

    WebApi webApi = null;

    public void init(final Context context) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://fast-reaches-79297.herokuapp.com/")
                .baseUrl("http://192.168.43.196:8080/hack/")
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        webApi = retrofit.create(WebApi.class);
    }

    public void auth(Callback<Auth> responseCallback, String id, String uname, String pwd) {

        if (webApi != null) {
            Call<Auth> call = webApi.getAuth(id, uname, pwd);
            call.enqueue(responseCallback);
        }
    }
    public void getSearch(Callback<Search> responseCallback) {

        if (webApi != null) {
            Call<Search> call = webApi.getSearch();
            call.enqueue(responseCallback);
        }
    }

}
