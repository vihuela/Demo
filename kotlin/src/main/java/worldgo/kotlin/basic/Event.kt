package worldgo.kotlin.basic

import android.view.View
import worldgo.kotlin.basic.listener.CustomerView
import worldgo.kotlin.basic.listener.IClickListener

/**
 * @author ricky.yao on 2017/5/22.
 */
class Event {
    fun setOnClickListener(cv: CustomerView, v: View?) {
        //CustomerView
        cv.setOnClickListener(object : IClickListener {
            override fun onClick(view: CustomerView) {
                print(view.tag)
            }
        })
        cv.setOnClickListener {
            print("")
        }
        cv.setOnClickListener2 {
            print(it.tag)
        }
        //View
        v?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
            }
        })
        v?.setOnClickListener({ view -> print(view.tag) })
        v?.setOnClickListener({ print(it.tag) })//默认为it
        v?.setOnClickListener() { print(it.tag) }
        v?.setOnClickListener { print(it.tag) }
    }
}
