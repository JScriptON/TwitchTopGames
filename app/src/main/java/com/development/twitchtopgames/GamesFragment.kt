package com.development.twitchtopgames

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GamesFragment : Fragment() {

    private val gamesAdapter = GamesAdapter(listOf())

    companion object {
        fun newInstance() = GamesFragment()
    }

    private lateinit var viewModel: GamesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.games_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GamesViewModel::class.java]

        val gamesRecyclerView = view.findViewById<RecyclerView>(R.id.games_rv)
        gamesRecyclerView.apply {
            adapter = gamesAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }

}