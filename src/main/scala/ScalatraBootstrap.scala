import javax.servlet.ServletContext

import _root_.akka.actor.{ActorSystem, Props}
import com.tomekl007.app.MyScalatraServlet
import com.tomekl007.app.actors.RateAggregatorActor
import com.tomekl007.app.controller.GeeconController
import org.scalatra._

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    val system = ActorSystem()
    val rateAggregatorActor = system.actorOf(Props[RateAggregatorActor], name="rateAggregator")

    context.mount(new MyScalatraServlet, "/*")
    context.mount(new GeeconController(system, rateAggregatorActor), "/*")
  }
}
