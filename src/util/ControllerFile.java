package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import ui.dialog.PopUp;

import Base.Tags;
import Base.TipoDeDisco;
import Base.TipoPopUp;

/**
 * 
 * @author FrankJunior
 * 
 */
public class ControllerFile {

	private static ControllerFile instance;

	/*
	 * ---------------------------------------------------------------------
	 * Construtor
	 * ---------------------------------------------------------------------
	 */
	private ControllerFile() {

	}

	/*
	 * ---------------------------------------------------------------------
	 * Singleton
	 * ---------------------------------------------------------------------
	 */
	public static ControllerFile getInstance() {
		if (instance == null) {
			instance = new ControllerFile();
		}
		return instance;
	}

	/**
	 * Método auxiliar, para deletar uma pasta recursivamente
	 * 
	 * @param Arquivo
	 *            a ser deletado
	 */
	public void delete(File file) {
		if (file.isDirectory()) {
			// diretório ta vazio, entao, delete ele
			if (file.list().length == 0) {
				file.delete();
				Logger.debug("Diretorio foi deletado: "
						+ file.getAbsolutePath());
			} else {
				// lista todos os arquivos do diretorio
				String[] files = file.list();

				for (String temp : files) {
					// contrói a estrutura de arquivo
					File fileDelete = new File(file, temp);
					// deleta recursivo
					delete(fileDelete);
				}

				// checa o diretorio de novo, se tiver vazio, deleta
				if (file.list().length == 0) {
					file.delete();
					Logger.debug("Diretorio foi deletado: "
							+ file.getAbsolutePath());
				}
			}
		} else {
			// se for arquivo, entao, delete ele
			file.delete();
			Logger.debug("Arquivo foi deletado: " + file.getAbsolutePath());
		}
	}

