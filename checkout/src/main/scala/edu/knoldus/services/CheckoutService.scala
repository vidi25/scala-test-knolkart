package edu.knoldus.services

import edu.knoldus.models.{Cart, CheckoutTrait, Item}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class CheckoutService(cart: Cart) extends CheckoutTrait {

  def addItemToCart(item: Item): Future[Cart] = {
    Future {
      Cart(item :: cart.itemBasket)
    }
  }

  def removeItemFromCart(item: Item): Future[Cart] = {
    Future {
      Cart(cart.itemBasket.filter(product => product != item))
    }
  }

}
