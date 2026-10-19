
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.E1_Idle()
    //definiciones modificables
    var bebida: Bebida? = null
    var quiereAzucar: Boolean = true
    var stockAzucar: Int = 5

    var cantidadAzucarDeseada: Int = 2

    fun makeCoffee() {
        println("-------------------------------")
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.E1_Idle -> {
                println("Estado Idle")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.E2_SeleccionBebida
            }

            is CoffeeMachineState.E2_SeleccionBebida -> {
                println("Estado E2: Seleccion Bebida")
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

            }
            is CoffeeMachineState.E3_BebidaNoDisponible -> {
                println("Estado E3:  Bebidad no disponible")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.E1_Idle()
                print("Error no hay cafe")
            }
            is CoffeeMachineState.E4_SeleccionAzucar -> {
                println("Estado E4:  Selección de Azucar")
                Thread.sleep(2000)
                if (!quiereAzucar) {
                    // Si el usuario no quiere azúcar
                    println("Opción elegida: Sin azúcar.")
                    currentState = CoffeeMachineState.E5_PreparacionSinAzucar
                } else {
                    // Si quiere azúcar
                    if (stockAzucar > 0) {
                        // O bien pasas a elegir cantidad (E6) o descuentas y preparas (E8)
                        println("Azúcar disponible. Redirigiendo a selección de cantidad...")
                        currentState = CoffeeMachineState.E6_SeleccionCantidadAzucar
                    } else {
                        println("Sin stock de azúcar.")
                        currentState = CoffeeMachineState.E7_AzucarNoDisponible
                    }
                }

            }
            is CoffeeMachineState.E5_PreparacionSinAzucar -> {
                println("Estado E5;  Preparacion sin azucar")
                println("Preparando cafe....")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.E9_RecogidaCafe
            }
            is CoffeeMachineState.E6_SeleccionCantidadAzucar -> {
                println("Estado E6: Selección de Cantidad de Azúcar")
                Thread.sleep(2000)

                println("Cantidad elegida: $cantidadAzucarDeseada cucharadas/sobres.")

                // Validamos si el stock de azúcar alcanza para la cantidad pedida
                if (stockAzucar >= cantidadAzucarDeseada) {
                    // Descontamos la cantidad solicitada
                    stockAzucar -= cantidadAzucarDeseada
                    println("Azúcar asignado correctamente. Stock restante de azúcar: $stockAzucar")

                    // Pasa a la preparación con azúcar
                    currentState = CoffeeMachineState.E8_PreparacionConAzucar
                } else {
                    currentState = CoffeeMachineState.E7_AzucarNoDisponible
                }

            }
            is CoffeeMachineState.E7_AzucarNoDisponible -> {
                Thread.sleep(2000)
                println("No hay suficiente azúcar para la cantidad elegida (Stock actual: $stockAzucar).")
                currentState = CoffeeMachineState.E4_SeleccionAzucar


            }
            is CoffeeMachineState.E8_PreparacionConAzucar -> {
                println("Preparando cafe....")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.E9_RecogidaCafe

            }
            is CoffeeMachineState.E9_RecogidaCafe -> {
                println("Por favor, toma tu café.")

            }

        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.E1_Idle()
        println("Máquina limpia. Estado: $currentState")
    }
}