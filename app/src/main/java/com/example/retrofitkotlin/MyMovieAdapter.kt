package com.example.retrofitkotlin

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitkotlin.model.MainModel

class MyMovieAdapter(private val context: Context, private val model: MainModel)
    :RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {
    var myList = model.items

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.book_cover)
        val txt_name: TextView = itemView.findViewById(R.id.title)
        val txt_author: TextView = itemView.findViewById(R.id.author_name)
        val txt_date: TextView = itemView.findViewById(R.id.publication_date)
        val txt_pages: TextView = itemView.findViewById(R.id.pages_count)
        val txt_rating :TextView = itemView.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = myList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = myList[position]

        holder.txt_name.text = listItem?.volumeInfo?.title
        holder.txt_author.text = listItem?.volumeInfo?.authors?.get(0)?.toString()
        holder.txt_pages.text = listItem?.volumeInfo?.pageCount?.toString() +" pages"
        holder.txt_date.text = listItem?.volumeInfo?.publishedDate
        holder.txt_rating.text = listItem?.volumeInfo?.averageRating.toString()


        var imageUrl: String = listItem?.volumeInfo?.imageLinks?.thumbnail.replace("http", "https")

        Glide.with(context).load(imageUrl)
                .placeholder(R.drawable.googlebook_icon)
                .into(holder.image)
        holder.itemView.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(listItem?.volumeInfo?.previewLink))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent)
        }


        //Picasso.get().load(listItem?.volumeInfo?.imageLinks?.thumbnail).into(holder.image)

    }

}
