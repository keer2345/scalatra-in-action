package com.example.cms

import org.scalatra.test.scalatest._

class PagesControllerTests extends ScalatraFunSuite {

  addServlet(classOf[PagesController], "/*")

  test("GET / on PagesController should return status 200") {

    get("/pages/bacon-ipsum") {
      status should equal(200)
    }

    get("/pages/veggie-ipsum") {
      status should equal(200)
    }
  }

}
