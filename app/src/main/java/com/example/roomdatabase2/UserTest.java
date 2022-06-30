package com.example.roomdatabase2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = User.class,
        parentColumns = "uid", //test_nummer
        childColumns = "testNummer", //test_nummer
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE)}//,
        //indices = {@Index(value = {"test_nummer"},unique = true)}
)
public class UserTest {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    //@ColumnInfo(name = "test_name")
    //public String testName;

    @ColumnInfo (index = true)  //(name = "test_nummer")
    public int testNummer;

    

}