	/**
	 * Método auxiliar para mover uma lista de arquivo para um diretório
	 * 
	 * @param musicas
	 * @param tempDir
	 */
	public void moveFile(List<File> musicas, File tempDir) {
		InputStream inStream = null;
		OutputStream outStream = null;
		for (int i = 0; i < musicas.size(); i++) {
			try {
				File origem = new File(musicas.get(i).getPath());
				String nomeDaMusica = musicas.get(i).getName();
				// TODO verificar se tempDir é diferente de null
				File destino = new File(tempDir.getPath() + File.separator
						+ nomeDaMusica);

				Logger.debug("Origem = " + origem.getPath());
				Logger.debug("Destino = " + destino.getPath());

				inStream = new FileInputStream(origem);
				outStream = new FileOutputStream(destino);

				byte[] buffer = new byte[1024];
				int len = 0;

				// Copiando os bytes do arquivos
				while ((len = inStream.read(buffer)) > 0) {
					outStream.write(buffer, 0, len);
				}

				inStream.close();
				outStream.close();

				// delete the original file
				origem.delete();
				Logger.debug("File is copied successful!");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método auxiliar, para criar a arvore de diretorio de acordo com a
	 * necessidade.
	 * 
	 * @param diretorioDeMusica
	 * @param listaTags
	 * @param tipoDeDisco
	 */
	public void tempDirCreate(String diretorioDeMusica,
			ArrayList<Tags> listaTags, TipoDeDisco tipoDeDisco) {

		File tempDir = null;
		switch (tipoDeDisco) {
		case NORMAL: {
			String artista = listaTags.get(0).getArtista();
			String album = listaTags.get(0).getAno()
					+ ConstantesUI.SEPARADOR_HIFEN
					+ listaTags.get(0).getAlbum();
			// Verifica se existe um artista na pasta de musica com esse nome,
			// se
			// existi, entra na pasta
			if (search(diretorioDeMusica, artista)) {
				String diretorioDoArtista = diretorioDeMusica + File.separator
						+ artista;
				/*
				 * O if está negado, pq se eu achar um album com o mesmo nome,
				 * eh pq a minha pasta de origem é exatamente essa, entao, nao
				 * precisa fazer nada ,basta setar as tags e pronto
				 */
				if (!search(diretorioDoArtista, album)) {
					Logger.debug("Existe artista, mas nao existe o album");
					tempDir = new File(diretorioDoArtista + File.separator
							+ album);
					Logger.debug("tempDir = " + tempDir.getPath());
				}
			} else {
				Logger.debug("nao tem artista com esse nome");
				tempDir = new File(diretorioDeMusica + File.separator + artista
						+ File.separator + album);
				Logger.debug("tempDir = " + tempDir.getPath());
			}
			break;
		}
		case DOUBLE: {
			String artista = listaTags.get(0).getArtista();
			String album = listaTags.get(0).getAno()
					+ ConstantesUI.SEPARADOR_HIFEN
					+ listaTags.get(0).getAlbum();
			String disco = Integer.toString(listaTags.get(0).getDiscoNumero());
			/*
			 * Verifica se existe um artista na pasta de musica com esse nome.
			 * Se existir, entra na pasta
			 */
			if (search(diretorioDeMusica, artista)) {
				String diretorioDoArtista = diretorioDeMusica + File.separator
						+ artista;
				/*
				 * Verifica se existe o album na pasta do artista. Se existir,
				 * entra na pasta
				 */
				if (search(diretorioDoArtista, album)) {
					String diretorioDoAlbum = diretorioDoArtista
							+ File.separator + album;
					/*
					 * O if está negado, pq se eu achar um CDx com o mesmo nome,
					 * eh pq a minha pasta de origem é exatamente essa, entao,
					 * nao precisa fazer nada ,basta setar as tags e pronto
					 */
					if (!search(diretorioDoAlbum, disco)) {
						Logger.debug("Existe Album, mas não existe o CD1 e CD2");
						tempDir = new File(diretorioDoAlbum + File.separator
								+ disco);
						Logger.debug("tempDir = " + tempDir.getPath());
					}
				} else {
					Logger.debug("Existe artista, mas nao existe o album");
					tempDir = new File(diretorioDoArtista + File.separator
							+ album + File.separator + disco);
					Logger.debug("tempDir = " + tempDir.getPath());
				}
			} else {
				Logger.debug("nao tem artista com esse nome");
				tempDir = new File(diretorioDeMusica + File.separator + artista
						+ File.separator + album + File.separator + disco);
				Logger.debug("tempDir = " + tempDir.getPath());
			}
			break;
		}
		case TRIBUTES: {
			String artista = listaTags.get(0).getArtista();
			String album = listaTags.get(0).getAno()
					+ ConstantesUI.SEPARADOR_HIFEN
					+ listaTags.get(0).getAlbum();
			String tributos = ConstantesUI.TRIBUTES;
			/*
			 * Verifica se existe um diretorio cahamdo "tributes" na pasta de
			 * musica Se existir, entra na pasta
			 */
			if (search(diretorioDeMusica, tributos)) {
				String diretorioTributes = diretorioDeMusica + File.separator
						+ tributos;

				/*
				 * Verifica se existe artista dentro de "Tributes". Se existir,
				 * entra na pasta
				 */
				if (search(diretorioTributes, artista)) {
					String diretorioArtista = diretorioTributes
							+ File.separator + artista;

					/*
					 * O if está negado, pq se eu achar um album com o mesmo nome,
					 * eh pq a minha pasta de origem é exatamente essa, entao,
					 * nao precisa fazer nada ,basta setar as tags e pronto
					 */
					if (!search(diretorioArtista, album)) {
						Logger.debug("nao tem album dentro de artista");
						tempDir = new File(diretorioArtista + File.separator
								+ album);
						Logger.debug("tempDir = " + tempDir.getPath());
					}
				} else {
					Logger.debug("nao tem artista dentro de Tributes");
					tempDir = new File(diretorioTributes + File.separator
							+ artista + File.separator + album);
					Logger.debug("tempDir = " + tempDir.getPath());
				}
			} else {
				Logger.debug("nao tem o diretorio Tributes");
				tempDir = new File(diretorioDeMusica + File.separator
						+ tributos + File.separator + artista + File.separator
						+ album);
				Logger.debug("tempDir = " + tempDir.getPath());
			}
			break;
		}
		case VA:{
			String album = listaTags.get(0).getAno()
					+ ConstantesUI.SEPARADOR_HIFEN
					+ listaTags.get(0).getAlbum();
			String variousArtists = ConstantesUI.VARIOUS_ARTISTS;
			/*
			 * Verifica se existe um diretorio cahamdo "Various Artists" na pasta de
			 * musica Se existir, entra na pasta
			 */
			if (search(diretorioDeMusica, variousArtists)) {
				String diretorioVA = diretorioDeMusica + File.separator
						+ variousArtists;

				/*
				 * O if está negado, pq se eu achar um album com o mesmo nome,
				 * eh pq a minha pasta de origem é exatamente essa, entao,
				 * nao precisa fazer nada ,basta setar as tags e pronto
				 */
				if (!search(diretorioVA, album)) {
					Logger.debug("nao tem album dentro de Various Artists");
					tempDir = new File(diretorioVA + File.separator + album);
					Logger.debug("tempDir = " + tempDir.getPath());
				}
			} else {
				Logger.debug("nao tem o diretorio Various Artistas");
				tempDir = new File(diretorioDeMusica + File.separator
						+ variousArtists + File.separator + album);
				Logger.debug("tempDir = " + tempDir.getPath());
			}
			break;
		}

		default:
			break;
		}

		/*
		 * Criando a arvore de Diretorio
		 */
		if (tempDir != null) {
			if (!tempDir.mkdirs()) {
				new PopUp(ConstantesUI.POPUP_FALHA_CRIACAO_DIRETORIO,TipoPopUp.ERROR);
				return;
			}
		}
	}

	/**
	 * Método auxiliar, para renomar uma lista de arquivos, baseados em uma
	 * lista de tags
	 * 
	 * @param listaTags
	 * @param musicas
	 * @param tipoDeDisco
	 */
	public void renameFile(ArrayList<Tags> listaTags, List<File> musicas,
			TipoDeDisco tipoDeDisco) {

		switch (tipoDeDisco) {
		case DOUBLE:
		case TRIBUTES:
		case NORMAL:
			for (int i = 0; i < musicas.size(); i++) {
				String path = musicas.get(i).getParent();
				String nomeCorreto = path + File.separator
						+ listaTags.get(i).getNumero()
						+ ConstantesUI.SEPARADOR_HIFEN
						+ listaTags.get(i).getNomeDaMusica()
						+ ConstantesUI.FORMATO_MP3;
				File nomeCorretoFile = new File(nomeCorreto);
				musicas.get(i).renameTo(nomeCorretoFile);
			}
			break;
		case VA:
			for (int i = 0; i < musicas.size(); i++) {
				String path = musicas.get(i).getParent();
				String nomeCorreto = path
						+ File.separator
						+ listaTags.get(i).getNumero()
						+ ConstantesUI.SEPARADOR_HIFEN
						// FIXME o getArtista() só vai deixar de vir null
						// quando os TODO do ControllerOutput for resolvido
						+ listaTags.get(i).getArtista()
						+ ConstantesUI.SEPARADOR_HIFEN
						+ listaTags.get(i).getNomeDaMusica()
						+ ConstantesUI.FORMATO_MP3;
				File nomeCorretoFile = new File(nomeCorreto);
				musicas.get(i).renameTo(nomeCorretoFile);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Método auxiliar, para procurar um disco ou um album, no diretorio de
	 * musica
	 * 
	 * @param diretorio
	 * @param name
	 * @return true se encontrou a busca, e false se nao encontrou
	 */
	private boolean search(String diretorio, String name) {
		boolean result = false;
		File diretorioDeMusicaFile = new File(diretorio);

		if (!diretorioDeMusicaFile.isDirectory()) {
			Logger.error("Nao eh um diretorio");
			return result;
		}

		if (diretorioDeMusicaFile.listFiles().length <= 0) {
			Logger.error("Diretorio vazio");
			return result;
		}

		for (int i = 0; i < diretorioDeMusicaFile.listFiles().length; i++) {
			String busca = diretorioDeMusicaFile.listFiles()[i].getName();
			// Verifica se existe, se existir, entra na pasta
			if (name.equals(busca)) {
				result = true;
				return result;
			}
		}
		return result;
	}

}