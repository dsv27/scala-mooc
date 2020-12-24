object Main extends App {
    var offset: Int = 2
    var word: String = "SCALAZ"
    var cipher: String = homeworks.collections.task_caesar.encrypt(word,offset)
    println("Before emcription -> " + word + "| After encription -> " + cipher + " " +
      " | After decript -> " + homeworks.collections.task_caesar.decrypt(cipher, offset))
    val l: List[Int] = List(1, 2, 1, 1)
    println("List -> "+ homeworks.collections.task_seq_riddle.nextLine(l)) 
}