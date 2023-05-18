package com.appninjas.beautysalonprototype.presentation.utils

import android.content.Context

object Toast {
    fun showToast(context: Context, text: String) {
        android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT).show()
    }
}