package worldgo.kotlin.generics

/**
 * @author ricky.yao on 2017/5/25.
 */
//上界
abstract class Source3<T:Number> {
    abstract fun next(tq :T):T
}