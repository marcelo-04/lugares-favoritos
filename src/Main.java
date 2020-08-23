
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;

import javax.swing.JOptionPane;
/**
 * Classe responsável pelo fluxo de principal do projeto
 * @author Marcelo Alves Nogueira
 *
 */
public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		Locale.setDefault(Locale.US);
		
		String nomeLugar = tela("Qual o Nome do Lugar?");
		Lugar hotel = new Lugar(nomeLugar);	
		
		while(true){ 
			try {
				String avaliacaoString = tela("Qual a Avaliaçao?");
				Integer avaliacao = Integer.parseInt(avaliacaoString);
				hotel.addAvaliacao(avaliacao);
			}catch (NumberFormatException e) {
				break;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				break;
			}
		}
	
		telaMensagem(hotel);
		hotel.mostraNoMapa();
		
	}
	/**
	 * Exibe uma tela com resumo de um lugar
	 * @param hotel um lugar qualquer
	 */
	private static void telaMensagem(Lugar hotel) {
		JOptionPane.showMessageDialog(null, hotel);
	}
	
	/**
	 * Exibe uma mensagem na tela e espera input do usuário
	 * @param stringDisplay string será exibida na tela
	 * @return
	 */
	private static String tela(String stringDisplay) {
		return JOptionPane.showInputDialog(stringDisplay);
	}
}
