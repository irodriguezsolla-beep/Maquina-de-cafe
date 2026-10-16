package com.ejemplo.coffeemachine

enum class Bebida(val id: Int, val nombre: String) {
    CAFE_SOLO(1, "Café Solo"),
    CAFE_CON_LECHE(2, "Café con Leche"),
    CAPUCHINO(3, "Capuchino");

    companion object {
        fun fromId(id: Int): Bebida? = entries.find { it.id == id }
    }
}