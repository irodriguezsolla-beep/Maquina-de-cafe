
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.E1_Idle()
    var bebida: Bebida? = null
    fun makeCoffee() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.E1_Idle -> {
                println("Estado Idle")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.E2_SeleccionBebida
            }

            is CoffeeMachineState.E2_SeleccionBebida -> {
                println("Estado E2")
                Thread.sleep(2000)
                bebida = Bebida.CAFE_SOLO
                val b = bebida

                // Verificamos si hay stock en la bebida
                if (b != null)  {
                    if( b.cantidad > 0){
                        // Descontamos 1 unidad del stock
                        b.cantidad--

                        println("Bebida seleccionada: ${bebida?.nombre}. Stock restante: ${bebida?.cantidad}")
                        currentState = CoffeeMachineState.E4_SeleccionAzucar
                    }else{
                        currentState = CoffeeMachineState.E3_BebidaNoDisponible
                        println("No queda stock de esta bebida.")
                    }

                } else {
                    currentState = CoffeeMachineState.E3_BebidaNoDisponible
                    println("No queda stock de esta bebida.")
                }
                currentState = CoffeeMachineState.E4_SeleccionAzucar
                print("Selcionado vevida")
            }
            is CoffeeMachineState.E3_BebidaNoDisponible -> {
                println("Estado E3")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.E1_Idle()
                print("Error")
            }
            is CoffeeMachineState.E4_SeleccionAzucar -> {
                println("Estado E4")
                Thread.sleep(2000)

                println("Ya hay café servido. Por favor, toma tu café.")

            }
            is CoffeeMachineState.E5_PreparacionSinAzucar -> {
                println("Ya hay café servido. Por favor, toma tu café.")

            }
            is CoffeeMachineState.E6_SeleccionCantidadAzucar -> {
                println("Ya hay café servido. Por favor, toma tu café.")

            }
            is CoffeeMachineState.E7_AzucarNoDisponible -> {
                println("Ya hay café servido. Por favor, toma tu café.")

            }
            is CoffeeMachineState.E8_PreparacionConAzucar -> {
                println("Ya hay café servido. Por favor, toma tu café.")

            }
            is CoffeeMachineState.E9_RecogidaCafe -> {
                println("Ya hay café servido. Por favor, toma tu café.")

            }

        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.E1_Idle()
        println("Máquina limpia. Estado: $currentState")
    }
}