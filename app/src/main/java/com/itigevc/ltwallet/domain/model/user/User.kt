package com.itigevc.ltwallet.domain.model.user

/*
    Type :
    Author: Giovanni Efrain Villanueva Caballero
    Details:
    Date:
    Glosary:
 */

data class User (

    var name: String = "",
    var userName: String = "",
    var userId: String = "",
    var email: String = "",
    var password: String = "",
    var imageUrl: String = "",

   // var liteTarget: List<String>,
    var infoProfile: String = "",
    var following: List<String> = emptyList(),
    var followers: List<String> = emptyList(),
    var totalPosts: String = "",
    var url: String = ""
)