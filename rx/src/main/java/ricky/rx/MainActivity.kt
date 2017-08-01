package ricky.rx

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.processors.BehaviorProcessor
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById(R.id.tv).setOnClickListener {
            test1()
        }
        findViewById(R.id.tv2).setOnClickListener {
            subject.onNext(true)
        }
        findViewById(R.id.tv3).setOnClickListener {
            subject.onNext(false)
        }

    }

    lateinit var subject: BehaviorProcessor<Boolean>


    fun test1() {
        //用BehaviorSubject控制Observable是否结束
        subject = BehaviorProcessor.create()
        subject.subscribe { L("subject:$it") }
        val o1 = Observable.interval(1, TimeUnit.SECONDS)
        o1.compose { it.takeUntil(subject.toObservable().skipWhile { it }) }
                .subscribe { L("Observable:$it") }
        //subject.onNext(true) 无效
        //subject.onNext(false)让Observable停止
    }

    fun blockingForEach() {

        val o1 = Observable.interval(1, TimeUnit.SECONDS).take(5)

        o1.blockingForEach { L(it) }

    }

    fun takeUntil() {

        //当o2开始发射数据时，停止
        val o1 = Observable.interval(1, TimeUnit.SECONDS).take(5)
        val o2 = Observable.interval(3, TimeUnit.SECONDS).take(5)

        o1.takeUntil(o2)
                .subscribe { L(it) }//0 1

    }

    fun takeWhile() {
        //满足条件时
        val o1 = Observable.interval(1, TimeUnit.SECONDS).take(5)

        o1.takeWhile { it < 3 }
                .subscribe { L(it) }//0 1 2
    }

    fun skipWhile() {
        //不满足条件时
        val o1 = Observable.interval(1, TimeUnit.SECONDS).take(5)

        o1.skipWhile { it < 3 }
                .subscribe { L(it) }//3 4，需要等待0 1 2的订阅时间

    }

    fun test3() {
        //repeatWhen 拦截onComplete(Unit)，retryWhen 拦截onError(Throwable)
        Observable
                .just(1)
                .repeatWhen {
                    //zipWith 以次数少的Observable为准，repeatWhen数据源是无限的
                    it.zipWith(Observable.range(1, 10), BiFunction<Any, Int, Unit> { t1, t2 -> Unit })
                            .flatMap {
                                Observable.timer(2, TimeUnit.SECONDS)
                            }
                }
                .subscribe { L("onNext:" + it) }

    }


    fun Activity.L(message: Any) {
        Log.d(javaClass.simpleName, message.toString())
    }

}
