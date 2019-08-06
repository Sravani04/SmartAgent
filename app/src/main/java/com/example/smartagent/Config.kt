package com.example.smartagent

import org.json.JSONObject

object Config {

    fun getConfig(): JSONObject {
        var environment = "fetch_config"
        var final_url  = hashMapOf("fetch_config" to "https://demo6977317.mockable.io/fetch_config")
        var config = JSONObject();

        config.put("shared_pref_file_name", "com.example.app.functionality")
        config.put("SERVER_URL",final_url[environment])

        return config
    }
}