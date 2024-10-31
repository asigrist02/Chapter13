package com.example.criminalintent

import java.util.Date
import java.util.UUID

class Crime(
    val id:UUID,
    val title:String,
    val date:Date,
    val isSolved:Boolean
)