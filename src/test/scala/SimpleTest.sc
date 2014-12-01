import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers with MockitoSugar {

  trait StackLike {
    def push(value: Int): Unit
    def pop(): Int
  }

  def fixture() = mock[StackLike]

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = fixture()
    when(stack.pop()).thenReturn(2, 1)
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }
  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = fixture()
    when(emptyStack.pop()).thenThrow(new NoSuchElementException)
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }
}

run(new ExampleSpec)