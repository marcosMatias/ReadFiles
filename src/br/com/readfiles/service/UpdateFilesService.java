package br.com.readfiles.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UpdateFilesService {

	private String modificado = null;

	public void teste(String diretorioOrigem, String diretorioDestino) {

		if ((diretorioOrigem.equals("") || diretorioOrigem.isEmpty())
				|| (diretorioDestino.equals("") || diretorioDestino.isEmpty())) {

			throw new RuntimeException("O diretorio deve ser informado!");
		}

		try {

			List<File> files = Files.list(Paths.get(diretorioOrigem)).map(Path::toFile).filter(File::isFile)
					.collect(Collectors.toList());

			files.forEach(f -> {

				StringBuilder stringBuilder = new StringBuilder();

				Path caminho = Paths.get(diretorioOrigem + "//" + f.getName());

				try {

					// Stream<String> linhas = Files.lines(caminho,StandardCharsets.UTF_8);
					// Stream<String> linhas = Files.lines(caminho,Charset.defaultCharset());
					Stream<String> linhas = Files.lines(caminho, Charset.forName("Windows-1252"));

					linhas.forEach(e -> {

						stringBuilder.append(e);
						stringBuilder.append(System.lineSeparator());

					});

					modificado = stringBuilder.toString();
					System.out.println(modificado.replace("$Header", "$Version").replace("AUTHID CURRENT_USER", ""));

					WriteFilesService wf = new WriteFilesService();
					wf.writeFiles(diretorioDestino, f.getName(),
							modificado.replace("$Header", "$Version").replace("AUTHID CURRENT_USER", ""));

				} catch (IOException e) {

					System.out.println("Stream ex: " + e.getMessage());
				}

			});

		} catch (IOException ex) {
			System.out.println(ex.getMessage());

		}

	}

}
