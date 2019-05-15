package com.taoyimin.eshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taoyimin.eshop.R
import com.taoyimin.eshop.bean.Game
import com.taoyimin.eshop.i.OnItemClickListener
import com.taoyimin.eshop.i.OnItemLongClickListener
import kotlinx.android.synthetic.main.adapter_item_game.view.*

/**
 * Created by Tao Yimin on 2019/5/4.
 */
class GameAdapter(private var games: ArrayList<Game>)
    : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    private var onItemClickListener: OnItemClickListener<Game>? = null
    private var onItemLongClickListener: OnItemLongClickListener<Game>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_game, parent, false))

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        with(holder.itemView) {
            games[position].run {
                holder.titleText.text = title
            }
            onItemClickListener?.let {
                this.setOnClickListener { onItemClickListener!!.onItemClick(games[position], position) }
            }
            onItemLongClickListener?.let {
                this.setOnLongClickListener { onItemLongClickListener!!.onItemLongClick(games[position], position) }
            }
        }

    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.text_title
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<Game>) {
        this.onItemClickListener = onItemClickListener
    }

    /*fun setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener<Game>){
        this.onItemLongClickListener = onItemLongClickListener
    }*/
}