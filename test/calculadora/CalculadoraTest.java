package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}

	@DisplayName("Testa a subtra��o de dois n�meros")
	@Test
	public void testSubtracaoDoisNumeros() {

		int subtracao = calc.subtracao(49, 7);
		Assertions.assertEquals(42, subtracao);

	}

	@DisplayName("Testa a soma dos inteiros de 0 at� 100")
	@Test
	public void testSomatoria() {

		int somatorio = calc.somatoria(100);
		Assertions.assertEquals(5050, somatorio);

	}

	@DisplayName("Testa sinais dos n�meros")
	@Test
	public void testSinais() {

		Assertions.assertFalse(calc.ehPositivo(-1));
		Assertions.assertTrue(calc.ehPositivo(0));
		Assertions.assertTrue(calc.ehPositivo(1));

	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

}
