# RH Universe - Projeto de testes JUnit

## Requisitos
- JDK 17
- Apache Maven
- NetBeans com suporte a projetos Maven

## Executar os testes
1. Abra esta pasta no NetBeans como projeto Maven.
2. Aguarde o Maven baixar a dependência do JUnit.
3. Clique com o botão direito no projeto e selecione Testar (Test).
4. Também é possível executar `mvn test` no terminal dentro desta pasta.

## Testes incluídos
- Cálculo de vencimentos.
- Cálculo de descontos.
- Cálculo do salário líquido.
- Cálculo do FGTS.
- Rejeição de percentual de FGTS inválido.

O projeto contém as classes de cálculo necessárias para que os testes sejam executados de forma independente do projeto principal e sem banco de dados.
