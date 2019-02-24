package com.example.mblock.initiativesorter

import android.os.Parcel
import android.os.Parcelable

class Character(var character: String, var initiative: String) : Comparable<Character>, Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun compareTo(other: Character): Int {
        return if (this.initiative.isNotEmpty() && other.initiative.isNotEmpty())
            0 - this.initiative.toInt().compareTo(other.initiative.toInt())
        else if (this.initiative.isNotEmpty())
            -1
        else if (other.initiative.isNotEmpty())
            1
        else
            0
    }

    override fun toString(): String {
        return "$character $initiative\n"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(character)
        parcel.writeString(initiative)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}