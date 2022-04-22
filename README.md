# Projeto Bloco 1 - Sistema Bancário em Java

Simples sistema bancário realizado como projeto de fechamento do Bloco 1 do Bootcamp da Generation Brasil. 

![Página incial da aplicação](https://user-images.githubusercontent.com/78484194/164801696-1e0cbbca-a7d0-4bc4-adb0-9826f7d857a1.png)

## Características

O projeto realizado simula a aplicação de um banco (chamado Generation), no qual é possível criar uma conta e realizar transações bancárias básicas (tais como: saque, depósito, transferência, ver saldo e imprimir extrato). No momento do cadastro, cria-se uma pessoa, para a qual é associada uma conta (com dados gerados randomicamente). A classe Conta mantém uma lista estática (de objetos do tipo Conta) com todas as contas abertas, de modo que é possível manter o histórico de transações ao realizar o login e logout nas contas criadas. Para simular a aplicação, criamos um classe chamada Programa, simulando a interface do sistema, no qual estabelecemos as regras das entradas e tratamos os erros.

## Requerimentos do projeto

O projeto foi escolhido livremente pelo grupo, mas deveria conter os seguintes requisitos mínimos: 

- Classes, Atributos e Objetos;
- Encapsulamento;
- Herança;
- Polimorfismo: sobrecarga e sobreescrita;
- Collections;
- Exceptions;
