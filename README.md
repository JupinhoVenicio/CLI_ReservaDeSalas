### **Sistema de Reserva de Salas (CLI)**

## *João Vítor Cardoso da Costa*

# Descrição

    Esse projeto consiste em um Sistema de Reserva de Salas em Linha de Comando (CLI), desenvolvido na linguagem de Programação Java. O objetivo é permitir o gerenciamento de salas e suas reservas.

    O projeto foi desenvolvido com foco em boas práticas de Programação Orientada a Objetos (POO).

# Funcionalidades

    - Cadastrar salas

    - Criar reservas para salas

    - Cancelar reservas

    - Listar salas e reservas

# Estrutura do Projeto

    O projeto está organizado em múltiplas classes, cada uma com responsabilidade bem definida:

    - Sala: representa uma sala física, responsável por armazenar informações e controlar seu status (reservada ou disponível).

    - Reserva: representa uma reserva feita para em uma sala específica.

    - GerenciadorDeSalas: centraliza a lógica de criação, remoção e validação de salas e reservas.

    - Enums (MenuOpcoes e SalaStatus): utilizados para representar estados do sistema, como status da sala ou da reserva.

# Regra Importante

    Quando uma reserva é cancelada:

    - A reserva é removida da lista

    - O sistema verifica se ainda existem outras reservas para a mesma sala

    - A sala só volta a ficar disponível se não houver nenhuma outra reserva ativa

    - Isso evita erros como uma sala ficar disponível mesmo tendo reservas.

# Objetivo

    - Este projeto foi feito para aprendizado, com foco em:

    - Melhorar a lógica em Java

    - Entender melhor POO

    - Praticar organização de código