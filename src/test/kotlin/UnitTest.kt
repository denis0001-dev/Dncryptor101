import kotlin.test.Test
import kotlin.test.assertEquals

class UnitTest {
    @Test
    @Suppress("KotlinConstantConditions")
    fun infiniteList() {
        val list = InfiniteList("test", "404", "error", "gooo")
        assertEquals("test", list[0])
        assertEquals("test",  list[4])
        assertEquals("404", list[5])
        assertEquals("gooo", list[-1])
        assertEquals("gooo",  list[-5])
    }
}