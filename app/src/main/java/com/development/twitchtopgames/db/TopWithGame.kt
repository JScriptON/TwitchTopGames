package com.development.twitchtopgames.db

import androidx.room.Embedded
import androidx.room.Relation
import com.development.twitchtopgames.db.entity.GameEntity
import com.development.twitchtopgames.db.entity.TopEntity

class TopWithGame(
    @Embedded
    var top: TopEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "top_id"
    )
    var game: GameEntity

)