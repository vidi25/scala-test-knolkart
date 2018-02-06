package edu.knoldus.models

import scala.concurrent.Future

trait CheckoutTrait {

  def addItemToCart(item: Item): Future[Cart]

  def removeItemFromCart(item: Item): Future[Cart]
}
