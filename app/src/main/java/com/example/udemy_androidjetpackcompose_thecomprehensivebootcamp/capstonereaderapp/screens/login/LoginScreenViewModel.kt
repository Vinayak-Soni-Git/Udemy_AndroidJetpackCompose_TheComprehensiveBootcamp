package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.model.MUser
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow

class LoginScreenViewModel : ViewModel() {
    val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = Firebase.auth

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun createUserWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val displayName = task.result.user?.email?.split('@')?.get(0)
                        createUser(displayName)
                        home()
                    } else {

                    }
                    _loading.value = false
                }
        }
    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
        val user = MUser(
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            quote = "life is great",
            profession = "Android Developer",
            id = null
        ).toMap()

        FirebaseFirestore.getInstance().collection("users").add(user)
    }

    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        try {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    home()
                } else {

                }
            }
        } catch (e: Exception) {

        }
    }
}