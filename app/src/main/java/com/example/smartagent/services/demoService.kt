package com.example.smartagent.services

import android.content.Context
import com.example.smartagent.Config
import khttp.get
import khttp.post
import org.json.JSONObject

object DemoService{
    fun getVideosandImages(context:Context):JSONObject {
        // Create a Pond. Need to do an api call and then post the response.
        var config = Config.getConfig();

        var url = config.getString("SERVER_URL")
        var demo_response_json = JSONObject()
        url = url
        println("the demo url is::"+url)

        var response = get(url)
        println("The GET request is done and the repsponse is")
        demo_response_json = response.jsonObject

        println(demo_response_json.toString())
        return demo_response_json
    }
}