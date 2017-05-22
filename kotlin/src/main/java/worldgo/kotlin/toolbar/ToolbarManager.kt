package worldgo.kotlin.toolbar

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.Toolbar
import worldgo.kotlin.R

/**
 * @author ricky.yao on 2017/5/22.
 */
interface ToolbarManager {
    val toolbar: Toolbar
    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }
    fun initToolbar(){
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_context_bar -> {}
                else -> {}
            }
            true
        }
    }
    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }
    private fun createUpDrawable() = with (DrawerArrowDrawable(toolbar.context)){
        progress = 1f
        this
    }
}