package com.example.exemplohttp2;

import android.app.ProgressDialog;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exemplohttp2.MainActivity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class MainActivityTest {

    private MainActivity mainActivity;
    private ProgressDialog progressDialog;
    private EditText editText;
    private TextView textView;
    private ImageView imageView;

    @Before
    public void setUp() {
        mainActivity = Mockito.spy(new MainActivity());
        editText = mock(EditText.class);
        textView = mock(TextView.class);
        imageView = mock(ImageView.class);

        // Mock findViewById to return the mocked UI components
        doReturn(editText).when(mainActivity).findViewById(R.id.txtpais);
        doReturn(textView).when(mainActivity).findViewById(R.id.txthttp);
        doReturn(imageView).when(mainActivity).findViewById(R.id.idfig);
        progressDialog = mock(ProgressDialog.class);
    }

    @Test
    public void testMostrarResposta_PaisNaoCadastrado() {
        // Simula a chamada da função "mostraResposta"
        String resposta = "País não cadastrado.";
        mainActivity.mostraResposta(resposta);

        // Verifique se a visibilidade da imagem está correta
        verify(imageView).setVisibility(View.INVISIBLE);

        // Verifique se o texto foi atualizado corretamente
        verify(textView).setText("\n\n" + resposta);
    }

    @Test
    public void testMostrarResposta_PaisCadastrado() {
        // Simula a chamada da função "mostraResposta"
        String resposta = "Brasil";
        mainActivity.mostraResposta(resposta);

        // Verifique se a visibilidade da imagem está correta
        verify(imageView).setVisibility(View.VISIBLE);

        // Verifique se o texto foi atualizado corretamente
        verify(textView).setText("\n\n" + resposta);
    }
}
