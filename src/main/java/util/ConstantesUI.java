package util;

import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

/**
 * 
 * @author FrankJunior
 * 
 */
public class ConstantesUI {

	// isso é feio! nao faça isso em casa
	public static String ESPACO = "   ";
	public static String STRING_VAZIA = "";
	public static int NUMERO_1 = 1;
	public static String AINDA_NAO_IMPLEMENTADO = "Ainda não implementado";

	public static String INFO = "O MusicOrganizer serve para organizar as Metatags de arquivos de musica\n" +
			" e organiza-las no diretorio de musica.\n" +
			"Além de garantir corretamente as tags dos arquivos de MP3,\n" +
			"ele reestrutura o diretório de música do usuário, deixando todo padronizado";
	
	public static String SHORTCUTS = 
			"Abrir um disco:                  CTRL+A\n" +
			"lista de shortcut:                 CTRL+T\n" +
			"Salvar:                               CTRL+S\n" +
			"Botão \"Nome > Tag\":          CTRL+N\n" +
			"Info:                                  CTRL+i\n" +
			"mudar a pasta de música:  CTRL+1\n" +
			"mudar o idioma:                CTRL+2\n" +
			"mudar o tipo de disco:       CTRL+3";

	public static final int LARGURA_TELA = 980;
	public static final int ALTURA_TELA = 550;
	public static final int ALTURA_IMAGEM = 150;
	public static final int LARGURA_IMAGEM = 150;
	public static final String TITULO = "Music Organizer 1.0";
	public static final String LABEL_ARTISTA = "Artista";
	public static final String LABEL_ALBUM = "Album";
	public static final String LABEL_ANO = "Ano";
	public static final String LABEL_GENERO = "Genero";
	public static final String BOTAO_SALVAR = "Salvar";
	public static final String BOTAO_SALVANDO = "Salvando...";
	public static final String BOTAO_NOME2TAG = "Nome > Tag";
	public static final String RADIOBUTTON_PEGAR_DA_URL = "pegar da URL";
	public static final String RADIOBUTTON_PEGAR_DE_ARQUIVO = "pegar de um arquivo";
	public static final String BORDA_MUSICAS = "Musicas";
	public static final String BORDA_IMAGEM = "Imagem";
	public static final String BORDA_SELECIONE_UM_IMAGEM = "Selecione a imagem";
	public static final String BORDA_TAGS_GERAIS = "Tags Gerais";
	public static final String OK = "ok";
	public static final String INFORME_URL_IMAGEM = "Informe a URL da imagem";
	public static final String SELECIONE_ARQUIVO_IMAGEM = "Selecione o arquivo da imagem";
	public static final String PROCURAR = "Procurar";
	public static final String VARIOUS_ARTISTS = "Coletânia";
	public static final String TRIBUTES = "Tributos";

	// legenda
	public static final String LEGENDA = "Legenda:";
	public static final String LEGENDA_FORMATO_VA = "%s%10s%10s%10s%10s";
	public static final String LEGENDA_FORMATO = "%s%10s%10s%10s";
	public static final String LEGENDA_ARQUIVO = "Arquivo";
	public static final String LEGENDA_NUMERO = "Numeros";
	public static final String LEGENDA_FAIXA = "Faixas";
	public static final String LEGENDA_ARTISTA = "Artista";

	// Barra de Menu
	public static final String MENU_FILE = "Arquivo";
	public static final String MENU_SETTINGS = "Configurações";
	public static final String MENU_INFO = "Info";
	public static final String MENU_ITEM_OPEN = "Abrir";
	public static final String MENU_ITEM_SET_MUSIC_FOLDER = "Informar diretório de música";
	public static final String MENU_ITEM_SET_LANGUAGE = "mudar o idioma";
	public static final String MENU_ITEM_SET_DISC_TYPE = "Tipo De Disco";
	public static final String MENU_ITEM_ABOUT = "Sobre";
	public static final String MENU_ITEM_SHORTCUT = "Teclas de Atalho";

	// Shortcuts
	public static final KeyStroke CTRL_A = KeyStroke.getKeyStroke(
			KeyEvent.VK_A, InputEvent.CTRL_MASK);
	public static final KeyStroke CTRL_T = KeyStroke.getKeyStroke(
			KeyEvent.VK_T, InputEvent.CTRL_MASK);
	public static final KeyStroke CTRL_S = KeyStroke.getKeyStroke(
			KeyEvent.VK_S, InputEvent.CTRL_MASK);
	public static final KeyStroke CTRL_N = KeyStroke.getKeyStroke(
			KeyEvent.VK_N, InputEvent.CTRL_MASK);
	public static final KeyStroke CTRL_I = KeyStroke.getKeyStroke(
			KeyEvent.VK_I, InputEvent.CTRL_MASK);
	public static final KeyStroke CTRL_1 = KeyStroke.getKeyStroke(
			KeyEvent.VK_1, InputEvent.CTRL_MASK);
	public static final KeyStroke CTRL_2 = KeyStroke.getKeyStroke(
			KeyEvent.VK_2, InputEvent.CTRL_MASK);
	public static final KeyStroke CTRL_3 = KeyStroke.getKeyStroke(
			KeyEvent.VK_3, InputEvent.CTRL_MASK);
	public static final KeyStroke CTRL_4 = KeyStroke.getKeyStroke(
			KeyEvent.VK_4, InputEvent.CTRL_MASK);

