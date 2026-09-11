package br.ufrn.imd.massosync

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import massosync.shared.generated.resources.Res
import massosync.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var mockState by remember { 
            mutableStateOf(
                ClientesUiState(
                    clientes = listOf(
                        Cliente("1", "Maria Silva", "(11) 98765-4321", "10/09/2026 - Massagem Relaxante"),
                        Cliente("2", "João Souza", "(11) 91234-5678"),
                        Cliente("3", "Ana Costa", "(21) 99999-0000", "01/09/2026 - Drenagem Linfática")
                    )
                )
            ) 
        }

        ClientesScreen(
            state = mockState,
            onClienteClick = { cliente ->
                println("Clicou no cliente: ${cliente.nome}")
            }
        )
    }
}