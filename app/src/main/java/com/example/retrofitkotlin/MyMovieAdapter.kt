package com.example.retrofitkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlin.model.Item
import com.example.retrofitkotlin.model.MainModel

import com.squareup.picasso.Picasso

class MyMovieAdapter(private val context: Context,private val myList: MutableList<Item>)
    :RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.image_movie)
        val txt_name: TextView = itemView.findViewById(R.id.txt_name)
        val txt_team: TextView = itemView.findViewById(R.id.txt_team)
        val txt_createdby: TextView = itemView.findViewById(R.id.txt_createdby)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = myList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = myList[position]

        /*Picasso.get().load(movieList[position].imageurl).into(holder.image)
        holder.txt_name.text = movieList[position].name
        holder.txt_team.text = movieList[position].team
        holder.txt_createdby.text = movieList[position].createdby*/
        holder.txt_name.text = listItem?.volumeInfo?.title
        holder.txt_team.text = listItem?.volumeInfo?.authors?.get(0)?.toString()
        holder.txt_createdby.text = listItem?.volumeInfo?.pageCount?.toString()
       // holder.year.text = listItem?.volumeInfo?.publishedDate

       // if (listItem?.volumeInfo?.averageRating?.toInt() == 0) holder.rating.text = "N/A"
      //  else holder.rating.text = listItem?.volumeInfo?.averageRating.toString()


        Picasso.get().load(listItem?.volumeInfo?.imageLinks?.thumbnail).into(holder.image)

    }

}
