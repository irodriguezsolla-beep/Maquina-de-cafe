import com.ejemplo.coffeemachine.Bebida

object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.E1_Idle()

    fun makeCoffee() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.E1_Idle -> {
                println("Estado Idle")
                Thread.sleep(2000)
                bibida = Bebida(1,"Cafe")
                currentState = CoffeeMachineState.E2_SeleccionBebida
                println("Seleccionando bebida...")
            }
            is CoffeeMachineState.E2_SeleccionBebida -> {
                println("Estado E2")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.E4_SeleccionAzucar
                print("Selcionado vevida")
            }
            is CoffeeMachineState.E3_BebidaNoDisponible -> {
                println("Estado E3")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.E2_SeleccionBebida()
                print("Error")
            }
            is CoffeeMachineState.E4_SeleccionAzucar -> {
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