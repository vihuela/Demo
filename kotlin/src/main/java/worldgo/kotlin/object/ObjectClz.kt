package worldgo.kotlin.`object`

import android.view.View

/**
 * @author ricky.yao on 2017/5/25.
 */
class ObjectClz(tag:String = "") {
    //匿名内部类对象
    open class innerClz{}
    val b: View.OnClickListener = object :View.OnClickListener,innerClz(){
        override fun onClick(v: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
    fun setOnClick(){
        //匿名内部类
        val v: View ?= null
        v?.setOnClickListener (object :View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }



    //伴生对象,需要实例化引用
     companion object Factory {
        fun create(): Int = 0
    }
    override fun toString(): String {
        return "ObjectClz(b=$b)"
    }

}