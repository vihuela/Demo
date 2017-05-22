package worldgo.kotlin.basic.listener

import android.view.View

/**
 * @author ricky.yao on 2017/5/22.
 */
class CustomerView {
    val tag:String = javaClass.simpleName
    fun setOnClickListener(listener: IClickListener?) {
        listener?.onClick(this)
    }
    fun setOnClickListener2(listener: (view: CustomerView) -> Unit?) {
        listener.invoke(this)
    }
    fun setOnClickListener(listener: () -> Unit?) {
        listener.invoke()
    }
}