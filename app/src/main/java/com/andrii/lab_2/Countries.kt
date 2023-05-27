package com.andrii.lab_2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Countries(var name:String, var image:String, var shortDescription:String, var description:String):
    Parcelable
