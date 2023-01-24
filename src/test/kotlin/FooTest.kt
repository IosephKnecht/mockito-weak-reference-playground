import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.lang.ref.WeakReference

class FooTest {

    @Test
    fun test() {
        val weakReference = Mockito.mock(WeakReference::class.java) as WeakReference<Bar>
        val bar = Mockito.mock(Bar::class.java)

        Mockito.doReturn(bar).`when`(weakReference).get()

        val foo = Foo(weakReference)
        val consumedBar = foo.get()

        Mockito.verify(foo.get())
        Assertions.assertEquals(consumedBar, bar)
    }
}