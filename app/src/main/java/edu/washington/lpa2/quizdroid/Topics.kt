package edu.washington.lpa2.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_topics.*

class Topics : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topics)
        topMath_id.setOnClickListener({v -> loadTopic(v)})
        topPhys_id.setOnClickListener({v -> loadTopic(v)})
        topMarvel_id.setOnClickListener({v -> loadTopic(v)})
    }

    private fun loadTopic(v: View) {
        val i = Intent(this,TopicOverview::class.java)
        when(v.id) {
            R.id.topMath_id -> i.putExtra("topic", "Math")
            R.id.topPhys_id -> i.putExtra("topic", "Physics")
            R.id.topMarvel_id -> i.putExtra("topic", "Marvel")
        }
        startActivity(i)
    }


}
