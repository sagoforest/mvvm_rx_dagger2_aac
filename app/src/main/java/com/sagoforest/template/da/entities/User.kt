package com.sagoforest.template.da.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by andy on 3/7/18.
 */

@Entity(tableName = "users")
data class User(
        @ColumnInfo(name = "first_name")
        var firstName: String,
        @ColumnInfo(name = "last_name")
        var lastName: String) {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

