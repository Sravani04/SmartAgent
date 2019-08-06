package com.example.smartagent

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.smartagent.models.demo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_items.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.json.JSONObject

class MainActivityAdapter(
    var context: Context,
    var demolist: ArrayList<demo>
) : RecyclerView.Adapter<MainActivityAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_main_items,parent,false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.e("coming","coming or not")
        holder.bind(position)

    }

    override fun getItemCount(): Int {
        return demolist.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            itemView.title.text = demolist.get(position).name
            itemView.bytes.text = demolist[position].sizeInBytes
            if (demolist[position].type.equals("IMAGE")){
                Picasso.with(context).load(demolist[position].cdnpath).placeholder(R.drawable.placeholder)
                    .into(itemView.image)
            }else if (demolist[position].type.equals("VIDEO")){

            }



        }
    }
    }
