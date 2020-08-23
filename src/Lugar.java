
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
/**
 * Representa um lugar no nosso código
 * @author Marcelo Alves Nogueira
 *
 */
public class Lugar {
	
	private String nome;
	private List<Integer> avaliacoes =  new ArrayList<Integer>();
	
	public Lugar(String stringQualquer) {
		this.nome = stringQualquer.toUpperCase();
	}
	
	/**
	 * Exibe o nome do lugar utilizado a api do google maps
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void mostraNoMapa() throws IOException, URISyntaxException {
		String nomeUrl = this.nome.replace(" ", "%20");
		Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/?api=1&query="
		+ nomeUrl));	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	/**
	 * Adiciona uma avaliação na lista de avaliações do lugar.
	 * @param avaliacao
	 * @throws Exception
	 */
	public void addAvaliacao(int avaliacao) throws Exception {	
		if(avaliacao < 0 || avaliacao > 5) {
			throw new Exception("A avaliação deve ter de 1 a 5 estrelas!");
		}
		this.avaliacoes.add(avaliacao);
	}
	
	/**
	 * Calcula o total de avaliações que o lugar teve
	 * @return total de avaliações 
	 */
	public Integer totalDeAvaliacoes() {
		return this.avaliacoes.size();
	}
	
	/**
	 * Calcula a média de avaliações que o lugar teve
	 * @return média de avaliações 
	 */
	public Double avaliacaoMedia() {	
		return somaDasAvaliacoes() / totalDeAvaliacoes();
		
	}
	
	/**
	 * Calcula a soma de totas as avaliações que o çugar teve
	 * @return soma de todas as avaliações 
	 */
	private double somaDasAvaliacoes() {
		double soma = 0d;
		
		for (Integer avaliacao : avaliacoes) {
			soma += avaliacao;
		}
		return soma;
	}
	
	/**
	 * Retorna o Status da avaliação
	 * @return
	 */
	public String avaliacaoStatus() {
		double media = avaliacaoMedia();
		if(media < 3 ) {
			return "Ruim!";
		} else if(media >= 3 && media <= 4) {
			return "Razoavel!";
		} else if(media > 4) {
			return "Muito bom!";
		} else {
			return "Status Inválidos!";
		}
	}
	
	@Override
	public String toString() {
		
		return "Nome: "+ nome +"\n"
				+ "Total de Avaliações: "+ totalDeAvaliacoes() +"\n"
				+ "Média: "+ avaliacaoMedia() + "\n"
				+ "Status: "+ avaliacaoStatus();
	}
	
}
