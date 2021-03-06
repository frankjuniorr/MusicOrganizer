package view.paineis;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Facade.Facade;

import util.ConstantesUI;
import util.Logger;
import view.listener.UpdateImageListener;
/**
 * 
 * @author FrankJunior
 *
 */
@SuppressWarnings("serial")
public class PainelImagem extends JPanel implements UpdateImageListener {

	private Image imagemOriginal = convertImage(Facade.getInstace().loadDefaultImage());
	
	public PainelImagem() {
		initComponents();
	}

	/**
	 * Inicializa componentes visuais
	 */
	private void initComponents(){
		Image imagem = getScaledImage(imagemOriginal, ConstantesUI.LARGURA_IMAGEM, ConstantesUI.ALTURA_IMAGEM);
		this.setBorder(BorderFactory.createTitledBorder(ConstantesUI.BORDA_IMAGEM));
		this.setLayout(new BorderLayout());
		this.add(new JLabel(new ImageIcon(imagem)),BorderLayout.CENTER);
		this.repaint();
		this.revalidate();
	}
	
	/**
	 * Método para converter um byte[] para um BufferedImage.
	 * Usado para pegar a imagem default da Facade, e passar pra classe
	 * de PainelImagem como um BufferedImage
	 * @param defaultImage
	 * @return
	 */
	private Image convertImage(byte[] defaultImage) {
		InputStream in = new ByteArrayInputStream(defaultImage);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(in);
		} catch (IOException e) {
			Logger.error(e.getMessage());
		}
		return bi;
	}
	
	/**
	 * Método para atualizar a imagem
	 * @param image
	 */
	@Override
	public void updateImage(byte[] image) {
		
		this.removeAll();
		try {
			if (image != null) {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(image);
			ImageInputStream imageInputStream = ImageIO.createImageInputStream(byteArrayInputStream);
			imagemOriginal = ImageIO.read(imageInputStream);
			initComponents();
			}
			
		} catch (IOException e) {
			Logger.error(e.getMessage());
		}
	}
	
	/**
	 * Método para redimensionar a imagem, indepenente do tamanho que ela venha
	 * @param imagemOriginal
	 * @param largura
	 * @param altura
	 * @return Imagem redimensionada
	 */
	private Image getScaledImage(Image imagemOriginal, int largura, int altura) {
		  BufferedImage resizedImg = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		    Graphics2D g2 = resizedImg.createGraphics();
		    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g2.drawImage(imagemOriginal, 0, 0,largura, altura, null);
		    g2.dispose();
		    return resizedImg;
	}

	public Image getImagemOriginal() {
		return imagemOriginal;
	}
	
	
}
