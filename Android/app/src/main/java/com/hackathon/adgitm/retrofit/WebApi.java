package com.hackathon.adgitm.retrofit;

import com.hackathon.adgitm.model.Auth;
import com.hackathon.adgitm.model.Search;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebApi {
    @GET("auth.php")
    Call<Auth> getAuth(@Query("id") String id, @Query("uname") String uname, @Query("pwd") String pwd);

    @GET("search.php")
    Call<Search> getSearch();
//    @FormUrlEncoded
//    @POST("get/notes")
//    Call<RootNotes> getNotes(@Field("g_id") String g_id, @Field("subj_id") String subj_id, @Field("subSubj_id") String subSubj_id, @Field("chap_id") String chap_id);

}
