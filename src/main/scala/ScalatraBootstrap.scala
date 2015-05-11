import com.tomekl007.app._
import com.tomekl007.app.controller.GeeconController
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new GeeconController(), "/*")
  }
}
