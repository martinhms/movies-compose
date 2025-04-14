package com.org.marton.studio.project.moviesappcompose

import android.content.Context
import androidx.annotation.StringRes

object ApiKeyHolder {
    private var apiKey: String? = null

    fun initialize(context: Context, @StringRes apiKeyResId: Int) {
        apiKey = context.getString(apiKeyResId)
    }

    fun getApiKey(): String {
        return apiKey ?: throw IllegalStateException("API key not initialized. Call ApiKeyHolder.initialize() in your Application class.")
    }
}