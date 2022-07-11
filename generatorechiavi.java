/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testmex;

import java.math.BigInteger;
import java.util.Random;
/**
 *
 * @author marman
 */
public class generatorechiavi {
       private BigInteger a;
       private BigInteger P;
       private BigInteger Q;
       private BigInteger PHI;
       
       public generatorechiavi(){
        
        P = new BigInteger("98119457177177456194561724762503888691938293642142451297968507870583737771514159291299379638843494312511987054774798425528620093256045677540267506368412110655769152899066022717382899231969388620230724848564583398802062701246682361958217103771200807946141870029213354432546296183847887638587751445008949682347");
        Q = new BigInteger("149336347147865278549887965757749952865985907212076429225371224200250696756834223269154275743380004182792683912899651862144353623425164765006925042161442020631777141612339616187492161886057689765039496777934852122926312447851830367844031442614398559621497552003378503400258700330187571405953939832942662475707");
       
        PHI =  P.subtract(BigInteger.ONE).multiply(Q.subtract(BigInteger.ONE));
       }
    
       
       public BigInteger genE(){
       
       Random ra = new Random();
       String randomNum = Integer.toString(10 + ra.nextInt((100 - 10) + 1));
       
       BigInteger e = new BigInteger(randomNum).multiply(new BigInteger("7633168947462819717485203006812527651131230849694635025588248671905957571963977981866292752183560629682660167043421303801377638631685783259524187324016423"));
       Boolean flag = true;
       while(flag){
           if(e.gcd(PHI).equals(new BigInteger("1"))){
               
               flag = false;
           }
           else{e = e.add(new BigInteger("1"));}
           
       }
       a = e;
       return e;
}
   
   public BigInteger genD(){
       BigInteger d = a.modInverse(PHI);
       return d;
             
   }
   
}