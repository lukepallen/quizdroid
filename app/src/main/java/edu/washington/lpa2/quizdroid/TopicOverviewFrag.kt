package edu.washington.lpa2.quizdroid

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_topic_overview.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [TopicOverviewFrag.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TopicOverviewFrag : Fragment() {
    private var topic: String = ""
//    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            topic = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_topic_overview, container, false)
        updateUI(v)
        return v
    }

    private fun updateUI(v: View) {
        when (topic) {
            "Math" -> {
                v.findViewById<TextView>(R.id.ov_header).text = getString(R.string.topic_math)
                v.findViewById<TextView>(R.id.ov_body).text = getString(R.string.ov_math)
            }
            "Physics" -> {
                v.findViewById<TextView>(R.id.ov_header).text = getString(R.string.topic_physics)
                v.findViewById<TextView>(R.id.ov_body).text = getString(R.string.ov_physics)
            }
            "Marvel" -> {
                v.findViewById<TextView>(R.id.ov_header).text = getString(R.string.topic_marvel)
                v.findViewById<TextView>(R.id.ov_body).text = getString(R.string.ov_marvel)
            }
        }
        v.findViewById<Button>(R.id.ov_begin).setOnClickListener({ _ -> activity!!.supportFragmentManager.beginTransaction().replace(R.id.quiz_layout, QuestionsFrag.newInstance(topic)).commit()})
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
//        listener = null
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
//    interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onFragmentInteraction(uri: Uri)
//    }

    companion object Overview {
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
