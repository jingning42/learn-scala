package org.jetbrains.scala

@main
def run(): Unit =
  class Team:
    private var _name: String= "Team1"
    private var _score = 0

    def name: String = _name
    def name_=(newValue: String): Unit =
      _name = newValue

    def score: Int = _score
    def score_=(newValue: Int): Unit =
      if newValue > 0 then
        _score = newValue
      else
        printWarning()

    private def printWarning(): Unit =
      println("WARNING: Score must be positive integer")
  end Team

  val team1 = Team()
  println(team1.name)  // Team1
  println(team1.score)  // 0


  team1.name = "Anteater"
  team1.score = 101 // prints the warning

  println(team1.name)  // Anteater
  println(team1.score)  // 101