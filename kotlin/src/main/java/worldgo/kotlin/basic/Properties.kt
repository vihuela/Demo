package worldgo.kotlin.basic

/**
 * @author ricky.yao on 2017/5/22.
 */
class Properties {
    val a: String
        get() = "i am a"

    var b: String
        get() = "i am b"
        set(value) {
            b = value
        }
    val c: String = "i am c"
}