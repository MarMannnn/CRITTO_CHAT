# CRITTO_CHAT 
Questo è un progetto sviluppato da Maniero Martino e Bergantin Alessandro per il corso di "Ingegneria del Software avanzata" dell'università di Ferrara.
Il progetto consiste in sistema di messaggistica stile mail-box, nel quale ogni iscritto può scambiare messaggi cifrati con algoritmo RSA da noi implementato.
I messaggi verranno visualizzati nelle apposite sezioni in maniera cifrata e si potrà leggere il contenuto in chiaro solamente inserendo la propria chiave privata che è stata ricevuta al momento della registrazione utente.
**ATTENZIONE: codice di codifica ASCII! -> non sono accettate le lettere composte (es: à, ò, è, ù ..) -> per fare le lettere accentate: e'**


### 1-LOGIN/SIGN UP

Un utente non registrato può registarsi andando ad inserire un UserName univoco. In automatico riceverai una **chiave privata** da non perdere e mantenere segreta, questa sarà necessaria per decifrare i messaggi che si riceveranno.

![Screenshot from 2022-07-13 13-18-28](https://user-images.githubusercontent.com/100956253/178722404-5e571255-f623-4854-a618-ac9371e6bdc8.png)

Procedere con la fase di login in modo da accedere al proprio profilo

![Screenshot from 2022-07-13 13-18-12](https://user-images.githubusercontent.com/100956253/178722193-855e60c1-99c8-448e-a9a5-b05de0be900e.png)


### **2-RUBRICA** 

Una volta eseguito l'accesso comparirà una sorta di "rubrica" nella quale avremo la lista degli utenti registrati. Inoltre vi è una sezione dove è possibile vedere tutti i messaggi ricevuti. Con un doppio clic sul messaggio si può andare a decifrarlo semplicemente inserendo la propria chiave privata.
Facendo doppio clic sull'utente di interesse si potrà iniziare a "chattare" con questo.


![Screenshot from 2022-07-13 13-19-10](https://user-images.githubusercontent.com/100956253/178727900-89755a06-578f-419e-95d1-009cf4d8b013.png)


### **3-CHAT**

![Screenshot from 2022-07-13 13-17-53](https://user-images.githubusercontent.com/100956253/178727145-6d181721-fd7c-4b26-9f12-39ad9f5b7a1f.png)

### **4-DECIFRATORE**

![Screenshot from 2022-07-13 13-17-06](https://user-images.githubusercontent.com/100956253/178727963-d945a01f-60ed-4a4e-ba16-e368a196b027.png)

