package com.lm.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class User (
    val id: Int,
    val name: String,
    val email: String
) : Parcelable

