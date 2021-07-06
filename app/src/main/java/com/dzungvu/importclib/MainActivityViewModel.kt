package com.dzungvu.importclib

class MainActivityViewModel {
    init {
        System.loadLibrary("gmath-bridge")
    }

    /**
     * This is the linked function,
     * by using JNI, this function is linked to function in cpp file
     */
    private external fun stringFromJNI(str: String): String

    /**
     * Function called in MainActivity
     */
    fun getStringFromJNI(str: String): String {
        return stringFromJNI(str)
    }
}