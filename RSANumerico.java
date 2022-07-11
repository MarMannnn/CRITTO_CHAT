package com.mycompany.testmex;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthStyle;

public class RSANumerico
{
    private BigInteger P = new BigInteger("98119457177177456194561724762503888691938293642142451297968507870583737771514159291299379638843494312511987054774798425528620093256045677540267506368412110655769152899066022717382899231969388620230724848564583398802062701246682361958217103771200807946141870029213354432546296183847887638587751445008949682347");
    private BigInteger Q = new BigInteger("149336347147865278549887965757749952865985907212076429225371224200250696756834223269154275743380004182792683912899651862144353623425164765006925042161442020631777141612339616187492161886057689765039496777934852122926312447851830367844031442614398559621497552003378503400258700330187571405953939832942662475707");
    private BigInteger N = P.multiply(Q);
    private BigInteger PHI = P.subtract(BigInteger.ONE).multiply(Q.subtract(BigInteger.ONE));
    private BigInteger e; 
    private BigInteger d;
    
 
    public RSANumerico()
    {
        //P = new BigInteger("98119457177177456194561724762503888691938293642142451297968507870583737771514159291299379638843494312511987054774798425528620093256045677540267506368412110655769152899066022717382899231969388620230724848564583398802062701246682361958217103771200807946141870029213354432546296183847887638587751445008949682347");
        //Q = new BigInteger("149336347147865278549887965757749952865985907212076429225371224200250696756834223269154275743380004182792683912899651862144353623425164765006925042161442020631777141612339616187492161886057689765039496777934852122926312447851830367844031442614398559621497552003378503400258700330187571405953939832942662475707");
        //e = new BigInteger("7633168947462819717485203006812527651131230849694635025588248671905957571963977981866292752183560629682660167043421303801377638631685783259524187324016423");
        //N = P.multiply(Q);
        //PHI = P.subtract(BigInteger.ONE).multiply(Q.subtract(BigInteger.ONE));
        d = e.modInverse(PHI);
        
    }
 
    public RSANumerico(String encr)
    {
        BigInteger e = new BigInteger(encr);
        this.e = e;

    }
    
    public RSANumerico(BigInteger chiave)
    {
       d = chiave;
       
       
    }
 
    //public static void main (String [] arguments) throws IOException
    //{
       
       //RSANumerico rsa = new RSANumerico();
    

        //Scanner in = new Scanner(System.in);
        //System.out.println("Enter message you wish to send.");
        //String messaggioInserito = in.nextLine();

        //String msgB = bToS(messaggioInserito.getBytes());
        //System.out.println("il messaggio in byte è: " + msgB);
        //BigInteger messaggioDaDecifrare = new BigInteger(msgB);
     

        //BigInteger msgCriptato = rsa.encryptMessage(messaggioDaDecifrare);

        //System.out.println("il messaggio criptato è " + msgCriptato);

        //BigInteger msgDecifrato = rsa.decryptMessage(msgCriptato);
        //System.out.println("il messaggio decifrato è " + msgDecifrato);

        
        //String str = msgDecifrato.toString();
        //System.out.println("il messaggio decifrato in stringa è " + str);
    
        //String ris = rsa.asciiToSentence(str, str.length());
        //System.out.println(ris);

 
    //}   
    
    //public void setD(String a) {d = new BigInteger(a);
    //}

    private static String bToS(byte[] cipher)
    {
        String temp = "";
        for (byte b : cipher)
        {
            temp += Byte.toString(b);
        }
        return temp;
    }
    public String cifratura(String msgDaCifrare){
        String msgB = bToS(msgDaCifrare.getBytes());
        return encryptMessage(new BigInteger(msgB)).toString();
        
    }
    public String decifratura(String msgDaDecifrare){
        BigInteger msgCriptato =new BigInteger(msgDaDecifrare);
        BigInteger msgDecifrato = decryptMessage(msgCriptato); 
        String str = msgDecifrato.toString();
        int len = str.length();
        return asciiToSentence(str, len);
    }
    // Encrypting the message
    public BigInteger encryptMessage(BigInteger numeroMessaggio)
    {
        return numeroMessaggio.modPow(e, N);
    }
 
    // Decrypting the message
    public BigInteger decryptMessage(BigInteger msgDaDeci)
    {
                

        return msgDaDeci.modPow(d, N);
    }



    //CONVERTITORE ASCII TO STRING
    static String asciiToSentence(String str, int len)
    {
        String out = "";
        int num = 0;
        for (int i = 0; i < len; i++) {
 
            // Append the current digit
            num = num * 10 + (str.charAt(i) - '0');
 
            // If num is within the required range
            if (num >= 32 && num <= 126) {
 
                // Convert num to char
                char ch = (char)num;
                out=out+ch;
                // Reset num to 0
                num = 0;
            }
        }
        return out;
    }


    // casi di test su ì. 
    // scrivere spiegazione (stiamo usando un convertitore ascii)
    
}
