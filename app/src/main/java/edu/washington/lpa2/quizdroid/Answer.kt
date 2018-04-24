package edu.washington.lpa2.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class Answer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        val correct = intent.getBooleanExtra("correct", true)
        if (correct) {
            a_correct.text = getString(R.string.correct)
            a_right.text = getString(R.string.OneOfOne)
        } else {
            val answer = intent.getStringExtra("answer")
            a_correct.text = getString(R.string.incorrect, answer)
            a_right.text = getString(R.string.ZeroOfOne)
        }
        val i = Intent(this, Topics::class.java)
        a_finish.setOnClickListener({_ -> startActivity(i) })
    }
}
