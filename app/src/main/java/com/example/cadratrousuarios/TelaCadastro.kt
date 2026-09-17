package com.example.cadratrousuarios

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cadratrousuarios.ui.theme.CadratroUsuariosTheme

class TelaCadastro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CadratroUsuariosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        telaCadastro()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun telaCadastro(
){
    val usuario = Usuarios()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var textoNome by remember { mutableStateOf("") }
        var textoEmail by remember { mutableStateOf("") }
        var textoTelefone by remember { mutableStateOf("") }
        // nome
        TextField(
            value = textoNome,
            onValueChange = {textoNome = it},
            readOnly = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        // email
        TextField(
            value = textoEmail,
            onValueChange = {textoEmail = it},
            readOnly = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        // telefone
        TextField(
            value = textoTelefone,
            onValueChange = {textoTelefone = it},
            readOnly = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        // Botão add
        Button(
            onClick = {
                usuario.nome = textoNome
                usuario.email = textoEmail
                usuario.telefone = textoTelefone
                Usuarios.listaUsuariosGlobal.add(usuario)

                textoNome = ""
                textoEmail = ""
                textoTelefone = ""
            }
        ) {
            Text(
                "Add"
            )
        }

        // Lista de contatos adicionados
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current
            // Lista de contatos adicionados
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(Usuarios.listaUsuariosGlobal) { usuario ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                // navegar
                                val intent = Intent(context, TelaUsuario :: class.java)
                                intent.putExtra("nome", usuario.nome)
                                intent.putExtra("email", usuario.email)
                                intent.putExtra("telefone", usuario.telefone)
                                context.startActivity(intent)
                            }
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(usuario.nome)
                            Text(usuario.email)
                            Text(usuario.telefone)
                        }
                    }
                }
            }
        }
    }
}
