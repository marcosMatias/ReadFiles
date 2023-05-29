# Read Files

Programa para auxiliar em tarefas de leitura e escrita de arquivos em massa.

## Descrição das Classes

###  ReadFilesService
Esta classe foi construida para auxiliar na mudança de arquitetura que ocorreu no projeto Upgrade EBS 12.2.10, realiza a leitura do nome de arquivos que estão em um determinado diretorio e exibe uma saida de texto formatada pronta para ser inserida no controle de objetos Media Wiki.
0
Os parametros necessários são :
- Diretorio de origem do arquivo
- Tipo de Objeto
- Caractere para exclusão (este caractere seria a extensão do arquivo (.vw, .pck, .sql, etc))

###  UpdateFilesService
Esta classe foi construida para auxiliar na alteração das packages que foram alteradas devido ao patch core, dentro do código da classe já contem o replace de  "$Header" para "$Version" e retirar  o trecho "AUTHID CURRENT_USER".
O processo desta classe realiza a leitura do conteudo dos arquivos, cria um novo arquivo em outro diretório retirando os caracteres informados anteriormente.
A classe pode ser editada para alterar demais informações que sejam necessárias.

Os parametros necessários são :

- Diretorio de origem do arquivo
- Diretorio de destino do arquivo alterado

###  WriteFilesService
Esta classe foi construida para  escrever novos arquivos, ela é chamada dentro da classe **UpdateFilesService**
## Execução do programa
Ao baixar o programa em sua maquina deve ser executado a classe **Execute** e informando qual processo será executado, no momento temos apenas dois  **ReadFilesService** e **UpdateFilesService**.

**Importante** deve-se apenas deixar uma classe ativa para execução conforme exemplos abaixo:
- Executar  a classe **ReadFilesService** a chamada da classe **UpdateFilesService** deve estar comentada.
``` java
 ReadFilesService readFilesService = new ReadFilesService();		
		  readFilesService.readFile("G:\\GERAL\\EBS 12.2_Upgrade\\Migração de Objetos\\bkp de objetos XXMCC\\VIEWS","View","_1.sql");

      /*UpdateFilesService updateFilesService = new UpdateFilesService();		
		updateFilesService.teste("C:\\TESTE_ARQUIVOS\\PATCH_CORE\\u120TES310801\\xbol\\admin\\sql","C:\\TESTE_ARQUIVOS\\PATCH_CORE\\ALTERADOS\\"); */   
```

- Executar  a classe **UpdateFilesService** a chamada da classe **ReadFilesService** deve estar comentada.
``` java
 /*ReadFilesService readFilesService = new ReadFilesService();		
		  readFilesService.readFile("G:\\GERAL\\EBS 12.2_Upgrade\\Migração de Objetos\\bkp de objetos XXMCC\\VIEWS","View","_1.sql");*/

      UpdateFilesService updateFilesService = new UpdateFilesService();		
		updateFilesService.teste("C:\\TESTE_ARQUIVOS\\PATCH_CORE\\u120TES310801\\xbol\\admin\\sql","C:\\TESTE_ARQUIVOS\\PATCH_CORE\\ALTERADOS\\");    
```