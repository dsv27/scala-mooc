package homeworks.collections

import homeworks.HomeworksUtils.TaskSyntax
import scala.annotation.tailrec

object task_seq_riddle {

  /** Рассмотрим последовательность с числами:
    *
    * 1
    * 1 1
    * 2 1
    * 1 2 1 1
    * 1 1 1 2 2 1
    * 3 1 2 2 1 1
    * ...........
    *
    * 1. Реализуйте функцию генерирующую след последовательность из текущей
    * For Quicky #10: Here are sets of numbers enclosed by square brackets.
    * Fill the next set of numbers. [1],[1,1],[2,1],[1,2,1,1],[1,1,1,2,2,1],[3,1,2,2,1,1], [.............]
    * Start with [1], we count 1 number 1, so we write [1, 1], then we continue counting 2 numbers 1, so we write [2, 1], now that's 1 number 2, and 1 number 1, so we write [1, 2, 1, 1],...
    * So a few next sets are: [1, 1, 1, 2, 2, 1] [3, 1, 2, 2, 1, 1] [1, 3, 1, 1, 2, 2, 2, 1] [1, 1, 1, 3, 2, 1, 3, 2, 1, 1]
    * Source https://www.physicsforums.com/threads/brain-teasers-and-math-problems.117230/
    */

  def nextLine(currentLine: List[Int]): List[Int] = {
    @tailrec
    def loop(acc: List[Int], l: List[Int]): List[Int] = l match {
      case Nil => acc
      case currentList @ (head :: _) =>
        val tmpList =
          currentList.takeWhile(_ == head) //выбираем записи до последнего head
        val resultList = List(
          tmpList.size,
          head
        ) // создаем промежуточный результирующий список, из 2 элементов head = длина непрерывной последовательности, tail значение эдемента
        loop(
          acc ++ resultList,
          currentList.dropWhile(_ == head)
        ) // добавляем в глову аккумулятора результирующий список, передаем в обработку откушеный хвост
    }

    loop(Nil, currentLine)
  }

  /** 2. Реализуйте ленивый список, который генерирует данную последовательность
    * Hint: см. LazyList.cons
    *
    * lazy val funSeq: LazyList[List[Int]]  ...
    */

  lazy val funSeq: LazyList[List[Int]] = List(1) #:: funSeq.map(nextLine)

}
