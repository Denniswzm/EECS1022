package ca.yorku.eecs.kryptonote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class KryptoNoteActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krypto_note);
    }

    private void setContenOfTextView(int id, String newContents){
        View view= findViewById(id);
        EditText textVie = (EditText) view;
        textVie.setText(newContents);
    }




    public void onEncrypt(View v){
        try{
            String note =((EditText)findViewById(R.id.data)).getText().toString();
            String key =((EditText)findViewById(R.id.key)).getText().toString();

            Cipher a = new Cipher(key);
            setContenOfTextView(R.id.data, a.encrypt(note));
            Toast.makeText(this,"Note Changed.", Toast.LENGTH_LONG);

        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        }

    }
    public void onDecrypt(View v){
        try{
            String note =((EditText)findViewById(R.id.data)).getText().toString();
            String key =((EditText)findViewById(R.id.key)).getText().toString();

            Cipher a = new Cipher(key);
            setContenOfTextView(R.id.data, a.decrypt(note));
            Toast.makeText(this,"Note Changed.", Toast.LENGTH_LONG);

        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        }

    }
    public void onLoad(View v){
        try{
            String name =((EditText)findViewById(R.id.file)).getText().toString();
            File dir =this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file);
            String show= "";
            for (int c = fr.read(); c!= -1; c=fr.read()){
                show +=(char)c;
            }
            fr.close();
            setContenOfTextView(R.id.data, show);
            Toast.makeText(this,"Note Loaded.", Toast.LENGTH_LONG);

        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        }
    }

    public void onSave(View v)
    {
        try{
            String name =((EditText)findViewById(R.id.file)).getText().toString();
            File dir =this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((TextView)findViewById(R.id.data)).getText().toString());
            fw.close();;
            Toast.makeText(this,"Note Saved.", Toast.LENGTH_LONG);
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        }
    }

}
