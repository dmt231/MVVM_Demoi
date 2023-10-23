package com.example.mvvm.model

class User : java.io.Serializable {
    private var userId : Long? = 0
    private var username : String? = null
    private var password : String? = null
    private var email : String?  = null
    private var image : String? = null
    private var token : String? = null
    fun getUserId() : Long{
        return userId!!
    }
    fun getUsername() : String {
        return username !!
    }
    fun getPassword() : String {
        return password!!
    }
    fun getEmail() : String {
        return email!!
    }
    fun getImage() : String {
        return image!!
    }
    //Setter
    fun setUserId(id : Long){
        this.userId = id
    }
    fun setUsername(username : String){
        this.username = username
    }

    fun setEmail(email : String) {
        this.email = email
    }
    fun setToken(token : String){
        this.token = token
    }

    fun getToken() : String {
        return token!!
    }
    constructor(id : Long, username : String, password : String, email : String, image : String, token : String){
        this.userId = id
        this.username = username
        this.password = password
        this.email = email
        this.image = image
        this.token = token
    }

    constructor(userId: Long, username: String, email: String, image: String) {
        this.userId = userId
        this.username = username
        this.email = email
        this.image = image
    }
    constructor(userId: Long, username: String,image: String){
        this.userId = userId
        this.username = username
        this.image = image
    }
    constructor()
}