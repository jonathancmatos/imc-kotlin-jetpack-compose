# IMC Calculator - Android (Jetpack Compose)

Aplicativo Android desenvolvido com Jetpack Compose para calcular o Índice de Massa Corporal (IMC) de forma simples e intuitiva.

O objetivo do projeto é demonstrar o uso prático do Compose, Navigation, State Management e boas práticas de UI modernas no Android.


## ⚙️ Funcionalidades

Calcular o IMC (Índice de Massa Corporal)

Exibir o resultado com a classificação (baixo peso, normal, sobrepeso etc.)

Interface moderna com Jetpack Compose

Navegação entre telas com Navigation Compose

Tratamento de erros de entrada (campos vazios ou inválidos)

## 🧩 Tecnologias Utilizadas

Kotlin

Jetpack Compose

Navigation Compose

Material 3 Design

State e ViewModel

## 📱 Estrutura do Projeto
```
com.devjonathancosta.imc_calculator
├── core
│   └── router (controle de rotas e navegação)
├── ui
│   ├── views (telas principais)
│   │   ├── HomeView.kt
│   │   └── ResultView.kt
│   └── viewmodels (lógica de cálculo e estado)
└── MainActivity.kt
```

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/jonathancmatos/imc-calculator-android.git
   ```

2. Abra o projeto no **Android Studio** (versão Hedgehog ou superior).  
3. Conecte um dispositivo ou inicie um emulador Android.  
4. Clique em **Run ▶️**.  

---

## 📸 Screenshots

<div style="display: flex; justify-content: left; align-items: center;">
<img width="270" height="600" alt="Screenshot_1759578946" src="https://github.com/user-attachments/assets/8cc3f4be-cb8f-40a9-8ce1-2018a3a66528" /> 
<img width="270" height="600" alt="Screenshot_1759578949" src="https://github.com/user-attachments/assets/b33c4eab-8a67-4ffb-aeef-5c1f8be19d74" />
</div>

---

## 📄 Licença
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/) 
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)

Distribuído sob a licença **MIT**.  
Consulte o arquivo [LICENSE](LICENSE) para mais informações.
