package worldgo.kotlin.inherit2

/**
 * @author ricky.yao on 2017/5/24.
 */
interface B {
    fun f() { print("B") } // 接口成员默认就是“open”的
    fun b() { print("b") }
}