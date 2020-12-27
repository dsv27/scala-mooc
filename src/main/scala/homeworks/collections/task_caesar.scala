package homeworks.collections

import homeworks.HomeworksUtils.TaskSyntax
import scala.annotation.tailrec

object task_caesar {

  val abcd = 'A' to 'Z'

  /** В данном задании Вам предлагается реализовать функции,
    * реализующие кодирование/декодирование строки шифром Цезаря.
    * https://ru.wikipedia.org/wiki/Шифр_Цезаря
    * Алфавит - прописные латинские буквы от A до Z.
    * Сдвиг   - неотрицательное целое число.
    * Пример: при сдвиге 2 слово "SCALA" шифруется как "UECNC".
    */
  /** @param word   входное слово, которое необходимо зашифровать
    * @param offset сдвиг вперёд по алфавиту
    * @return зашифрованное слово
    */

  def encrypt(word: String, offset: Int): String =
    word.map(x => locateAbcd(abcd.indexOf(x) + offsetAbcd(offset)))

  /** @param cipher шифр, который необходимо расшифровать
    * @param offset сдвиг вперёд по алфавиту
    * @return расшифрованное слово
    */
  def decrypt(cipher: String, offset: Int): String =
    cipher.map(x => locateAbcd(abcd.indexOf(x) - offsetAbcd(offset)))

  // Можно через % , но упражнения на рекурсию :)
  def offsetAbcd(offset: Int, abcdLen: Int = abcd.length()): Int = {
    @tailrec
    def loop(offset: Int, abcdLen: Int): Int = {
      offset match {
        case x if x <= abcdLen => offset
        case _                 => loop(offset - abcdLen, abcdLen)
      }
    }
    loop(offset, abcdLen)
  }
  def locateAbcd(offset: Int): Char = {
    offset match {
      case x if x < 0                       => abcd(offset + abcd.length())
      case x if x >= 0 && x < abcd.length() => abcd(offset)
      case x if x >= abcd.length()          => abcd(offset - abcd.length())
    }
  }
}
