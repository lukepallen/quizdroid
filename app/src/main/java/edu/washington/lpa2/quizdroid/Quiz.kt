package edu.washington.lpa2.quizdroid

//import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
//import android.support.v4.app.FragmentTransaction

class Quiz : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val topic = intent.getStringExtra("topic")
        val to = TopicOverviewFrag.newInstance(topic)
        val trans: FragmentManager = supportFragmentManager
        trans.beginTransaction().add(R.id.quiz_layout, to, "Overview").commit()
//        supportFragmentManager.inTransaction { add(R.id.quiz_layout, TestFragment.newInstance()) }
    }
//        inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
//            val fragmentTransaction = beginTransaction()
//            fragmentTransaction.func()
//            fragmentTransaction.commit()
//        }
}
