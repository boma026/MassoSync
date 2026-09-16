# Proposta do Projeto: MassoSync

**Disciplina:** DIM0524 — Desenvolvimento de Sistemas para Dispositivos Móveis
**Equipe:** boma026
**Repositório:** https://github.com/boma026/MassoSync

## 1. Visão do Produto
* **Para:** terapeutas autônomos.
* **Que:** perdem tempo buscando históricos de clientes e sessões passadas em cadernos de papel.
* **O:** "MassoSync" é um aplicativo móvel de registro de atendimentos.
* **Que:** centraliza os dados do cliente e os tratamentos realizados de forma rápida.
* **Diferente de:** agendas de papel e planilhas genéricas.
* **Nosso produto:** funciona sem internet no momento do atendimento e mantém o histórico sempre acessível na palma da mão.

## 2. MVP (Mínimo Produto Viável)
* **No MVP:** 
  * Cadastro simplificado de clientes.
  * Registro de sessões detalhando a técnica (ex: massagem relaxante, reflexologia podal, termoterapia).
  * Visualização do histórico de sessões.
  * Funcionamento offline.
* **Fora do MVP:** 
  * Controle financeiro e de pagamentos.
  * Agendamento online pelo cliente.
  * Geração de relatórios em PDF.
  * Múltiplos perfis de funcionários.
* **Hipótese de valor:** Acreditamos que terapeutas vão utilizar o aplicativo durante suas jornadas porque ele disponibiliza a evolução clínica na palma da mão sem depender de internet.

## 3. Stack Tecnológica e Decisões
* **Plataforma-Alvo:** Android (Prioritário). 
  * *Justificativa:* Permite o uso do emulador gratuito, garantindo que toda a equipe desenvolva sem depender de hardware específico da Apple.
* **Backend:** Supabase (Opção A). 
  * *Justificativa:* Oferece PostgreSQL e autenticação integrados com camada gratuita sem cartão de crédito, viabilizando o escopo sem custos.
* **Linguagem e UI:** Kotlin Multiplatform com Compose Multiplatform (Interface 100% compartilhada no `commonMain`).
* **Navegação e Arquitetura:** Navigation Compose, ViewModel multiplataforma com `StateFlow` e injeção de dependências via Koin.
* **Banco de Dados Local:** Room ou SQLDelight (para o modo offline).
* **Alvos de Compilação Ativos:** `androidApp`, `iosApp` e `desktopApp` (o desktop é mantido para o ciclo rápido de UI via Compose Hot Reload).
