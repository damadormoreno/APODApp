package com.deneb.apps.core.extension

import java.text.SimpleDateFormat
import java.util.*



fun Date.formatToSringDate(): String{
    val sdf= SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.format(this)
}

fun Date.threMonthsless(date: Date) : String {
    val c = Calendar.getInstance()
    c.time = date
    c.add(Calendar.MONTH, -3)
    return c.time.formatToSringDate()
}