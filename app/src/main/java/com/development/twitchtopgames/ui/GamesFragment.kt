package com.development.twitchtopgames.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.development.twitchtopgames.R
import com.development.twitchtopgames.component

class GamesFragment : Fragment() {

    private val gamesAdapter = GamesAdapter(listOf())

    private val viewModel: GamesViewModel by viewModels { requireActivity().applicationContext.component.getViewModelFactory() }

    companion object {
        fun newInstance() = GamesFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.games_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gamesRecyclerView = view.findViewById<RecyclerView>(R.id.games_rv)
        gamesRecyclerView.apply {
            adapter = gamesAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    val lastVisibleItemPosition =
                        (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                    val totalItemCount = (layoutManager as LinearLayoutManager).itemCount
                    if (lastVisibleItemPosition + 1 == totalItemCount) {
                        viewModel.loadTopGames()
                    }
                }
            })
        }

        viewModel.getGames().observe(viewLifecycleOwner, { it ->
            gamesAdapter.setData(it)
            Toast.makeText(activity, "Данные обновлены", Toast.LENGTH_LONG).show()
        })

    }

}