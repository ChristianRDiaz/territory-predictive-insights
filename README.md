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

**1. Clone o repositório (se ainda não baixou):**

Abra o terminal e navegue até a pasta onde deseja salvar o projeto (ex: Área de Trabalho/Desktop). Depois, rode:

   ```bash
   git clone https://github.com/ChristianRDiaz/territory-predictive-insights.git
   ```
**2. Entre na pasta do projeto:** 
   ```bash 
   cd territory-predictive-insights
   ```
**3. Compile todos os arquivos Java:**
   ```bash
   javac *.java
   ```
- (Nota: No Windows e na maioria dos Macs, este comando funciona perfeitamente. Caso o terminal do Mac (zsh) retorne um erro de "no matches found", utilize:  javac "*.java")
  
**4. Execute a classe principal (SistemaMonitoramento):**

 ```bash
 java SistemaMonitoramento
 ```
    
### Passo a Passo (Via IntelliJ IDEA)
1. Abra o projeto no IntelliJ.
2. Aguarde a indexação dos arquivos.
3. Na aba "Project" (barra lateral esquerda), abra o arquivo **`SistemaMonitoramento.java`** (que está na raiz do projeto).
4. Clique no botão **Play (►)** ao lado do método `public static void main` ou pressione `Shift + F10`.
   
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
**1. Quando o sistema deve se calar?**
- O sistema deve evitar emitir alertas críticos quando há menos de 5 leituras no histórico de dados. Com poucos registros, métricas como a média móvel e a comparação de períodos tornam-se altamente instáveis, o que pode gerar falsos positivos.
- Embora o software possa registrar avisos iniciais com menor volume de dados, o ideal é silenciar alarmes definitivos até que uma base sólida de leituras seja coletada, prevenindo o esgotamento da credibilidade da ferramenta por ruídos momentâneos de hardware

**2. O que os dados não representam?**
- Um único sensor por região é incapaz de capturar a complexidade microterritorial, como o impacto de ruas específicas, bueiros entupidos ou variações topográficas de encostas.
- O dado quantitativo e os indicadores estatísticos traduzem tendências gerais, mas não substituem a vistoria de campo nem o conhecimento empírico dos moradores, que conhecem a dinâmica real de escoamento local. 
- O alerta funciona como um indicador de tendência, e não como um retrato absoluto da realidade.

**3. Por que o alerta apoia e não decide?**
- O software atua como um suporte analítico e não possui autoridade nem empatia ou contexto situacional para determinar ações drásticas como evacuações ou interdições de vias. 
- Ele processa regras de negócio e aponta probabilidades de risco, mas a tomada de decisão final cabe sempre aos operadores humanos e à Defesa Civil, ponderando variáveis qualitativas, capacidade de resposta da comunidade e o conhecimento humano.

**4. O limite entre o risco técnico e a vulnerabilidade social:**
- O sistema emite alertas baseados exclusivamente em limiares numéricos de precipitação ou nível de água, contudo, o mesmo volume de chuva impacta de formas totalmente distintas diferentes populações. 
- Uma comunidade com infraestrutura urbana pavimentada e saneamento adequado suporta índices pluviométricos que seriam catastróficos em uma área de ocupação vulnerável sem escoamento adequado.

**5. A latência entre a previsão algorítmica e a reação humana:**
- As estratégias de previsão (como média móvel ou comparação de períodos) trabalham com dados passados e tendências matemáticas, operando em uma linha do tempo estritamente lógica, enquanto o tempo atmosférico e a resposta humana possuem dinâmicas imprevisíveis. 
- Um alerta gerado após o cruzamento de um limiar estatístico perde o sentido se o tempo necessário para evacuar uma área de risco ou acionar os moradores for superior ao avanço real da enchente. A eficácia depende tanto da precisão do código quanto da velocidade operacional de quem recebe a informação.

**6. O desafio dos falsos alarmes e o desgaste da confiança operacional:**
- Em sistemas baseados em limiares fixos, existe um equilíbrio delicado: limites muito sensíveis geram falsos positivos constantes, enquanto limites conservadores geram alarmes tardios.
- Se o software emitir alertas críticos com muita frequência devido a ruídos momentâneos dos sensores (como pancadas rápidas de chuva que cessam logo em seguida), a comunidade e os operadores tendem a banalizar o aviso.


