package com.tlh.retrofitcik.models

data class UserLogin(
    val username: String,//isimler aynı olsun ki servis bunu dikkate alsın dikkat et o yüzden
    val password: String// yoksa @SerializedName kulllanıp eşlemen gerekir
)
