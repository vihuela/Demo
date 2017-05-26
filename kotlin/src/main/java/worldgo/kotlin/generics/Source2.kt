package worldgo.kotlin.generics

/**
 * @author ricky.yao on 2017/5/25.
 */
//in用作消费
abstract class Source2<in T> {
    //abstract fun next():T//error
    abstract fun next(tq :T)

}