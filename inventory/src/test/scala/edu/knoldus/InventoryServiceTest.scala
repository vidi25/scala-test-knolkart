package edu.knoldus

import edu.knoldus.models.Item
import edu.knoldus.services.InventoryService
import org.scalatest.AsyncFlatSpec

class InventoryServiceTest extends AsyncFlatSpec {

  val itemList = List(Item("jeans", "black", "Levis Company", "clothing", 4, 1200), Item("redmi4 charger", "white", "R.K Enterprises", "electronics", 5, 800), Item("redmi4", "white", "R.K Enterprises", "electronics", 3, 8000))
  val inventoryService = new InventoryService(itemList)

  "search item method" should "return a list of searched items" in {
    inventoryService.searchItem("clothing").map { list => assert(list == List(Item("jeans", "black", "Levis Company", "clothing", 4, 1200))) }
  }

  it should "return an empty list of searched items" in {
    inventoryService.searchItem("footwear").map { list => assert(list == List()) }
  }

  "sortlist method" should "return sorted list on basis of price: low to high" in {
    inventoryService.sortItemList("low to high on price").map { list => assert(list == List(Item("redmi4 charger", "white", "R.K Enterprises", "electronics", 5, 800), Item("jeans", "black", "Levis Company", "clothing", 4, 1200), Item("redmi4", "white", "R.K Enterprises", "electronics", 3, 8000))) }
  }

  it should "return sorted list on basis of price: high to low" in {
    inventoryService.sortItemList("high to low on price").map { list => assert(list == List(Item("redmi4", "white", "R.K Enterprises", "electronics", 3, 8000), Item("jeans", "black", "Levis Company", "clothing", 4, 1200), Item("redmi4 charger", "white", "R.K Enterprises", "electronics", 5, 800))) }
  }

  it should "return sorted list on basis of rating: high to low" in {
    inventoryService.sortItemList("high to low on rating").map { list => assert(list == List(Item("redmi4 charger", "white", "R.K Enterprises", "electronics", 5, 800), Item("jeans", "black", "Levis Company", "clothing", 4, 1200), Item("redmi4", "white", "R.K Enterprises", "electronics", 3, 8000))) }
  }

  it should "return sorted list on basis of rating: low to high" in {
    inventoryService.sortItemList("low to high on rating").map { list => assert(list == List(Item("redmi4", "white", "R.K Enterprises", "electronics", 3, 8000), Item("jeans", "black", "Levis Company", "clothing", 4, 1200), Item("redmi4 charger", "white", "R.K Enterprises", "electronics", 5, 800))) }
  }
}
