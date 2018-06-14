package com.deneb.apps.features.apods

import com.deneb.apps.core.extension.empty

data class ApodEntity(
        val copyright: String?,
        val date: String,
        val explanation: String?,
        val hdurl: String?,
        val media_type: String?,
        val service_version: String?,
        val title: String?,
        val url: String
) {
    companion object {
        fun empty() = ApodEntity(String.empty(),String.empty(),String.empty(),
                String.empty(),String.empty(),String.empty(),String.empty(),
                String.empty())
    }
    fun toApod() = Apod(copyright, date, explanation, hdurl, media_type, service_version, title, url)
}