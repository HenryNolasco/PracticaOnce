//Gestion de tarea
class CustomList<T> {
    private val elements = mutableListOf<T>()

    fun add(element: T): Boolean {
        return if (element !in elements){
            elements.add(element)
            println("Tarea agregada exitosamente")
            true
        } else {
            println("La tarea ya existe")
            false
        }
    }

    fun remove(element: T): Boolean{
        return if (element in elements){
            elements.remove(element)
            println("Tarea elimnada!")
            true
        } else {
            println("La tarea no se encontro en la lista")
            false
        }
    }

    fun showAll(){
        if (elements.isEmpty()){
            println("La lista esta vacia")
        } else {
            println("Lista de tarea:")
            elements.forEach {println(" - Sit")}
        }
    }

    fun size(): Int{
        return elements.size
    }
}

//Main
fun main(args: Array<String>) {
    val listaTareas = CustomList<String>()
    var opcion: Int

    do{
        println("\nGestor de tareas")
        println("1. agregar tarea")
        println("2. eliminar tarea")
        println("3. ver lista de tareas")
        println("4. salir")
        println("Seleccionar una opcion: ")
        opcion = readLine()?.toIntOrNull()?:0

        when (opcion){
            1->{
                println("Ingrese la nueva tarea:")
                val nuevaTarea = readLine()?: ""
                listaTareas.add(nuevaTarea)
            }
            2->{
                if (listaTareas.size() > 0){
                    println("Seleccione la tarea que desea eliminar:")
                    listaTareas.showAll()
                    println("Ingrese el nombre exacto de la tarea: ")
                    val eliminarTarea = readLine()?: ""
                    listaTareas.remove(eliminarTarea)
                } else {
                    println("La tarea no esta en la lista")
                }
            }
            3->{
                listaTareas.showAll()
            }
            4-> println("Saliendo del programa...")

            else -> println("Opcion no valido, ingrese una opcion valida.")
        }
    } while (opcion != 4)
}