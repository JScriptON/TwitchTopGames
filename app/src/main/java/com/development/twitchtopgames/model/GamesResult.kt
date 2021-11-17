package com.development.twitchtopgames.model

data class GamesResult(
    val tops: List<Top>,
    val isSuccessful: Boolean,
    val error: String?
) {
}