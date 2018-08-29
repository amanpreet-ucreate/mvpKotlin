package com.aman.user.mvpkotlin.Utilities.EventBus

import io.reactivex.Observable
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject

/**
 *  @see https://android.jlelse.eu/super-simple-event-bus-with-rxjava-and-kotlin-f1f969b21003
* */
object Eventbus {

    /**
     * Observable: Assume that a professor is an observable. The professor teaches about some topic.
     *  Observer: Assume that a student is an observer. The student observes the topic being taught by the professor.
     *
     *
     * */

    /**
     * @publisher It emits all the subsequent items of the source Observable at the time of subscription.
     * */
    private val publisher = PublishSubject.create<Any>()

    /**
     * @stickyEventsSubject It emits the most recently emitted item and all the subsequent items of the source Observable when an observer subscribes to it.
     * */
    private val stickyEventsSubject = BehaviorSubject.create<Any>()


    /**
     * @replyEventsSubject It emits all the items of the source Observable, regardless of when the subscriber subscribes.
     * */
    private val replyEventsSubject = ReplaySubject.create<Any>()

    /**
     * @asyncEventsSubject It only emits the last value of the source Observable(and only the last value) only after that source Observable completes.
     * */
    private val asyncEventsSubject = AsyncSubject.create<Any>()

    fun publish(event: Any) {
        publisher.onNext(event)
    }
    fun publishSticky(event: Any) {
        stickyEventsSubject.onNext(event)
    }
    fun publishReply(event: Any) {
        replyEventsSubject.onNext(event)
    }
    fun publishAsynce(event: Any) {
        asyncEventsSubject.onNext(event)
    }




    // Listen should return an Observable and not the publisher
    // Using ofType we filter only events that match that class type
    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
    fun <T> listenSticky(eventType: Class<T>): Observable<T> = stickyEventsSubject.ofType(eventType)
    fun <T> listenReply(eventType: Class<T>): Observable<T> = replyEventsSubject.ofType(eventType)
    fun <T> listenAsync(eventType: Class<T>): Observable<T> = asyncEventsSubject.ofType(eventType)



}