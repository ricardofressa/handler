package br.com.ricardoapp.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExemploHandler extends Activity {

	protected static final int MENSAGEM_TESTE = 1;
	private Handler handler = new TesteHandler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exemplo_handler);
		Button b = (Button)findViewById(R.id.btnEnviar);
		b.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				Message msg = new Message();
				msg.what = MENSAGEM_TESTE;
				//Envia a mensagem
				handler.sendMessageDelayed(msg, 3000);
			}
			
		});
	}
	
	/** Handler utilizado para receber a mensagem **/
	private class TesteHandler extends Handler{
		@Override
		public void handleMessage(Message msg){
			// O atributo msg.what permite identificar a mensagem
			switch (msg.what) {
			case MENSAGEM_TESTE:
				Toast.makeText(ExemploHandler.this, "A Mensagem chegou", Toast.LENGTH_SHORT).show();
				break;
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exemplo_handler, menu);
		return true;
	}

}
