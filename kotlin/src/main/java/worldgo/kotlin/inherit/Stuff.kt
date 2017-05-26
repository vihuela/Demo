package worldgo.kotlin.inherit

/**
 * @author ricky.yao on 2017/5/23.
 */
//constructor在使用注解时必须存在，平常可以省略
open class Stuff constructor(name: String, level: Int = 1) {

    //默认final，可以覆盖使用open
    open val des: String = ""
    open fun print() {}

    init {
        println("level:$level")
    }
}