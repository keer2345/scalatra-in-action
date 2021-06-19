package com.example.cms

import org.scalatra._
import scalate.ScalateSupport

class PagesController extends ScalatraCmsStack {

  get("/pages/:slug") {
    contentType = "text/html"
    PageDao.pages find (_.slug == params("slug")) match {
      case Some(page) => ssp("/pages/show", "page" -> page)
      case None       => halt(404, "not found")
    }
  }
}

case class Page(slug: String, title: String, summary: String, body: String)

object PageDao {
  val page1 = Page(
    "bacon-ipsum",
    "Bacon ipsum dolor sit amet hamburger",
    """Nunc rutrum turpis sed pede.""",
    """Pellentesque dapibus suscipit ligula.  Donec posuere augue in quam.
       Etiam vel tortor sodales tellus ultricies commodo.  Suspendisse potenti.
       Aenean in sem ac leo mollis blandit.  Donec neque quam, dignissim in, mollis nec,
       sagittis eu, wisi.  Phasellus lacus.  Etiam laoreet quam sed arcu.
       Phasellus at dui in ligula mollis ultricies.  Integer placerat tristique nisl.
       Praesent augue.  Fusce commodo.  Vestibulum convallis, lorem a tempus semper,
       dui dui euismod elit, vitae placerat urna tortor vitae lacus.  Nullam libero mauris,
       consequat quis, varius et, dictum id, arcu.  Mauris mollis tincidunt felis.
       Aliquam feugiat tellus ut neque.  Nulla facilisis, risus a rhoncus fermentum,
       tellus tellus lacinia purus, et dictum nunc justo sit amet elit."""
  )
  val page2 = Page(
    "veggie-ipsum",
    "Nunc rutrum turpis sed pede",
    """Vivamus id enim.""",
    """Lorem ipsum dolor sit amet, consectetuer adipiscing elit.  Donec hendrerit tempor
       tellus.  Donec pretium posuere tellus.  Proin quam nisl, tincidunt et, mattis eget,
       convallis nec, purus.  Cum sociis natoque penatibus et magnis dis parturient montes,
       nascetur ridiculus mus.  Nulla posuere.  Donec vitae dolor.  Nullam tristique diam non
       turpis.  Cras placerat accumsan nulla.  Nullam rutrum.  Nam vestibulum accumsan nisl."""
  )

  val pages = List(page1, page2)
}
