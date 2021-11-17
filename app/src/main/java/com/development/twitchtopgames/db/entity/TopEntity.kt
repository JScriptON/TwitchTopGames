package com.development.twitchtopgames.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.development.twitchtopgames.db.entity.TopEntity.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME
)
data class TopEntity(
    var channels: Int,
    var viewers: Int,
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


    companion object {
        const val TABLE_NAME = "tops"
    }
}