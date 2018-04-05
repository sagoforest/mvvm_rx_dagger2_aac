package com.sagoforest.template.da.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Data;
import lombok.NonNull;

/**
 * Created by andy on 3/7/18.
 */

@Data
@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    private int mId;

    @ColumnInfo(name = "first_name")
    private String mFirstName;

    @ColumnInfo(name = "last_name")
    private String mLastName;

    public User(@NonNull String firstName, @NonNull String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}