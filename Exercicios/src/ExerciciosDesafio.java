import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExerciciosDesafio {

	public static void main(String[] args) {

		//exercicio1();
		//exercicio2();
		//exercicio3();
		//exercicio4();
		//exercicio5();
		//exercicio6();
		//exercicio7();
		//exercicio8();
		exercicio9();



	}
	public static void exercicio1() {
		/*
		 * Inverter uma lista de string: Dada uma lista de strings, inverta sua ordem.
		 */
		List<String> lista = new ArrayList<String>();
		List<String> listaInvertida = new ArrayList<String>();
		lista = Arrays.asList("a","b","c","d","e","f");

		for (int i = lista.size()-1; i >=0 ; i--) {
			listaInvertida.add(lista.get(i));
		}
		System.out.println("Lista normal");
		lista.forEach(s->System.out.print(s));
		System.out.println("\nLista invertida");
		listaInvertida.forEach(s->System.out.print(s));
	}

	public static void exercicio2() {
		/*
		 * Dada uma lista de strings que são compostas por palavras, mas ao contrário,
		 * retorne a ordem correta.
		 */
		List<String> lista = new ArrayList<String>();
		List<String> listaInvertida = new ArrayList<String>();
		lista = Arrays.asList("yas","olleh ","dlrow ");

		listaInvertida.add(preencherInvertida(lista.get(0), new String()));
		listaInvertida.add(preencherInvertida(lista.get(1), new String()));
		listaInvertida.add(preencherInvertida(lista.get(2), new String()));

		System.out.println("Lista normal");
		lista.forEach(s->System.out.print(s));
		System.out.println("\nLista invertida");
		listaInvertida.forEach(s->System.out.print(s));
	}

	public static String preencherInvertida(String str, String strInv){
		for (int i = str.length(); i >0 ; i--) {
			strInv = strInv + (str.substring(i-1, i));
		}
		return strInv;
	}

	public static void exercicio3() {
		/* mescle duas matrizes ordenadas. */
		List<Integer> lista1 = new ArrayList<Integer>() ;
		List<Integer> lista2 = new ArrayList<Integer>();
		List<Integer> listaFinal = new ArrayList<Integer>();

		lista1 = Arrays.asList(1,4,5,2,3,6);

		System.out.println("Lista 1");
		lista1.forEach(i->System.out.print(i));
		System.out.println("\nLista 2");
		lista2.forEach(i->System.out.print(i));
		listaFinal.addAll(lista1);
		listaFinal.addAll(lista2);

		System.out.println(" \nLista Final antes");
		listaFinal.forEach(i->System.out.print(i));

		System.out.println(" \nLista Final depois");

		listaFinal.sort(((i1,i2)->{if(i1<i2)return -1; if(i1==i2) return 0; return 1;}));
		listaFinal.forEach(l->System.out.print(l));
	}

	public static void exercicio4() {
		/*
		 * Dada uma lista de tamanhos de filme (número inteiro) e uma duração de voo
		 * (número inteiro), determine se existem dois filmes que somam a duração total.
		 * Suponha que um usuário assista exatamente dois filmes, mas não o mesmo duas
		 * vezes
		 */

		int[] listaFilme = {1,3,4,5,6};
		int voo = 10;
		int filme2 = 0;
		boolean existe = false;
		for (int i = 0; i < listaFilme.length-1; i++) {
			for (int j = i+1; j < listaFilme.length; j++) {
				if(listaFilme[i]+listaFilme[j]==voo) {
					filme2 = listaFilme[j];
					existe = true;
					break;
				}
			}
			if(existe) {
				System.out.println("Existe, os filmes " + listaFilme[i] + " e " + filme2 + " somados dariam a duração do vôo");
				break;
			}	
		}
	}

	public static void exercicio5() {
		/* Dada uma string, verifique se sua permutação é um palíndromo. */

		//eu fiz
		String str = "mona lis";

		str = str.replaceAll(" ", "");

		System.out.println(str);

		String str2 = "";

		for (int i = str.length()-1; i >= 0 ; i--) {
			str2 = str2+str.charAt(i);
		}

		System.out.println(str2);

		if(str.equals(str2)) {
			System.out.println("A permutação é um palindromo");
		}
	}
	//forma linda e melhor parecido com o meu
	/*public static boolean ePalindromo(String palavra) {
		    return palavra.equals(new StringBuilder(palavra).reverse().toString());
		}*/

	//forma que querem que entregue
	/*
	 * public static boolean ePalindromo(String palavra) { int meio =
	 * palavra.length() / 2; for (int i = 0; i < meio; i++) { if (palavra.charAt(i)
	 * != palavra.charAt(palavra.length()-1 - i)) { return false; } } return true; }

	}*/
	public static void exercicio6() {
		/* Dada uma frase (string), retorne seu mapa de contagem de palavras */

		String frase = "violetas são vermelhas e eu tenho um lindo buquê, me chame de amor porque sou louco por você";
		Map<Integer, String> contador = new HashMap<Integer, String>();
		StringBuilder palavra = new StringBuilder();
		int j = 0;

		/* COMO EU FIZ
		 * for (int i = 0; i < frase.length(); i++) { if(!new
		 * Character(frase.charAt(i)).equals(' ')) { palavra.append(frase.charAt(i));
		 * if(i==frase.length()-1) contador.put(j,palavra.toString()); }else {
		 * contador.put(j,palavra.toString()); palavra.delete(0, palavra.length()); j++;
		 * } }	 
		 *System.out.println("número de palavras = " + contador);*/

		// Melhor forma
		String[] palavras = frase.split(" ");
		for (int i = 0; i < palavras.length; i++) {
			contador.put(i, palavras[i]);
		}
		System.out.println("número de palavras = " + contador);

	}

	public static void exercicio7() {
		/*
		 * Dada uma lista de pontuações não ordenadas (número inteiro) e a pontuação
		 * mais alta possível (número inteiro), retorne uma lista classificada.
		 */

		List<Integer> pontuacoes = new ArrayList<Integer>();

		pontuacoes = Arrays.asList(7,6,9,8,11,3,2);
		int maisAlta = 10;
		boolean pontUlt = false;

		System.out.println(pontuacoes);

		for (Iterator iterator = pontuacoes.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(integer.intValue()>maisAlta) {
				System.out.println("Maior pontuação não pode ultrapassar 10" );
				pontUlt = true;
			}
		}

		if(!pontUlt) {
			pontuacoes.sort((i1, i2) -> { if(i1<i2) return -1; if(i1>i2) return 1; return 0; });
			System.out.println(pontuacoes);
		}	
	}

	public static void exercicio8() {
		/*
		 * Dada uma lista de preços das ações (inteiro) em ordem cronológica, retorne o
		 * lucro máximo comprando mais cedo e vendendo mais tarde.
		 */

		Integer[] precos = {10, 7, 5, 8, 11, 9};
		int maiorLucro = 0;
		int precoMelhor = 0;
		int precoVenda = 0;

		for (int i = 0; i < precos.length-1; i++) {
			for (int j = i+1; j < precos.length; j++) {
				if(precos[j]-precos[i]>maiorLucro) {
					maiorLucro = precos[j]-precos[i];
					precoMelhor = precos[i];
					precoVenda = precos[j];

				}
			}
		}
		System.out.println("O preço de melhor lucro é " + maiorLucro + " pois você compra por " +precoMelhor+ " e vende por "+precoVenda );
	}

	public static void exercicio9() {
		/*
		 * Dada uma lista de números inteiros, retorne o produto mais alto de três
		 * números.
		 */
	}
}
