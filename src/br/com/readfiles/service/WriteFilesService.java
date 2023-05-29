package br.com.readfiles.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteFilesService {

	

	public void writeFiles(String diretorioDestino,String nomeArquivo,String texto) {
		
		
		
		try{
			Path caminho = Paths.get(diretorioDestino + nomeArquivo);
			BufferedWriter bw = Files.newBufferedWriter(caminho);
			bw.write(texto);
			bw.newLine();
			bw.flush();
			bw.close();
			
			
		}catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever o arquivo: "+e.getMessage());
		}
		
		
		
		

	}

}
