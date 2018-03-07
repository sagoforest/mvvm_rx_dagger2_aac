package com.sagoforest.template.dataaccess;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by andy on 3/7/18.
 */

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    // Getters and setters are ignored for brevity,
    // but they're required for Room to work.

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

}