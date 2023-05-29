package br.com.readfiles.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReadFilesService {

	public void readFile(String diretorio,String tipoObjeto,String caractereParaExclusao) {
		
		
		if (diretorio.equals("") || diretorio.isEmpty()) {

			throw new RuntimeException("O diretorio deve ser informado!");
		}

		try {

			List<File> files = Files.list(Paths.get(diretorio))
									.map(Path::toFile)
									.filter(File::isFile)		
									.filter(not(e->e.getName().endsWith(caractereParaExclusao)))
									//.filter(e-> e.getName().startsWith("XCXP_"))
									.collect(Collectors.toList());
			
			
		

			//files.forEach(System.out::println);
			
			files.forEach(e -> {				
				System.out.println("|PRJ 3138|| Marcos Vieira || 27/03/2023 || "+e+" ||"+tipoObjeto+"||OCUPADO||");
				System.out.println("|-");
				
			});
			
		
		
		} catch (IOException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
		
		
		
		
	}
	
	
	private static <R> Predicate<R> not(Predicate<R> predicate) {
	    return predicate.negate();
	}
}
