package edu.knoldus

import edu.knoldus.models.{Cart, Item, User}
import edu.knoldus.services.{AccountService, CheckoutService, InventoryService}

class FactoryObject {

  val cart = Cart(List[Item]())
  val accountService = new AccountService(Map[Int, User]())
  val inventoryService = new InventoryService(List[Item]())
  val checkoutService = new CheckoutService(cart)

}
