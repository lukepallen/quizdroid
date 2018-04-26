package edu.washington.lpa2.quizdroid

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.fragment_questions.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "topic"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [QuestionsFrag.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [QuestionsFrag.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class QuestionsFrag : Fragment() {
    // TODO: Rename and change types of parameters
    private var topic: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            topic = it.getString(ARG_PARAM1)
        }

//        q_submit.setOnClickListener({_ ->
//            val id: Int = q_answers.checkedRadioButtonId
//            val selected = findViewById<RadioButton>(id)
//            if (selected.text.toString() == correct) {
//                i.putExtra("correct", true)
//            } else {
//                i.putExtra("correct", false)
//            }
//            startActivity(i)
//        })
    }

    private fun makeQuestions(v: View, a1: String, a2: String, a3: String, a4: String) {
        val questions = arrayOf(a1, a2, a3, a4)
        val rng = Random()

        for (index in 0 until questions.size - 1) {
            val randomIndex = rng.nextInt(questions.size)

            // Swap with the random position
            val temp = questions[index]
            questions[index] = questions[randomIndex]
            questions[randomIndex] = temp
        }
        v.findViewById<RadioButton>(R.id.q_answer1).text = questions[0]
        v.findViewById<RadioButton>(R.id.q_answer2).text = questions[1]
        v.findViewById<RadioButton>(R.id.q_answer3).text = questions[2]
        v.findViewById<RadioButton>(R.id.q_answer4).text = questions[3]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_topic_overview, container, false)
        updateUI(v)
        return v
    }

    private fun updateUI(v: View) {
        var correct = ""
        var answer = ""
        when(topic) {
            "Math" -> {
                v.findViewById<TextView>(R.id.q_question).text = getString(R.string.q_math_1)
                makeQuestions(v, getString(R.string.q_math_1_1), getString(R.string.q_math_1_2), getString(R.string.q_math_1_3), getString(R.string.q_math_1_4))
                correct = getString(R.string.q_math_1_4)
                answer = getString(R.string.q_math_1_4)
            }
            "Physics" -> {
                v.findViewById<TextView>(R.id.q_question).text = getString(R.string.q_phys_1)
                makeQuestions(v, getString(R.string.q_phys_1_1),getString(R.string.q_phys_1_2), getString(R.string.q_phys_1_3), getString(R.string.q_phys_1_4))
                correct = getString(R.string.q_phys_1_3)
                answer = getString(R.string.q_phys_1_3)
            }
            "Marvel" -> {
                v.findViewById<TextView>(R.id.q_question).text = getString(R.string.q_marvel_1)
                makeQuestions(v, getString(R.string.q_marvel_1_1), getString(R.string.q_marvel_1_2), getString(R.string.q_marvel_1_3), getString(R.string.q_marvel_1_4))
                correct = getString(R.string.q_marvel_1_2)
                answer = getString(R.string.q_marvel_1_2)
            }
        }
        v.findViewById<RadioGroup>(R.id.q_answers).setOnCheckedChangeListener({_, _ -> v.findViewById<Button>(R.id.q_submit).visibility = View.VISIBLE})
        v.findViewById<Button>(R.id.q_submit).setOnClickListener({ _ -> activity!!.supportFragmentManager.beginTransaction().replace(R.id.quiz_layout, AnswerFrag.newInstance(correct, answer)).commit()})

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */

    companion object Overview{
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment TopicOverviewFrag.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(topic: String) =
                TopicOverviewFrag().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, topic)
                    }
                }
    }
}