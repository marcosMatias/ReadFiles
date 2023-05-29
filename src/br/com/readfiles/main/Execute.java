package br.com.readfiles.main;


import br.com.readfiles.service.UpdateFilesService;


public class Execute {

	public static void main(String[] args) {
		
		/*ReadFilesService readFilesService = new ReadFilesService();		
		  readFilesService.readFile("G:\\GERAL\\EBS 12.2_Upgrade\\Migração de Objetos\\bkp de objetos XXMCC\\VIEWS","View","_1.sql");*/
		
		
		UpdateFilesService updateFilesService = new UpdateFilesService();		
		updateFilesService.teste("C:\\TESTE_ARQUIVOS\\PATCH_CORE\\u120TES310801\\xbol\\admin\\sql","C:\\TESTE_ARQUIVOS\\PATCH_CORE\\ALTERADOS\\");

		
	}

}
