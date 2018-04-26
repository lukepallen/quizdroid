package edu.washington.lpa2.quizdroid

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_answer.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "correct"
private const val ARG_PARAM2 = "answer"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AnswerFrag.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AnswerFrag.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AnswerFrag : Fragment() {
    // TODO: Rename and change types of parameters
    private var correct: String = ""
    private var answer: String = ""
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            correct = it.getString(ARG_PARAM1)
            answer = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_answer, container, false)
        updateUI(v)
        return v
    }

    private fun updateUI(v: View) {
        if (correct == "true") {
            v.findViewById<TextView>(R.id.a_correct).text = getString(R.string.correct)
            v.findViewById<TextView>(R.id.a_right).text = getString(R.string.OneOfOne)
        } else {
            v.findViewById<TextView>(R.id.a_correct).text = getString(R.string.incorrect, answer)
            v.findViewById<TextView>(R.id.a_right).text = getString(R.string.ZeroOfOne)
        }
        val i = Intent(activity, Topics::class.java)
        v.findViewById<Button>(R.id.a_finish).setOnClickListener({_ -> startActivity(i)})
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
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
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AnswerFrag.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(correct: String, answer: String) =
                AnswerFrag().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, correct)
                        putString(ARG_PARAM2, answer)
                    }
                }
    }
}
