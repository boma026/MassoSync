# Backlog Inicial — MassoSync (Sprint 0 / T5)

5 histórias de usuário priorizadas (P1 = essencial ao MVP, P2 = importante, P3 = desejável).
Estimativa em pontos (escala Fibonacci: 1, 2, 3, 5, 8).

| # | Prioridade | Estimativa | História |
|---|-----------|------------|----------|
| 1 | P1 | 3 | Como **terapeuta**, quero **cadastrar um cliente com nome e telefone**, para **manter meus contatos organizados sem depender de papel**. |
| 2 | P1 | 5 | Como **terapeuta**, quero **registrar uma sessão de atendimento vinculada a um cliente, informando a técnica utilizada**, para **manter o histórico de tratamentos realizados**. |
| 3 | P1 | 3 | Como **terapeuta**, quero **visualizar o histórico de sessões de um cliente**, para **acompanhar a evolução do tratamento durante o próximo atendimento**. |
| 4 | P1 | — | Como **terapeuta**, quero **usar o aplicativo sem conexão com a internet**, para **registrar atendimentos em qualquer ambiente, mesmo sem sinal**. |
| 5 | P2 | — | Como **terapeuta**, quero **editar ou remover os dados de um cliente cadastrado**, para **manter as informações sempre atualizadas e corrigir erros de digitação**. |

## Critérios de aceite (resumo)

1. **Cadastro de cliente** — formulário com nome (obrigatório) e telefone; cliente salvo localmente e listado na tela de clientes.
2. **Registro de sessão** — formulário associado a um cliente existente, com campo de técnica (lista predefinida: massagem relaxante, reflexologia podal, termoterapia) e data; sessão salva localmente.
3. **Histórico de sessões** — lista de sessões por cliente, ordenada da mais recente para a mais antiga.
4. **Offline-first** — todas as operações acima funcionam sem rede; dados persistidos em banco local (Room/SQLDelight).
5. **Edição/remoção de cliente** — alteração dos dados cadastrados e remoção com confirmação, refletindo imediatamente na lista.
