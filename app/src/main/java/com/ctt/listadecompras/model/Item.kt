package com.ctt.listadecompras.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val nome: String, val qtd: Int) : Parcelable