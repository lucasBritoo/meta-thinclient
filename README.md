# Thin Client Yocto Layer

Abaixo há uma breve descrição da estrutura de diretórios presente neste repositório:

- *__conf__*: diretório destinado a conter arquivos de configuração e declaração de dependências específicas desta layer.
    - *__bblayers.conf__*: arquivo usado para configurar quais layers estão ativas no projeto. No arquivo estão listadas as camadas que serão utilizadas no build e o caminho para cada uma delas. 
    - *__layer.conf__*: arquivo principal de uma layer no Yocto. Este arquivo define as configurações específicas da camada, variáveis, classes, metadados, tarefas... Cada camada possui um arquivo layer.conf
    - *__local.conf__*: arquivo usado para configurar as variaveis de ambiente e as configuracoes locais do projeto. Neste arquivo definimos a escolha do target, configurações de imagem, diretórios de output, adição de pacotes, remoção de pacotes, definição de GPU.
    - *__conf-notes.txt__*: arquivo que contém algumas informações úteis sobre a camada e é exbido ao dev no momento do acionamento do ambiente.

- *__recipes-core__*: diretório destinado a conter arquivos de configuração base para a layer. Neste caso são definições do QT
    - *__qt5.in__* : arquivo contendo os pacotes do QT
    - *__thinclient-image.bb__* : 
- *__recipes-multimedia__*:
- *__recipes-qt__*:
- *__recipes-thinclient__*:
- *__scripts__*:



