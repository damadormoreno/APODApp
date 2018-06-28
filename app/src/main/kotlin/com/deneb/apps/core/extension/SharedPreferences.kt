package com.deneb.apps.core.extension

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "ApodDate"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    fun getPreferences() :SharedPreferences = preferences


    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }
}
