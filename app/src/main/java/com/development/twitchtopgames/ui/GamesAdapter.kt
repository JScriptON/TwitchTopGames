package com.development.twitchtopgames.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.development.twitchtopgames.R
import com.development.twitchtopgames.model.Top
import com.development.twitchtopgames.util.Util

class GamesAdapter(games: List<Top>) : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    private val gameList: MutableList<Top> = games.toMutableList()

    fun setData(games: List<Top>) {
        gameList.addAll(games)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var gameName: TextView? = null
        private var gameViewers: TextView? = null
        private var gameChannels: TextView? = null
        private var gameLogo: ImageView? = null

        init {
            gameName = view.findViewById(R.id.game_name)
            gameViewers = view.findViewById(R.id.game_viewers)
            gameChannels = view.findViewById(R.id.game_channels)
            gameLogo = view.findViewById(R.id.game_logo)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: Top) {
            gameName?.let { it.text = item.game.name }
            gameViewers?.let { it.text = Util.formatStringViewers(item.viewers) }
            gameChannels?.let { it.text = Util.formatStringChannels(item.channels) }
            Glide.with(itemView)
                .load(item.game.box.large)
                .into(gameLogo!!)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_item_rv, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = gameList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }
}


