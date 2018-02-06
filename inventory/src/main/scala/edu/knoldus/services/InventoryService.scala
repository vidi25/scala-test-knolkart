package edu.knoldus.services

import edu.knoldus.models.{Item, ItemTrait}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class InventoryService(itemList: List[Item]) extends ItemTrait{

  def searchItem(category: String): Future[List[Item]] = {
    Future {
      val searchedItem = itemList.filter(items => items.category == category)
      searchedItem
    }
  }

  def sortItemList(filterParameter: String): Future[List[Item]] = {
    Future {
      filterParameter match {
        case "low to high on price" => itemList.sortBy(item => item.price)
        case "high to low on price" => itemList.sortBy(item => item.price).reverse
        case "low to high on rating" => itemList.sortBy(item => item.rating)
        case "high to low on rating" => itemList.sortBy(item => item.rating).reverse
        case _ => itemList.sortBy(item => item.rating).reverse
      }
    }
  }
}
