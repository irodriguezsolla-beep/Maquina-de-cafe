fun main() {
    println("--- INICIANDO MÁQUINA DE CAFÉ ---")

    // El bucle se ejecuta mientras no hayamos llegado al estado final (Recogida)
    while (CoffeeMachine.currentState !is CoffeeMachineState.E9_RecogidaCafe) {
        CoffeeMachine.makeCoffee()
    }

    // Una última llamada para procesar el mensaje final de E9
    CoffeeMachine.makeCoffee()

    println("\n--- PROCESO FINALIZADO ---")
}