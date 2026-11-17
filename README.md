# Territory Predictive Insights - CitizenTech
Projeto da Global Solution 2026 (POO) focado em monitoramento territorial para prevenção de alagamentos.

## Integrantes
- **Christian Raymundo Diaz - RM568324**

## Estrutura Obrigatória Concluída
O projeto já possui a base solicitada no edital:
- `ComponenteTerritorial.java` (classe abstrata)
- `Sensor.java` (interface)
- `SensorChuva.java`, `SensorNivelRio.java`, `SensorUmidade.java` (implementações da interface)
- `EstacaoDeColeta.java` (herda de ComponenteTerritorial)
- `DadosTerritorio.java` (encapsulamento)
- `EstrategiaPrevisao.java` (classe abstrata)
- `PrevisaoMediaMovel.java`, `PrevisaoComparacao.java` (herança)
- `SistemaMonitoramento.java` (menu principal)


## Como Executar o Projeto

### Pré-requisitos
- Ter o **Java JDK** instalado (versão 8 ou superior).
- Ter uma IDE de preferência (IntelliJ IDEA, Eclipse ou VS Code) ou usar o terminal.

### Passo a Passo (Via Terminal)

1. Abra o terminal na pasta raiz do projeto (`territory-predictive-insights`).
2. Compile todos os arquivos Java que estão na raiz:
   ```bash
   javac *.java
   ```
3. Execute a classe principal (SistemaMonitoramento):
    ```bash 
      java SistemaMonitoramento
    ```
### Passo a Passo (Via IntelliJ IDEA)
1. Abra o projeto no IntelliJ.
2. Aguarde a indexação dos arquivos.
3. Na aba "Project" (barra lateral esquerda), abra o arquivo **`SistemaMonitoramento.java`** (que está na raiz do projeto).
4. Clique no botão **Play (►)** ao lado do método `public static void main` ou pressione `Shift + F10`.
5. 
## Roteiro de Teste Rápido
Para validar o funcionamento do sistema, siga este roteiro:

1. **Coletar Leituras:** Escolha a opção `1` no menu pelo menos 3 vezes para alimentar o histórico.
2. **Rodar Previsões:** Escolha a opção `2`. O sistema exibirá a previsão para os 3 sensores (Chuva, Rio e Umidade) com os respectivos níveis de alerta (ATENÇÃO, ALERTA ou CRÍTICO).
3. **Testar a Segurança (Senha Errada):** Escolha a opção `3`, digite uma senha errada (ex: `TESTE`). O sistema deve bloquear imediatamente com a mensagem `[ACESSO NEGADO]`.
4. **Testar a Segurança (Senha Correta):** Escolha a opção `3`, digite a senha `GLOBAL2026`, escolha o limite `1` (Chuva) e digite `10`. O sistema deve confirmar a alteração.
5. **Testar a Rejeição de Dados Inválidos:** Escolha a opção `3`, digite a senha correta, escolha o limite `1` e digite `-5`. O sistema deve rejeitar com a mensagem `[REJEITADO]`.
6. **Sair:** Escolha a opção `0` para encerrar o sistema.

## Público Beneficiado
Moradores da Vila Esperança (12.000 pessoas) e a Defesa Civil local. O sistema apoia a decisão de quando acionar equipes de prevenção e evacuação antes que chuvas intensas causem alagamentos. A análise é feita por três sensores: chuva (mm), nível do rio (m) e umidade (%), permitindo uma visão completa do risco.

## Reflexão Crítica
*Quando o sistema deve se calar?*
O sistema deve evitar emitir alertas com menos de 5 leituras no histórico. Com poucos dados, a média móvel e a comparação de períodos são muito instáveis e podem gerar falsos positivos. O sistema atual exibe um aviso quando há menos de 2 leituras, mas o ideal seria silenciar alertas até que uma base sólida de dados fosse coletada.

*O que os dados não representam?*
Um único sensor por região não captura as micro-áreas (como ruas específicas, bueiros entupidos ou encostas). O sistema não substitui a vistoria de campo e o conhecimento empírico dos moradores locais, que sabem exatamente onde a água costuma acumular. O alerta é uma ferramenta de apoio, não um diagnóstico definitivo.

*Por que o alerta apoia e não decide?*
O sistema não tem autoridade para evacuar famílias ou fechar vias. Ele informa a probabilidade e a tendência, mas a decisão final deve ser tomada por humanos (Defesa Civil), considerando o contexto real: obras em andamento, capacidade de resposta, eventos na cidade e o conhecimento local.


## Decisões
- **Recorte:** Clima local (chuva, nível do rio, umidade).
- **Simulação:** Uso de Math.random() em faixas realistas para gerar as leituras dos sensores.
- **Alertas:** Classificação em 3 níveis baseada na proporção do valor previsto em relação ao limite (ATENÇÃO, ALERTA, CRÍTICO) para cada um dos três sensores.
- **Segurança:** Uso de senha (GLOBAL2026) na classe DadosTerritorio para alterar os limites, protegendo os dados sensíveis da comunidade.

## Escalabilidade e Melhorias Futuras (Ambiente Profissional)
Em um ambiente profissional, o sistema poderia evoluir com:
1. *Tratamento de Exceções:* Implementar try/catch nas leituras do Scanner em todas as leituras de Scanner (tanto no menu quanto na alteração de limites) para tratar erros de digitação. Isso garante que o usuário não consiga quebrar o programa digitando letras onde se espera números.
2. **Criptografia:** Armazenar a senha com hash SHA-256 em um banco de dados, em vez de uma constante no código-fonte.
3. **Persistência:** Salvar o histórico de leituras em um banco de dados para manter os dados após fechar o programa.
4. **Separação MVC:** Dividir o sistema em camadas (Model, View, Controller) para desacoplar a interface da lógica de negócio.
5. **Múltiplos Sensores por Região:** Permitir o cadastro de múltiplos pontos de coleta no mesmo território para uma visão mais granular do risco (ex: encostas, bueiros, rios).

## Uso de IA
- Compreender a diferença entre os modificadores de acesso protected e private na herança.
- Esclarecer a diferença entre extends (herança) e implements (interface).
- Entender o funcionamento do super() nas classes filhas.
- Discutir as funcionalidades dos sensores no contexto real de alagamentos.

## Divisão de Tarefas
Projeto Individual: Todas as etapas foram realizadas pelo mesmo integrante.
- **CHRISTIAN RAYMUNDO DIAZ**
- **Responsabilidades:** Criação das classes abstratas e interfaces, implementação dos sensores, encapsulamento da classe DadosTerritorio, desenvolvimento das estratégias de previsão, sistema de alertas em 3 níveis e menu interativo. Testes de mesa e documentação do projeto.
