package worldgo.kotlin.interfaces

/**
 * @author ricky.yao on 2017/5/22.
 */
interface FlyingAnimal {
    val name: String
    fun fly() {
        println("default fly impl")
    } //方法默认实现
}
