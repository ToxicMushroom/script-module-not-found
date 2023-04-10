import kotlin.script.experimental.api.valueOr

fun main(args: Array<String>) {
    evalCode(args[0]).also {
        it.reports.forEach { diagnostic ->
            println(diagnostic.message)
        }
    }.valueOr {
        println("Ended in failure")
        return
    }.run {
        println("Ended in success: ${this.returnValue}")
        return
    }
}