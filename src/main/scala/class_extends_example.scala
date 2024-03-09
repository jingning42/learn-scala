package org.jetbrains.scala

@main
def myClassExample(): Unit =
  // example from https://docs.scala-lang.org/scala3/book/domain-modeling-oop.html#classes
  trait Showable:
    def show: String
    def showHtml = "<p>" + show + "</p>"
  trait GreetingService:
    def translate(text: String): String
    def sayHello = translate("Hello")
  trait TranslationService:
    def translate(text: String): String = text.toUpperCase()
  trait ComposedService extends GreetingService, TranslationService
  class MyService(name: String) extends ComposedService, Showable:
    def show = s"$name says $sayHello"

  val s1: MyService = MyService("Service 1")
  val s2: GreetingService = s1
  val s3: TranslationService = s1
  val s4: Showable = s1
  println(s1.translate("bye"))
  println(s1.sayHello)
  println(s1.show)
  println(s1.showHtml)
  println(s2.sayHello)
  println(s2.translate("bye"))
  println(s3.translate("hey"))
  println(s4.show)
  print(s4.showHtml)

