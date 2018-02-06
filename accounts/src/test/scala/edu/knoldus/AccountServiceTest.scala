package edu.knoldus

import edu.knoldus.models.User
import edu.knoldus.services.AccountService
import org.scalatest.{FlatSpec, Matchers}

class AccountServiceTest extends FlatSpec with Matchers{

  val userList = Map(92418->User("Aman",15,"delhi",92418,"aman123","12345"))
  val accountService = new AccountService(userList)
  val newUser = User("ajay",23,"mumbai",87654,"ajay09","ajay123")
  val existingUser = User("astha",34,"delhi",92418,"astha12","12345")
  "add user method" should "add a user to the account list" in {
      accountService.addUser(newUser)
  }

  it should "not add already existing user" in {
    !accountService.addUser(existingUser)
  }

  "authenticate user method" should "generate an access token" in {
    accountService.authenticateUser("aman123","12345") should be ("A1234",true)
  }

  it should "not generate an access token" in {
    accountService.authenticateUser("aman123","123") should be ("can't authenticate",false)
  }

}
