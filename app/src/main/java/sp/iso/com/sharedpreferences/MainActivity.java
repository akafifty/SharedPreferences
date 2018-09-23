package sp.iso.com.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtUsuario, txtContrasenia;

    private SharedPreferences prefs;

    private final String CORREO = "keyCorreo";
    private final String CONTRASENIA = "keyContraenia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        String correo = this.prefs.getString(CORREO,"NO_HAY_CORREO");

        txtUsuario.append(correo);

        String contrasenia = this.prefs.getString(CONTRASENIA,"NO_HAY_CONTRASENIA");

        txtContrasenia.append(contrasenia);


        //guardarCorreoContrasenia("Juanito@correo.com","pass@@12345");

    }

    private void guardarCorreoContrasenia(String correo, String contrasenia) {
        SharedPreferences.Editor editor = this.prefs.edit();
        editor.putString(CORREO,correo);
        editor.putString(CONTRASENIA,contrasenia);
        editor.apply();
    }

    private void init() {
        this.prefs = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        this.txtUsuario = findViewById(R.id.txtUsuario);
        this.txtContrasenia = findViewById(R.id.txtContrasenia);
    }
}
