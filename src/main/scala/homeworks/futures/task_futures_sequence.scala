package homeworks.futures

import homeworks.HomeworksUtils.TaskSyntax

import scala.concurrent.{ExecutionContext, Future}

object task_futures_sequence {
  implicit val ec = ExecutionContext.global

  /** В данном задании Вам предлагается реализовать функцию fullSequence,
    * похожую на Future.sequence, но в отличии от нее,
    * возвращающую все успешные и не успешные результаты.
    * Возвращаемое тип функции - кортеж из двух списков,
    * в левом хранятся результаты успешных выполнений,
    * в правово результаты неуспешных выполнений
    */
  /** @param futures список асинхронных задач
    * @return асинхронную задачу с кортежом из двух списков
    */
  def fullSequence[A](
      futures: List[Future[A]]
  ): Future[(List[A], List[Throwable])] = {
    futures.foldLeft(Future.successful(List.empty[A], List.empty[Throwable]))(
      (a, f) =>
        a.flatMap({ case (values, failures) =>
          f
            .map { v => (values :+ v, failures) }
            .recover { fail => (values, failures :+ fail) }
        })
    )
  }
=======
  /**
   * В данном задании Вам предлагается реализовать функцию fullSequence,
   * похожую на Future.sequence, но в отличии от нее,
   * возвращающую все успешные и не успешные результаты.
   * Возвращаемое тип функции - кортеж из двух списков,
   * в левом хранятся результаты успешных выполнений,
   * в правово результаты неуспешных выполнений.
   * Не допускается использование методов объекта Await и мутабельных переменных var
   */
  /**
   * @param futures список асинхронных задач
   * @return асинхронную задачу с кортежом из двух списков
   */
  def fullSequence[A](futures: List[Future[A]])
                     (implicit ex: ExecutionContext): Future[(List[A], List[Throwable])] =
    task"Реализуйте метод `fullSequence`"()
>>>>>>> b576b270c3c0803c03aaf2e3bf706af1c61092c3
}
