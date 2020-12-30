package com.example.mycoins.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycoins.database.CoinDatabaseDao
import com.example.mycoins.database.Users.User
import kotlinx.coroutines.*

class LoginViewModel(
    val database: CoinDatabaseDao
) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToOverview = MutableLiveData<Boolean>()
    val navigateToOverview : LiveData<Boolean>
        get() = _navigateToOverview

    private val _email = MutableLiveData<String>()
    val email : LiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String>
        get() = _password

    // Variable to show Toast when loging in
    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackBarEvent : LiveData<Boolean>
        get() = _showSnackbarEvent

    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = false
    }

    fun doneNavigating() {
        _navigateToOverview.value = false
    }


    private fun onLoginClicked(email: String, password: String) {
        var loginUser : User? = null
        uiScope.launch {
             loginUser = database.getUser(email, password)
            if(loginUser != null) {
                _navigateToOverview.value = true
            }
        }
    }

    private suspend fun insert(user: User) {
        withContext(Dispatchers.IO) {
            database.insertUser(user)
        }
    }



    fun onSignUpClicked(email : String, password: String){

    }
}