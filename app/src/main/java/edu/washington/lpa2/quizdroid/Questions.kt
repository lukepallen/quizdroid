package edu.washington.lpa2.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_questions.*
import java.util.*

class Questions : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        val topic = intent.getStringExtra("topic")
        val i = Intent(this, Answer::class.java)
        var correct = ""
        when(topic) {
            "Math" -> {
                q_question.text = getString(R.string.q_math_1)
                makeQuestions(getString(R.string.q_math_1_1), getString(R.string.q_math_1_2), getString(R.string.q_math_1_3), getString(R.string.q_math_1_4))
                correct = getString(R.string.q_math_1_4)
                i.putExtra("answer", getString(R.string.q_math_1_4))
            }
            "Physics" -> {
                q_question.text = getString(R.string.q_phys_1)
                makeQuestions(getString(R.string.q_phys_1_1),getString(R.string.q_phys_1_2), getString(R.string.q_phys_1_3), getString(R.string.q_phys_1_4))
                correct = getString(R.string.q_phys_1_3)
                i.putExtra("answer", getString(R.string.q_phys_1_3))
            }
            "Marvel" -> {
                q_question.text = getString(R.string.q_marvel_1)
                makeQuestions(getString(R.string.q_marvel_1_1), getString(R.string.q_marvel_1_2), getString(R.string.q_marvel_1_3), getString(R.string.q_marvel_1_4))
                correct = getString(R.string.q_marvel_1_2)
                i.putExtra("answer", getString(R.string.q_marvel_1_2))
            }
        }
        q_answers.setOnCheckedChangeListener({_, _ -> q_submit.visibility = View.VISIBLE})
        q_submit.setOnClickListener({_ ->
            val id: Int = q_answers.checkedRadioButtonId
            val selected = findViewById<RadioButton>(id)
            if (selected.text.toString() == correct) {
                i.putExtra("correct", true)
            } else {
                i.putExtra("correct", false)
            }
            startActivity(i)
        })

    }

    private fun makeQuestions(a1: String, a2: String, a3: String, a4: String) {
        val questions = arrayOf(a1, a2, a3, a4)
        val rng = Random()

        for (index in 0 until questions.size - 1) {
            val randomIndex = rng.nextInt(questions.size)

            // Swap with the random position
            val temp = questions[index]
            questions[index] = questions[randomIndex]
            questions[randomIndex] = temp
        }
        q_answer1.text = questions[0]
        q_answer2.text = questions[1]
        q_answer3.text = questions[2]
        q_answer4.text = questions[3]
    }
}
