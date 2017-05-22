package worldgo.kotlin.interfaces

/**
 * @author ricky.yao on 2017/5/22.
 */
class Bird : FlyingAnimal {
    override val name: String = "name is bird"

    override fun fly(): Unit {
        println("bird is fly")
    }
}