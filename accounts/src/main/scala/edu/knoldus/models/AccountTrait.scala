package edu.knoldus.models

trait AccountTrait {

  def addUser(user: User): Boolean

  def authenticateUser(username: String, password: String): (String, Boolean)
}
