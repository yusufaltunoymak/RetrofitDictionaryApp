package com.example.dictionaryapp2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KelimelerResponse( @SerializedName("kelimeler")
    @Expose
    var kelimeler: List<Kelimeler>,
    @SerializedName("success")
    @Expose
    var success : Int
) {

}