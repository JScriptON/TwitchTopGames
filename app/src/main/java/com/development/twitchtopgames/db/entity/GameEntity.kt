package com.development.twitchtopgames.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.development.twitchtopgames.db.entity.GameEntity.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME, foreignKeys = [ForeignKey(
        entity = TopEntity::class,
        parentColumns = ["id"],
        childColumns = ["top_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class GameEntity(
    @PrimaryKey
    var id: Int,
    var name: String,
    val logo: String,
    @ColumnInfo(name = "top_id")
    val topId: Int = 0
) {
    companion object {
        const val TABLE_NAME = "games"
    }

}