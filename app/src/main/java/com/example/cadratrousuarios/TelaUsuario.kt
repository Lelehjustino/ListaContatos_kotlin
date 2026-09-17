package com.example.cadratrousuarios

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.cadratrousuarios.ui.theme.CadratroUsuariosTheme

class TelaUsuario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CadratroUsuariosTheme {

                val nome = intent.getStringExtra("nome")
                val email = intent.getStringExtra("email")
                val telefone = intent.getStringExtra("telefone")


                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    telaUsuario(
                        modifier = Modifier.padding(innerPadding),
                        nome,
                        email,
                        telefone
                    )
                }
            }
        }
    }
}
@Composable
fun telaUsuario(
    modifier: Modifier = Modifier,
    nome: String?,
    email: String?,
    telefone: String?
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column() {
            val context = LocalContext.current

            Text("Nome: $nome")

            Text("Email: $email")

            Text("Telefone: $telefone")

            Button(
                onClick = {
                    val intent = Intent(context, TelaCadastro :: class.java)
                    context.startActivity(intent)
                }
            ) {
                Text(
                    "Voltar"
                )
            }
        }
    }
}