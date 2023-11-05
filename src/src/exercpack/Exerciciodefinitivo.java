package exercpack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Exerciciodefinitivo {

	 public static void main(String[] args) throws IOException {
	        // Obtendo o mês atual
	        Calendar cal = Calendar.getInstance();
	        int mesAtual = cal.get(Calendar.MONTH);

	        // Criando o arquivo texto de entrada
	        File fileEntrada = new File("C:\\Users\\barba\\Desktop\\Desafio2-da-ModalGR\\src\\src\\exercpack\\consultores.txt");

	        // Criando o arquivo texto de saída
	        File fileSaida = new File("C:\\Users\\barba\\Desktop\\Desafio2-da-ModalGR\\src\\src\\exercpack\\aniversariantes-" + (mesAtual+1) + ".txt");

	        // Verificando se o arquivo de saída existe
	        if (fileSaida.exists()) {
	            // Removendo o arquivo de saída
	            fileSaida.delete();
	        }

	        // Criando um buffer de leitura
	        BufferedReader reader = new BufferedReader(new FileReader(fileEntrada));

	        // Criando um buffer de escrita
	        BufferedWriter writer = new BufferedWriter(new FileWriter(fileSaida));

	        // Lendo as linhas do arquivo de entrada
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	            // Separando os dados do consultor
	            String[] dados = linha.split(Pattern.quote("|"));

	            // Validando a data de nascimento
	            String dataNascimento = dados[2];

	            // Crie um objeto SimpleDateFormat
	            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	            try {
	                // Converta a data de nascimento em um objeto Date
	                Date dataNascimentoFormatada = sdf.parse(dataNascimento);
	            } catch (ParseException e) {
	                // Data de nascimento inválida
	                System.out.println("Data de nascimento inválida: " + dataNascimento);
	                continue;
	            }

	            // Obtém a data de nascimento do consultor
	            Date dataNascimentoFormatada = null;
				try {
					dataNascimentoFormatada = sdf.parse(dataNascimento);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}

	            // Verifica se o consultor é aniversariante
	            Calendar calNascimento = Calendar.getInstance();
	            calNascimento.setTime(dataNascimentoFormatada);
	            int mesNascimento = calNascimento.get(Calendar.MONTH);
	            if (mesNascimento == mesAtual) {
	                // Adiciona os dados do consultor ao arquivo de saída
	                writer.write(linha + "\n");
	            }
	        }

	        // Fecha os buffers
	        reader.close();
	        writer.close();
	    }
	}


