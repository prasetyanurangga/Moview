package com.prasetyanurangga.moview.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prasetyanurangga.moview.R
import com.prasetyanurangga.moview.data.model.MovieModel
import com.prasetyanurangga.moview.ui.view.DetailMoviewActivity

class MovieAdapter (
    val context: Context,
    val items: List<MovieModel>) : RecyclerView.Adapter<MovieAdapter.movieViewHolder>(){


    class movieViewHolder(view:View) : RecyclerView.ViewHolder(view){

        private  val imgMoview: ImageView = view.findViewById(R.id.img_moview)
        private val nameMoview: TextView = view.findViewById(R.id.txt_name_moview)
        private val overviewMoview: TextView = view.findViewById(R.id.txt_overview_moview)

        fun bindItem(items: MovieModel){
            nameMoview.text = items.title
            overviewMoview.text = items.overview.substring(0,100)+"..."
            imgMoview.setImageResource(items.image)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieViewHolder {
        return movieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_moview, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: movieViewHolder, position: Int) {
        holder.bindItem(items[position])
        holder.itemView.setOnClickListener { view ->
            val intent: Intent = Intent(context, DetailMoviewActivity::class.java)
            intent.putExtra("idMoview", items[position].id)
            intent.putExtra("typeMoview", "movie")
            context.startActivity(intent)

        }
    }
}