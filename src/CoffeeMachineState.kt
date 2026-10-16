sealed class CoffeeMachineState {
    // E1: Inactiva, esperando moneda
    class E1_Idle(val timestamp: Long = System.currentTimeMillis()) : CoffeeMachineState()

    // E2: Selección de bebida (botones 1 al 6)
    object E2_SeleccionBebida : CoffeeMachineState()

    // E3: Bebida no disponible
    object E3_BebidaNoDisponible : CoffeeMachineState()

    // E4: Selección de azúcar (Sí / No)
    object E4_SeleccionAzucar : CoffeeMachineState()

    // E5: Preparación de café sin azúcar
    object E5_PreparacionSinAzucar : CoffeeMachineState()

    // E6: Selección de cantidad de azúcar (niveles 1 a 5)
    object E6_SeleccionCantidadAzucar : CoffeeMachineState()

    // E7: Azúcar no disponible
    object  E7_AzucarNoDisponible: CoffeeMachineState()

    // E8: Preparación de café con azúcar
    object  E8_PreparacionConAzucar : CoffeeMachineState()

    // E9: Recogida del café
    object  E9_RecogidaCafe : CoffeeMachineState()
}