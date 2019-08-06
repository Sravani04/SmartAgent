package com.example.smartagent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartagent.models.demo
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    var demo = ArrayList<demo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        images_videos_list.setHasFixedSize(true)
        images_videos_list.layoutManager = LinearLayoutManager(this)

        getAllImagesandVideos()
    }

    fun getAllImagesandVideos(){
        try {
            var hud = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait").setCancellable(true).setMaxProgress(100).show()
            doAsync {
                var demos = demo()
                demo = demos.getAllImagesandVideos(this@MainActivity)
                println("the demo results are")
                println(demo)

                uiThread {
                    hud.dismiss()
                    images_videos_list.adapter  = MainActivityAdapter(this@MainActivity,demo)
                }
            }
        } catch(err: JSONException){
            println("There is an issue with doing things. Please check")
            println(err);
        }

    }
}
