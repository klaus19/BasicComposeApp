package com.example.basiccomposeapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "saved_cards")
data class SavedCard(
      @PrimaryKey(autoGenerate = true)
      val id:Long=0,
      val imageName:String,
      val imageId:Int
)
