package com.raspisanie.mai.models.human

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StudentHuman (
        var name: String,
        var location: String,
        var phoneNumber: String

): Parcelable
