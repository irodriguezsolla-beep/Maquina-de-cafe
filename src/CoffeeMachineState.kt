sealed class CoffeeMachineState {
    // E1: Inactiva, esperando moneda
    class E1_Idle(val timestamp: Long = System.currentTimeMillis()) : CoffeeMachineState()

    // E2: Selección de bebida (botones 1 al 6)
    object E2_SeleccionBebida : CoffeeMachineState()

    // E3: Bebida no disponible
    data class E3_BebidaNoDisponible(val bebidaId: Int) : CoffeeMachineState()

    // E4: Selección de azúcar (Sí / No)
    data class E4_SeleccionAzucar(val bebidaId: Int) : CoffeeMachineState()

    // E5: Preparación de café sin azúcar
    data class E5_PreparacionSinAzucar(val bebidaId: Int) : CoffeeMachineState()

    // E6: Selección de cantidad de azúcar (niveles 1 a 5)
    data class E6_SeleccionCantidadAzucar(val bebidaId: Int) : CoffeeMachineState()

    // E7: Azúcar no disponible
    data class E7_AzucarNoDisponible(val bebidaId: Int) : CoffeeMachineState()

    // E8: Preparación de café con azúcar
    data class E8_PreparacionConAzucar(val bebidaId: Int, val nivelAzucar: Int) : CoffeeMachineState()

    // E9: Recogida del café
    data class E9_RecogidaCafe(val bebidaId: Int, val conAzucar: Boolean, val nivelAzucar: Int = 0) : CoffeeMachineState()
}