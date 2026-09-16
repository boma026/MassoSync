package br.ufrn.imd.massosync

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

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
