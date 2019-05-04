package com.taoyimin.eshop.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import com.taoyimin.eshop.R
import com.taoyimin.eshop.bean.Game

/**
 * Created by Tao Yimin on 2019/5/4.
 */
class GameAdapter(
        private val games: MutableList<Game>,
        private val onItemClickListener: AdapterView.OnItemClickListener
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            GameViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_item_game, parent, false))

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        with(holder.itemView) {
            games[position].run {
                holder.titleText.text = title
            }
            setOnClickListener {
                onItemClickListener.onItemClick(null, it, holder.adapterPosition, holder.itemId)
            }
        }
    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.text_title)
    }
}