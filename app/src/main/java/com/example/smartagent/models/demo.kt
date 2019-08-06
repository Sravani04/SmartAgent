package com.example.smartagent.models

import android.content.Context
import com.example.smartagent.services.DemoService
import java.io.Serializable

class demo:Serializable{

//Class Starts
    open var id:Long=0
    open var name:String = ""
    open var type:String=""
    open var sizeInBytes:String=""
    open var cdnpath:String=""

    constructor(
        id:Long = 0,
        name:String="",
        type:String="",
        sizeInBytes:String="",
        cdnpath:String=""
    ){
        //Constructor Starts

        this.id = id
        this.name = name
        this.type = type
        this.sizeInBytes = sizeInBytes
        this.cdnpath = cdnpath
    }

    fun getAllImagesandVideos(context:Context):ArrayList<demo>{
        var demo = arrayListOf<demo>()

        var demo_api_response = DemoService.getVideosandImages(context)

            // Time to fetch the array and create the object.
            var dependencies_array = demo_api_response.getJSONArray("dependencies")

            demo.clear()

            var demos : demo;
            for (i in 0 until dependencies_array.length()){
                var dependencies_object = dependencies_array.getJSONObject(i)
                demos = demo(
                    id = dependencies_object.getLong("id"),
                    name = dependencies_object.getString("name"),
                    type = dependencies_object.getString("type"),
                    sizeInBytes = dependencies_object.getString("sizeInBytes"),
                    cdnpath = dependencies_object.getString("cdn_path")


                )

                demo.add(demos)

        }

        return demo
    }
}