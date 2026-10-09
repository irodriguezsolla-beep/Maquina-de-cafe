object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.E1_Idle()

    fun makeCoffee() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.E1_Idle -> {

            }
            is CoffeeMachineState.E2_SeleccionBebida -> {
                println("¡Espera! La máquina ya está haciendo café.")
            }
            is CoffeeMachineState.E3_BebidaNoDisponible -> {
                println("Ya hay café servido. Por favor, toma tu café.")
            }
            is CoffeeMachineState.E4_SeleccionAzucar -> {

            }
            is CoffeeMachineState.E5_PreparacionSinAzucar -> {

            }
            is CoffeeMachineState.E6_SeleccionCantidadAzucar -> {

            }
            is CoffeeMachineState.E7_AzucarNoDisponible -> {

            }
            is CoffeeMachineState.E8_PreparacionConAzucar -> {

            }
            is CoffeeMachineState.E9_RecogidaCafe -> {

            }

        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.E1_Idle()
        println("Máquina limpia. Estado: $currentState")
    }
}