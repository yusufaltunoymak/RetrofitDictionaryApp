package com.example.dictionaryapp2

import android.telecom.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KelimelerDaoInterface {
    @GET("sozluk/tum_kelimeler.php")
    fun tumKelimeler() : retrofit2.Call<KelimelerResponse>

    @POST("sozluk/kelime_ara.php")
    @FormUrlEncoded
    fun kelimeAra(@Field("ingilizce") ingilizce : String) : retrofit2.Call<KelimelerResponse>
}