## Decisões
- **Recorte:** Clima local (chuva, nível do rio, umidade).
- **Simulação:** Uso de Math.random() em faixas realistas para gerar as leituras dos sensores.
- **Alertas:** Classificação em 3 níveis baseada na proporção do valor previsto em relação ao limite (ATENÇÃO, ALERTA, CRÍTICO) para cada um dos três sensores.
- **Segurança:** Uso de senha (GLOBAL2026) na classe DadosTerritorio para alterar os limites, protegendo os dados sensíveis da comunidade.

## Escalabilidade e Melhorias Futuras (Ambiente Profissional) :white_check_mark: :rocket:
Em um ambiente profissional, o sistema poderia evoluir com:

 **Parte 1: Engenharia de Software, Robustez e Arquitetura**  :key: :computer:
 
 **Focada em boas práticas de programação, segurança e resiliência do sistema atual:**
 - Tratamento de Exceções: Implementar blocos try/catch nas leituras do Scanner em todas as interações (menu e alteração de limites) para tratar erros de digitação de forma robusta, impedindo que o programa quebre caso o usuário insira letras onde se esperam números.
 - **Criptografia:** Migrar o armazenamento de senhas sensíveis para um banco de dados utilizando hashing seguro (como SHA-256), em vez de mantê-las estáticas no código-fonte.
 - **Persistência de Dados:** Salvar o histórico de leituras e o estado dos sensores em um banco de dados relacional ou não relacional, garantindo que as informações não sejam perdidas ao fechar o programa.
 - **Separação de Camadas (MVC):** Desacoplar a interface de texto da lógica de negócio dividindo a arquitetura em Model, View e Controller, facilitando a manutenção e testes.
 - **Múltiplos Sensores por Região:** Permitir o cadastro escalável de vários pontos de coleta no mesmo território para obter uma visão microterritorial mais granular do risco (ex: monitorando encostas, bueiros e rios simultaneamente).

**Parte 2: Evolução Analítica (Data Science, Machine Learning & Deep Learning)** :robot: :bar_chart:

**Focada na aplicação de inteligência artificial preditiva e tratamento avançado de dados:**
- **Redes Neurais Convolucionais (CNNs):** Aplicadas para processar dados geoespaciais e matrizes temporais de sensores distribuídos. Como as CNNs se destacam na extração de padrões espaciais, elas poderiam analisar a grade de sensores do território como uma matriz ou mapa térmico, identificando correlações complexas (como o impacto de um sensor de cabeceira de rio sobre as áreas de várzea inferiores).
- **Modelos Preditivos e Séries Temporais:** Utilização de dados históricos plurianuais de precipitação para treinar modelos capazes de antecipar picos de cheias com horas de antecedência.
- **Agrupamento com K-Means (Clustering):** Aplicar aprendizado de máquina não supervisionado para agrupar as regiões do território de acordo com o comportamento dinâmico dos sensores, mapeando automaticamente zonas de risco semelhante.
- **Engenharia de Dados e Limpeza de Ruído:** Implementar rotinas automatizadas para remoção de outliers causados por falhas de hardware e imputação de valores faltantes, garantindo KPIs e indicadores estatísticos altamente confiáveis para a Defesa Civil.

 

## Uso de IA
- Compreender a diferença entre os modificadores de acesso protected e private na herança.
- Esclarecer a diferença entre extends (herança) e implements (interface).
- Entender o funcionamento do super() nas classes filhas.
- Discutir as funcionalidades dos sensores no contexto real de alagamentos.

## Divisão de Tarefas
Projeto Individual: Todas as etapas foram realizadas por mim **CHRISTIAN RAYMUNDO DIAZ**
- **Responsabilidades:** Criação das classes abstratas e interfaces, implementação dos sensores, encapsulamento da classe DadosTerritorio, desenvolvimento das estratégias de previsão, sistema de alertas em 3 níveis e menu interativo. Testes de mesa e documentação do projeto.
