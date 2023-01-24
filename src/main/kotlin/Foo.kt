import java.lang.ref.WeakReference

class Foo(private val ref: WeakReference<Bar>) {

    fun get(): Bar? {
        return ref.get()
    }
}