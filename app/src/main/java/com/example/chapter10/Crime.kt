package com.example.chapter10

import java.util.Date
import java.util.UUID

data class Crime(
    val id:UUID,
    var title:String,
    val date:Date,
    var isSolved:Boolean,
    var requiresPolice: Boolean = false // EX.2 new prop
)