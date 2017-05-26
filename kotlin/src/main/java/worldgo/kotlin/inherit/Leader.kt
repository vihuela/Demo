package worldgo.kotlin.inherit

/**
 * @author ricky.yao on 2017/5/23.
 */
class Leader : Stuff {
    var age = 0
    var name = ""

    constructor(name: String) : super(name, 5) {
        println("age:$age")
    }

    //次构造函数
    constructor(name: String, levlel: Int) : super(name, levlel) {
        println("age:$age")
    }

    init {
        println("age:$age name:$name")
    }

    override val des: String
        get() = super.des

    override fun print() {
        super.print()
    }
}