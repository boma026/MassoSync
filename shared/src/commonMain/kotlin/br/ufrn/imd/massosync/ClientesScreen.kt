package br.ufrn.imd.massosync

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// 1. Modelo de Dados Simplificado
data class Cliente(
    val id: String,
    val nome: String,
    val telefone: String,
    val ultimaSessao: String? = null
)

// 2. Estado Elevado (UiState)
data class ClientesUiState(
    val isLoading: Boolean = false,
    val clientes: List<Cliente> = emptyList()
)

// 3. Componente Isolado (Cartão do Cliente)
@Composable
fun ClienteCard(
    cliente: Cliente,
    onClick: (Cliente) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        onClick = { onClick(cliente) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = cliente.nome,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "📱 ${cliente.telefone}",
                style = MaterialTheme.typography.bodyMedium
            )
            if (cliente.ultimaSessao != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Última sessão: ${cliente.ultimaSessao}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

// 4. Tela Principal que recebe o Estado Elevado
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientesScreen(
    state: ClientesUiState,
    onClienteClick: (Cliente) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meus Clientes") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (state.clientes.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Nenhum cliente cadastrado.")
            }
        } else {
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.clientes) { cliente ->
                    ClienteCard(
                        cliente = cliente,
                        onClick = onClienteClick
                    )
                }
            }
        }
    }
}

// 5. Previews (Permite visualizar sem rodar o app inteiro)
@Preview
@Composable
fun ClienteCardPreview() {
    MaterialTheme {
        ClienteCard(
            cliente = Cliente("1", "Maria Silva", "(11) 98765-4321", "10/09/2026 - Massagem Relaxante"),
            onClick = {}
        )
    }
}

@Preview
@Composable
fun ClientesScreenPreview() {
    val mockState = ClientesUiState(
        clientes = listOf(
            Cliente("1", "Maria Silva", "(11) 98765-4321", "10/09/2026"),
            Cliente("2", "João Souza", "(11) 91234-5678"),
            Cliente("3", "Ana Costa", "(21) 99999-0000", "01/09/2026")
        )
    )
    MaterialTheme {
        ClientesScreen(
            state = mockState,
            onClienteClick = {}
        )
    }
}
