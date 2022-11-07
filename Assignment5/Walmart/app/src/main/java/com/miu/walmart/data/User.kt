package com.miu.walmart.data

import java.io.Serializable

data class User(var firstName: String?,var lastName: String?,var emailID: String?,var password: String?) :
    Serializable{
        override fun toString(): String {
            return "UserAccount(firstName = $firstName, lastName = $lastName, emailID = $emailID, password =$password)"
        }
    }

