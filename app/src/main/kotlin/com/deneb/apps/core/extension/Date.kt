package com.deneb.apps.core.extension

import java.text.SimpleDateFormat
import java.util.*



fun Date.formatToSringDate(): String{
    val sdf= SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.format(this)
}

fun Date.oneMonthless() : String {
    val c = Calendar.getInstance()
    c.time = this
    c.add(Calendar.MONTH, -1)
    return c.time.formatToSringDate()
}