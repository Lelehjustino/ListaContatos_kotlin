package com.example.cadratrousuarios

class Usuarios {

    // Nome
    var nome: String = ""

    // Email
    var email: String = ""

    // Telefone
    var telefone: String = ""

    companion object {
        // Lista global de usuários
        val listaUsuariosGlobal = mutableListOf<Usuarios>()
    }
}