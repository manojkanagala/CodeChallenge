package com.manukanagala.mvvmexample

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import java.io.Closeable

data class PhoneModel(val id: Int,
                      val title: String,
                      val description: String,
                      val price: Int,
                      val discountPercentage: Double,
                      val rating: Float,
                      val stock: Int,
                      val brand: String,
                      val category: String,
                      val thumbnail: String,
                      val images: Array<String>
                     ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArray() as Array<String>
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeInt(price)
        parcel.writeDouble(discountPercentage)
        parcel.writeFloat(rating)
        parcel.writeInt(stock)
        parcel.writeString(brand)
        parcel.writeString(category)
        parcel.writeString(thumbnail)
        parcel.writeStringArray(images)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhoneModel> {
        override fun createFromParcel(parcel: Parcel): PhoneModel {
            return PhoneModel(parcel)
        }

        override fun newArray(size: Int): Array<PhoneModel?> {
            return arrayOfNulls(size)
        }
    }
}
