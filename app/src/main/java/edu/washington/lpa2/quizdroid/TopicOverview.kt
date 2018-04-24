package edu.washington.lpa2.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_topic_overview.*

class TopicOverview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)
        val topic = intent.getStringExtra("topic")
        val i = Intent(this,Questions::class.java)
        when(topic) {
            "Math" -> {
                ov_header.text = getString(R.string.topic_math)
                ov_body.text = getString(R.string.ov_math)
                i.putExtra("topic", "Math")
            }
            "Physics" -> {
                ov_header.text = getString(R.string.topic_physics)
                ov_body.text = getString(R.string.ov_physics)
                i.putExtra("topic", "Physics")
            }
            "Marvel" -> {
                ov_header.text = getString(R.string.topic_marvel)
                ov_body.text = getString(R.string.ov_marvel)
                i.putExtra("topic", "Marvel")
            }
        }
        ov_begin.setOnClickListener({ startActivity(i) })
    }
}
