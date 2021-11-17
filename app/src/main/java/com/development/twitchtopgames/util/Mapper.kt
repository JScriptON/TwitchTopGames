package com.development.twitchtopgames.util

import com.development.twitchtopgames.db.TopWithGame
import com.development.twitchtopgames.db.entity.GameEntity
import com.development.twitchtopgames.model.Box
import com.development.twitchtopgames.model.Game
import com.development.twitchtopgames.model.Top

object Mapper {

    fun gameEntityToModel(gameEntity: GameEntity): Game {
        return Game(gameEntity.id, gameEntity.name, box = Box(gameEntity.logo))
    }

    fun toModel(topWithGame: TopWithGame): Top {
        return Top(
            channels = topWithGame.top.channels,
            viewers = topWithGame.top.viewers,
            game = gameEntityToModel(topWithGame.game)
        )
    }
}