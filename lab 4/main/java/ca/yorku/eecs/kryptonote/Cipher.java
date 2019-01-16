package ca.yorku.eecs.kryptonote;

public class Cipher
{
    private String key;
    public static final String ALPHABET ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String pad ="";

    public Cipher(String k){
        this.key = k;
    }

    public String makePad(String note){
        for(pad = this.key;pad.length()< note.length(); pad+= this.key);
        return pad;

    }

    public String encrypt(String note){
        String pad = makePad(note);
        String result ="";
        for (int i =0; i<note.length();i++){
            String c =note.substring(i, i+1);
            int positon = ALPHABET.indexOf(c);
            int shift =Integer.parseInt(pad.substring(i ,i+1));
            int newPositon =(positon + shift)% ALPHABET.length();
            result = result + ALPHABET.substring(newPositon, newPositon+1);
        }
        return result;
    }

    public String decrypt(String note){
        String pad = makePad(note);
        String result ="";
        for (int i =0; i<note.length();i++){
            String c =note.substring(i, i+1);
                int positon = ALPHABET.indexOf(c);
                int shift = Integer.parseInt(pad.substring(i, i + 1));
                if (positon - shift >= 0)
                {
                    int newPositon = (positon - shift) % ALPHABET.length();
                    result = result + ALPHABET.substring(newPositon, newPositon + 1);
                } else
                {
                    int newPositon = (ALPHABET.length() + (positon - shift)) % ALPHABET.length();
                    result = result + ALPHABET.substring(newPositon, newPositon + 1);
                }

        }
        return result;
    }
}
