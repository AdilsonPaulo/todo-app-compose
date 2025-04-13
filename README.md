Este é um aplicativo de tarefas simples desenvolvido com **Jetpack Compose**, que permite ao usuário criar, visualizar e gerenciar tarefas do dia a dia.

## Funcionalidades

- Adicionar tarefas com título e data
- Listagem de tarefas
- Marcar como concluída e deletar tarefas
- Alerta de confirmação antes de excluir

## Tecnologias Utilizadas

- Kotlin
- Jetpack Compose
- Android Studio
- Gradle

## Estrutura do Projeto

O projeto está dividido em pacotes conforme a responsabilidade de cada parte:

```
com.adilson.firstapplication
├── data              # Fonte de dados
├── domain.model      # Modelos principais (Task)
├── navigation        # Lógica de navegação
├── ui.theme          # Cores, Tipografia e Tema
├── utils             # Utilitários (ex: funções de data)
└── view
    ├── screens       # Telas do app (formulário, lista, etc.)
    └── ui_components # Componentes reutilizáveis
```

## Autor

Desenvolvido por **Adilson Paulo da Silva Aquino** como parte de estudos práticos em desenvolvimento Android.
