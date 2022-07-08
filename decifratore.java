import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthStyle;

public class decifratore 
{
    private BigInteger P;
    private BigInteger Q;
    private BigInteger N;
    private BigInteger PHI;
    private BigInteger e;
    private BigInteger d;

    public decifratore()
    {   // P e Q 2 primi molto grandi 
        P = new BigInteger("98119457177177456194561724762503888691938293642142451297968507870583737771514159291299379638843494312511987054774798425528620093256045677540267506368412110655769152899066022717382899231969388620230724848564583398802062701246682361958217103771200807946141870029213354432546296183847887638587751445008949682347");
        Q = new BigInteger("149336347147865278549887965757749952865985907212076429225371224200250696756834223269154275743380004182792683912899651862144353623425164765006925042161442020631777141612339616187492161886057689765039496777934852122926312447851830367844031442614398559621497552003378503400258700330187571405953939832942662475707");
        // encription-key (e,phi)=1 relativamente primi -> massimo comune divisiore 1.
        e = new BigInteger("7633168947462819717485203006812527651131230849694635025588248671905957571963977981866292752183560629682660167043421303801377638631685783259524187324016423");
        N = P.multiply(Q); // chiave pubblica
        //phi = (p-1)*(q-1)
        PHI = P.subtract(BigInteger.ONE).multiply(Q.subtract(BigInteger.ONE));
        // decripton-key -> ed congr 1 mod f(n)
        d = e.modInverse(PHI);}
 
    public decifratore(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }
    public static void main(String[] arguments) throws IOException
    {
        decifratore rsa = new decifratore();
        System.out.println("Inserisci messaggio da decifrare: ");
        Scanner in = new Scanner(System.in);
        String messaggioInserito = in.nextLine();// messaggio in string viene inserito qui
        
        BigInteger msgCriptato =new BigInteger(messaggioInserito);
        BigInteger msgDecifrato = rsa.decryptMessage(msgCriptato);  
        System.out.println("il messaggio decifrato è " + msgDecifrato);
        String str = msgDecifrato.toString();
        System.out.println("il messaggio decifrato in stringa è " + str);
        int len = str.length();
        asciiToSentence(str, len);
    }

    public static String bToS(byte[] cipher)
    {
        String temp = "";
        for (byte b : cipher)
        {
            temp += Byte.toString(b);
        }
        return temp;
    }

    // Decrypting the message
    public BigInteger decryptMessage(BigInteger msgDaDeci)
    {
        return msgDaDeci.modPow(d, N);
    }


    //CONVERTITORE ASCII TO STRING
    static void asciiToSentence(String str, int len)
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
                // Concat char
                out=out+ch;
                // Reset num to 0
                num = 0;
            }
        }
        // Print mex
        System.out.println("il messaggio decifrato è: "+out);
    }


}