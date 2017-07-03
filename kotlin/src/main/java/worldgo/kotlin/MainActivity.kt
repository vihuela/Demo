package worldgo.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.findOptional
import worldgo.kotlin.`object`.ObjectClz
import worldgo.kotlin.`object`.SingleTon
import worldgo.kotlin.basic.DataClz_Person
import worldgo.kotlin.basic.Event
import worldgo.kotlin.basic.WithTestClass
import worldgo.kotlin.basic.listener.CustomerView
import worldgo.kotlin.delegate.Bird_crow
import worldgo.kotlin.delegate.properties.Preference
import worldgo.kotlin.expand.swap
import worldgo.kotlin.generics.Source1
import worldgo.kotlin.generics.Source2
import worldgo.kotlin.inherit.Leader
import worldgo.kotlin.interfaces.Bat
import worldgo.kotlin.interfaces.Bird
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tv: View? = findOptional(R.id.tv)
//        demo9(tv)
        tv?.setOnClickListener { demo30() }

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

    //字符模板
    fun demo11() {
        val a: String = "one"
        val b: String = "${a.replace("one", "two")} five zero"
        println(b)

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

    //when
    fun describe(obj: Any): String =
            when (obj) {
                1, 2 -> "One"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }

    //for
    fun demo3() {
        val items = listOf("apple", "huangGua", "banana")
        for (item in items)
            println(item)
        for (index in items.indices)
            println(index)
        val items_map = mutableMapOf(Pair(1, "two"), Pair(3, 4))//可写map、mapOf可读map
        items_map[1] = "asa"
        for ((k, v) in items_map)
            println("k:$k v:$v")
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
    fun demo5() {
        Bat().fly()
        Bird().fly()
    }

    //delegate
    fun demo6() {
        val bird = worldgo.kotlin.delegate.Bird(Bird_crow())
//        val bird : CanFly = Bird_crow()
        bird.fly()
    }

    //event
    fun demo7() {
        Event().setOnClickListener(CustomerView(), null)
    }

    //list
    fun demo8() {
        val letter = mutableListOf("a1", "b2", "c3", "a2", "a3", "b3")
        //before
        for ((index, item) in letter.withIndex())
            println("$index $item")
        //after
        println("+++++++")
        letter.filter { it.startsWith("a") }
                .map { it.toUpperCase() }
                .forEach { println(it) }

    }

    //lambda
    fun demo9(root: View?) {
        root?.tag = "lambda"
        if (root != null)
            lambdaInvoke(root, { println(it.tag) })
    }

    private fun lambdaInvoke(v: View, event: (v: View) -> Unit) {
        v.setOnClickListener(event)
    }

    //带接收者的函数字面值
    fun demo10() {
//        val sum :Int = 0
//        sum : Int.(other: Int) -> Int
    }

    //扩展函数、扩展属性
    fun demo12() {
        //引用内部
        "one".spaceToCamelCase()
        //引用外部
        val letter = mutableListOf("a1", "b2", "c3", "a2", "a3", "b3")
        letter.swap(0, 1)
    }

    private fun String.spaceToCamelCase() {
        println(this.toString())
    }

    //单例
    object Resource {
        val name = "Name"
    }

    //if none
    fun demo13() {
        val items_map = mapOf(Pair(1, "one"))

//        val v = items_map[0]?.spaceToCamelCase() ?: "empty"
//        val v = items_map[0]?.spaceToCamelCase() ?: throw IllegalAccessException("no fucking val")
        items_map[0]?.let {
            println(it)
        }
    }

    //with，调用一个对象的多个方法
    fun demo14() {
        val withTestClz = WithTestClass()
        with(withTestClz) {
            fun1()
            fun2()
            fun3()
            fun4()
        }
    }

    //数组、String
    fun demo15() {
        //array
        /*val intArr = intArrayOf(1, 2, 3)
        intArr[0] = 5
        intArr.forEachIndexed { index, i ->
            run {
                println("$index $i")
            }
        }*/
        //string
        val text = """
            |Tell me and I forget.
            |Teach me and I remember.
            |Involve me and I learn.
            |(Benjamin Franklin)
            """.trimMargin(">")
        println(text)

    }

    //标签
    fun demo16() {
        labelFun()
    }

    private fun labelFun() {
        val arr = listOf(0, 1, 2, 3)
        arr.forEach {
            if (it == 0) return@forEach//仅return
            Log.d(javaClass.simpleName, it.toString())
        }
        Log.d(javaClass.simpleName, "labelFun end")
    }

    private fun lableAnonymousFun() {
        val arr = listOf(0, 1, 2, 3)
        arr.forEach(fun(it: Int) {
            if (it == 0) return//return 没有跟标签即表示return匿名内部类
            Log.d(javaClass.simpleName, it.toString())
        })
    }

    //类继承
    fun demo17() {
        val leader = Leader("ricky")
        leader.print()
    }

    //属性
    fun demo18() {
        val pro = worldgo.kotlin.basic.Properties()
        pro.d = "sds"
        print(pro.d)

    }

    //解构赋值，需要data class
    fun demo19() {
        val dl = DataClz_Person("ricky", 25)
        val (name, age) = dl.copy("lomoliger")
        println("name:$name age:$age")

    }

    //泛型
    fun demo20(source: Source1<Int>) {
        val objs: Source1<Any> = source
    }

    //泛型
    fun demo21(source: Source2<Any>) {
        val objs: Source2<Int> = source
    }

    //泛型
    fun demo22(dest: Array<in String>, value: String) {
        // ……
    }

    //泛型
    fun demo23(dest: Array<in String>, value: String) {
        // ……
    }

    //对象
    fun demo24() {
        val objectClz = ObjectClz()
        ObjectClz.create()//使用伴生对象
        //单例
        SingleTon.f
    }

    //== 、===
    fun demo25() {
        val a = ObjectClz()
        val b = ObjectClz()
        val c = a
        println(a.equals(b))//结构判断
        println(a === c)//引用判断
    }

    //空安全
    fun demo26() {
        val l: List<Int>? = null
        val exist = l?.isEmpty() ?: 0
//        println(exist)//?: 非空时执行右边


        val a: Int? = 123
        val b: Int = a ?: a as Int
//        print("b:$b")

        val c: String? = null
        c!!.toString()//!!强制非空

    }

    //异常
    fun demo27() {
        val person = object {
            val name = null
        }
        val s = person.name ?: fail("Name required")
        println(s)     // 在此已知“s”已初始化
    }

    private fun fail(message: String)/*:Nothing*/ {//Nothing永远不会返回
        throw IllegalArgumentException(message)
    }

    //let apply with
    fun demo28() {
        val arr = mutableListOf(1, 2, 3)
//        arr.let { println(it) }//闭包
        arr.apply {
            //多次调用方法，有返回this
            add(4)
            add(5)
            add(6)
        }.let { println(it) }

        with(arr) {
            //多次调用方法，无返回this
            add(7)
            add(8)
            add(9)
        }.let { println(it) }

        arr.run {
            add(10)
            add(11)
            add(12)
        }.let { println(it) }

        println(arr)

    }

    //属性委托
    fun demo29() {
        var name by Preference("name", "empty")
        print("name:" + name)
        name = "ricky"
        print("name:" + name)
    }

    //解构赋值
    fun demo30() {
        val map = mapOf(1 to "one", 2 to "two")
        val message1 = map.map { (key, value) -> "$key $value!" }
        val message2 = map.mapValues { (key, value) -> "$key $value!" }
        println()
    }


}
