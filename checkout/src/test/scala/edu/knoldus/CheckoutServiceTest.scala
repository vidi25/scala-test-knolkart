package edu.knoldus

import edu.knoldus.models.{Cart, Item}
import edu.knoldus.services.CheckoutService
import org.scalatest.AsyncFlatSpec

class CheckoutServiceTest extends AsyncFlatSpec {

  val checkoutService = new CheckoutService(Cart(List[Item]()))
  val item = Item("jeans", "black", "Levis Company", "clothing", 4, 1200)

  "add item to cart method" should "return the cart on successful addition" in {
    checkoutService.addItemToCart(item).map(cart => assert(cart == Cart(List(Item("jeans", "black", "Levis Company", "clothing", 4, 1200)))))

  }

  "remove item from cart method" should "return the cart on successful deletion" in {
    checkoutService.removeItemFromCart(item).map(cart => assert(cart == Cart(List[Item]())))

  }


}
