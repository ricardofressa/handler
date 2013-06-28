package br.com.ricardoapp.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class SomaComHandler extends ExemploBaseSoma {
	
	protected static final int SOMAR = 1;
	
	@Override
	protected void somar(final int n1, final int n2) {
		new Thread() {
			public void run(){
				int soma = n1 + n2;
				Bundle b = new Bundle();
				b.putString("resultado", String.valueOf(soma));
				Message msg = new Message();
				msg.what = SOMAR;
				// Podemos passar valores para a mensagem
				msg.setData(b);
				// Envia a mensagem para o Handler
				handler.sendMessage(msg);
			}
		}.start();

	}
	
	/** Handler utilizado para atualizar a view **/
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			switch (msg.what) {
			case SOMAR:
				// Recebe a mensagem para atualizar a view
				TextView t = (TextView) findViewById(R.id.labelSoma);
				String soma = (String) msg.getData().getString("resultado");
				t.setText(String.valueOf("Soma: "+ soma));
				break;
			default:
				break;
			}
		}
	};

}
