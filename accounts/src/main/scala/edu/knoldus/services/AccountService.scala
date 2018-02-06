package edu.knoldus.services

import edu.knoldus.models.{AccountTrait, User}

class AccountService(userAccounts: Map[Int, User]) extends AccountTrait {

  val accessToken = "A1234"

  def addUser(customer: User): Boolean = {
    if (userAccounts.contains(customer.mobileNumber)) {
      false
    }
    else {
      userAccounts + (customer.mobileNumber -> customer)
      true
    }
  }

  def authenticateUser(username: String, password: String): (String, Boolean) = {
    val customer = userAccounts.valuesIterator.toList.find { user => user.username == username && user.password == password }
    customer match {
      case Some(user: User) => (accessToken, true)
      case None => ("can't authenticate", false)
    }
  }

}
