package com.example.dictionaryapp2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Kelimeler( @SerializedName("kelime_id")
   @Expose
    var kelime_id : Int,
    @SerializedName("ingilizce")
    @Expose
    var ingilizce : String,
    @SerializedName("turkce")
    var turkce : String
    ) : java.io.Serializable {
}