package worldgo.kotlin.generics

/**
 * @author ricky.yao on 2017/5/25.
 */
//out用作返回(生产)，不用做消费
abstract class Source1<out T> {
    //abstract fun next(t:T)//error
    abstract fun next():T
}