package worldgo.kotlin.expand

/**
 * @author ricky.yao on 2017/5/25.
 */
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

val <T> MutableList<T>.size: Int
    get() = size - 1