package worldgo.kotlin.inherit2

/**
 * @author ricky.yao on 2017/5/24.
 */
class C : A(), B {
    override fun f() {
        super<A>.f()//f()在A类与B接口中都有实现，要指定
        super<B>.f()
    }

    fun getFucking(){
        a()
    }

}