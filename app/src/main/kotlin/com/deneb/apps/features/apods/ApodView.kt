package com.deneb.apps.features.apods

data class ApodView(val date: String,
                    val url: String,
                    val title: String?,
                    val description: String?,
                    val media_type: String?)