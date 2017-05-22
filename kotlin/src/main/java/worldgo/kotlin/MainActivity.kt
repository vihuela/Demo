package worldgo.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.findOptional
import worldgo.kotlin.basic.Event
import worldgo.kotlin.basic.listener.CustomerView
import worldgo.kotlin.delegate.Bird_crow
import worldgo.kotlin.delegate.CanFly
import worldgo.kotlin.interfaces.Bat
import worldgo.kotlin.interfaces.Bird
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tv: View? = findOptional(R.id.tv)
        tv?.setOnClickListener { demo7() }

    }


    //基础语法
    fun demo1() {
        var quantity = 5
        val price = 20.3
        val name: String = "大米"

        println("单价:$price")
        println("数量:$quantity")
        println("产品:$name 总计:${quantity * price}")
    }

    //when（switch case）
    fun demo2() {
        val x: Int = 15
        val s: List<String> = Collections.EMPTY_LIST as List<String>
        val v: View = LinearLayout(this)
        val res = when {
            x in 1..10 -> "cheap"
            s.contains("hello") -> "it's a welcome!"
            v is ViewGroup -> "child count: ${v.getChildCount()}"
            else -> ""
        }
        println(res)
    }

    //for
    fun demo3( x:Int,y :Int) {

    }

    //range
    fun demo4() {
//        for (i in 1..4 step 2) println(i)
//        for (i in 4 downTo  1) println(i)

//        for (i in 0 until 4) println(i)

        //
        val contain: ViewGroup = LinearLayout(this)
        contain.addView(TextView(this))
        val views = (0..contain.childCount - 1).map { contain.getChildAt(it) }
    }
    //interface
    fun demo5(){
        Bat().fly()
        Bird().fly()
    }
    //delegate
    fun demo6(){
        val bird  = worldgo.kotlin.delegate.Bird(Bird_crow())
//        val bird : CanFly = Bird_crow()
        bird.fly()
    }
    //event
    fun demo7(){
        Event().setOnClickListener(CustomerView(),null)
    }

}
