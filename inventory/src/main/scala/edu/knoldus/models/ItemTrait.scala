package edu.knoldus.models

import scala.concurrent.Future

trait ItemTrait {

  def searchItem(category: String): Future[List[Item]]

  def sortItemList(filterParameter: String): Future[List[Item]]
}