	// pop-ups
	public static final String POPUP_CARREGUE_UM_DISCO = "Nenhum disco carregado. Carregue um disco primeiro";
	public static final String POPUP_DISCO_INVALIDO = "Selecione um disco válido";
	public static final String POPUP_SELECIONE_UMA_IMAGEM = "Selecione uma imagem JPG ou PNG";
	public static final String POPUP_CAMPOS_OBRIGATORIOS = "Todos os campos são obrigatórios";
	public static final String POPUP_ERRO = "Erro";
	public static final String POPUP_INFO = "Info";
	public static final String POPUP_WARNING = "Aviso";
	public static final String POPUP_IMAGE_VAZIA = "O campo image, está vazio";
	public static final String POPUP_ARQUIVO_APENAS_DE_LEITURA = "Arquivo apenas de leitura";
	public static final String POPUP_FALHA_CRIACAO_DIRETORIO = "Falha na criação do Diretório na sua pasta de música";
	public static final String POPUP_SALVO_COM_SUCESSO = "Salvo com Sucesso";
	public static final String POPUP_INFORME_DIRETORIO_DE_MUSICA = "Voce deve primeiro, informar seu diretorio de música, no menu de configuração";
	public static final String POPUP_DIRETORIO_DE_MUSICA_INVALIDO = "Diretorio de Musica nao existe. Selecione um diretorio válido no meu de Settings";
	public static final String POPUP_DIRETORIO_DE_MUSICA_VAZIO = "Diretório de Música não foi informado. Informe no menu de Settings";
	public static final String POPUP_DIRETORIO_DE_MUSICA_SALVO = "Diretório salvo com sucesso";
	public static final String POPUP_PAINEL_INVALIDO = "Opção de painel inválida";
	public static final String POPUP_DISCO_SALVO = "Arquivos não encontrados, talvez esse disco já tenha sido salvo";

	// Dialogs
	public static final String DIALOG_ESCOLHA_UM_CD = "Escolha um CD";
	public static final String DIALOG_SET_MUSIC_FOLDER = "Informe sua pasta de música";
	public static final String DIALOG_ESCOLHA_UMA_IMAGEM = "Escolha uma imagem";
	public static final String DIALOG_FILTRO = "JPG & PNG Imagens";
	public static final String DIALOG_TIPO_DE_DISCO = "escolha um tipo de disco";
	public static final String DIALOG_TIPO_DE_DISCO_TITULO = "Tipo de Disco";
	
	// Progress dialog
	public static final String PROGRESS_CARREGANDO = "Carregando Arquivos...";
	public static final String PROGRESS_DONWLOAD_IMAGE = "Baixando imagem...";
	public static final String PROGRESS_LOADING_IMAGE = "Carregando imagem...";
	public static final String PROGRESS_UPDATE_IMAGE = "Atualizando imagem...";
	public static final String PROGRESS_INICIANDO = "iniciando...";
	public static final String PROGRESS_SALVANDO = "salvando...";
	public static final String PROGRESS_NOTE_EXTRAINDO_TAGS = "Extraindo Tags";
	public static final String PROGRESS_NOTE_EXIBINDO_VALORES = "Exibindo Valores";
	public static final int PROGRESS_0 = 0;
	public static final int PROGRESS_5 = 5;
	public static final int PROGRESS_10 = 10;
	public static final int PROGRESS_20 = 20;
	public static final int PROGRESS_30 = 30;
	public static final int PROGRESS_40 = 40;
	public static final int PROGRESS_50 = 50;
	public static final int PROGRESS_60 = 60;
	public static final int PROGRESS_70 = 70;
	public static final int PROGRESS_80 = 80;
	public static final int PROGRESS_90 = 90;
	public static final int PROGRESS_100 = 100;

	// Logs
	public static final String LOG_DEBUG = "[DEBUG] ";
	public static final String LOG_INFO = "[INFO] ";
	public static final String LOG_WARNING = "[WARNING] ";
	public static final String LOG_ERROR = "[ERROR] ";

	// Erros
	public static final String ERRO_PROBLEMA_COM_A_INTERNET = "Problemas com a conexao com a internet";
	public static final String ERRO_URL_INVALIDA = "Digite uma URL válida";
	public static final String ERRO_LISTA_NULA = "Lista nula";
	public static final String ERRO_LISTA_TAGS_VAZIA = "Lista de Tags Vazia";
	public static final String ERRO_INESPERADO = "Erro Inesperado: ";
	public static final String ERRO_DISCO_SALVO = "Arquivos não encontrados";

	// Arquivos
	public static final String IMAGEM_PADRAO = "/images/imagem-padrao.jpg";

	// Properties
	public static final String ARQUIVO_DE_PROPERTIES = "config.properties";
	public static final String DIRETORIO_DE_MUSICA = "diretorioDeMusica";
	public static final String TIPO_DE_DISCO = "tipoDeDisco";
	public static final String DISC_TYPE_DEFAULT = "Normal";
	public static final String DISC_TYPE_DOUBLE = "Double Disc";
	public static final String DISC_TYPE_VA = "Various Artists";
	public static final String DISC_TYPE_TRIBUTES = "Tributes";

	// formatos
	public static final String FORMATO_MP3 = ".mp3";
	public static final String FORMATO_JPG = "jpg";
	public static final String FORMATO_PNG = "png";

	// file manager
	public static final String SEPARADOR_HIFEN = " - ";
	public static final String CD = "CD";

	// cores
	public static final Color COR_VERMELHO = new Color(255, 0, 0);
	public static final Color COR_PRETO = new Color(0, 0, 0);
	public static final Color COR_DESABILITADO = new Color(150, 150, 150);

}
