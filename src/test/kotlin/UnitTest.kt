import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
class UnitTest {
    val solver = Solver()
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

    @Test
    fun decrypting() {
        assertContains(solver.decrypt("uftu"), "test")
        assertContains(solver.decrypt("qbpq"), "test")
    }

    @Test
    fun encrypting() {
        assertEquals(solver.encrypt("test", -27), "sdrs")
        assertEquals(solver.encrypt("test", 10), "docd")
    }
}