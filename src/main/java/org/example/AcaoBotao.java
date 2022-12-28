
package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AcaoBotao implements ActionListener {

	private JTextField primeiro;
	private JTextField segundo;
	private JLabel resultado;

	public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		long valor1 = Long.parseLong(primeiro.getText());
		long valor2 = Long.parseLong(segundo.getText());
		final BigInteger[] calculo = {new BigInteger("0")};


		Thread threadCalculo = new Thread(() -> {

			for (int i = 0; i < valor1; i++) {
				for (int j = 0; j < valor2; j++) {
					calculo[0] = calculo[0].add(new BigInteger("1"));
				}
			}
			resultado.setText(calculo[0].toString());
		}, "Thread Calculator");

		threadCalculo.start();
	}

}