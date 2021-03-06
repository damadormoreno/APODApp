package com.deneb.apps.core.extension

import java.text.SimpleDateFormat
import java.util.*



fun Date.formatToSringDate(): String{
    val sdf= SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.format(this)
}

fun Date.oneWeekless() : String {
    val c = Calendar.getInstance()
    c.time = this
    c.add(Calendar.WEEK_OF_MONTH, -1)
    return c.time.formatToSringDate()
}

fun Date.pastTenOclock() : Boolean{
    val c = Calendar.getInstance()
    c.time = this
    val hour = c.get(Calendar.HOUR_OF_DAY)
    return hour > 10
}