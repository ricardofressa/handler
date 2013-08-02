package br.com.ricardoapp.handler;

import android.widget.TextView;

public class SomaComRunOnUiThread extends ExemploBaseSoma {

	@Override
	protected void somar(final int n1, final int n2) {
				final int soma = n1 + n2;
				// Atualiza a interface da tela com atalho para handler
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						// recebe a mensagem para atualizar a view
						TextView t = (TextView) findViewById(R.id.labelSoma);
						t.setText(String.valueOf("Soma: "+ soma));
					}
				});
	}
}
