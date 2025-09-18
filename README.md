# 🦁 ZooManager

Um sistema de gerenciamento de zoológico desenvolvido em **Java**, com foco em praticar conceitos avançados da linguagem: exceptions personalizadas, collections, streams, threads e organização em camadas.

---

## 📌 Premissa do Projeto
O ZooManager tem como objetivo controlar os principais elementos de um zoológico: **animais, recintos, tratadores, visitantes e eventos**.  
O sistema permite cadastro, consultas, emissão de relatórios e execução de tarefas em paralelo.

---

## 🚀 Funcionalidades

### 1. Animais
- Cadastro de animais com **nome, espécie, idade, dieta e status de conservação**.  
- Organização em **recintos (enclosures)**.  
- Implementação de equals e hashCode para comparação via **ID único**.

### 2. Recintos
- Definição de **capacidade máxima** e controle de lotação.  
- Lançamento da **OverCapacityException** ao ultrapassar a capacidade.

### 3. Tratadores e Tarefas
- Cada tratador é responsável por um conjunto de animais.  
- Tarefas: **alimentação**, **mudar estados de saude dos animais** e **checagem de saúde**.  
- Uso de **threads** ou ExecutorService para simular execução em paralelo.  
- Caso a dieta do animal seja inválida, lançar **FeedingException**.

### 4. Bilheteria e Visitantes
- Venda de ingressos com registro de visitantes.  
- Armazenamento em **collections (List, Set, Map)**.  
- Relatórios usando **Streams** (ex: filtrar maiores de idade, agrupar por tipo de ingresso).

### 5. Eventos
- Eventos como *“alimentação pública”* ou *“passeio guiado”* gerenciados em **BlockingQueue**.  
- Processamento em paralelo via **threads**.

### 6. Relatórios e Consultas
- Relatório de animais por recinto.  
- Relatório de animais por dieta ou status de conservação.  
- Relatório de tratadores e seus animais.

---

## 🛠️ Requisitos Técnicos
- **Exceptions personalizadas**:  
  - AnimalNotFoundException 
  - OverCapacityException
  - FeedingException
  - E mais...

- **Uso de final** em constantes e classes utilitárias.  
- **Collections**: ArrayList, HashSet, HashMap, BlockingQueue.  
- **Streams**: filtros, agrupamentos, ordenações.  
- **Threads/Executors** para tarefas concorrentes.  
- **Organização em camadas**: domínio, serviços, exceções, relatórios, utilitários.  
- **Classe Main** para simular todo o sistema.

---

## 📂 Estrutura do Projeto (até agora)

```bash
ZOOLOGICO/
└── src/
    ├── controller/
    │   └── (em breve controllers para orquestrar services)
    │
    ├── exceptions/
    │   ├── AnimalNotFoundException.java
    │   ├── DietaNotFoundException.java
    │   ├── FeedingException.java
    │   ├── OverCapacityException.java
    │   └── ResourceNotFoundException.java
    │
    ├── model/
    │   ├── enums/
    │   │   ├── Dieta.java
    │   │   ├── DocumentoIdentificacao.java
    │   │   └── Evento.java
    │   │
    │   ├── Animal.java
    │   ├── Bilheteria.java
    │   ├── Recinto.java
    │   ├── Tratador.java
    │   └── Visitante.java
    │
    ├── service/
    │   ├── AnimalService.java
    │   ├── BilheteriaService.java
    │   ├── EventoService.java
    │   ├── RecintoService.java
    │   ├── RelatorioService.java
    │   ├── TratadorService.java
    │   └── VisitanteService.java
    │
    ├── utils/
    │   └── Logger.java
    │
    └── Main.java
│
├── .gitattributes
├── LICENSE
└── README.md

