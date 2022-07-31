import java.util.Scanner;
public class Polyalphabetic_Cipher{
    public static String low_Case(String message,boolean nospace){
        String message_lowercase=message.toLowerCase();
        String messageout="";
        for(int i=0;i<message_lowercase.length();i++){
            char ch=message_lowercase.charAt(i);
            if(nospace && ch==' ')
                continue;       
            messageout+=ch;
        }
        return messageout;
    }

    public static void encrypt(String message, String key){
        String message_lowercase=low_Case(message,false); 
        String enc_message="";
        key=key.toUpperCase();
        int keyind=0;
        for(int i=0;i<message_lowercase.length();i++){            
            char ch=message_lowercase.charAt(i);
            int castAscii = (int) ch;
            if(ch==' '||castAscii<97){
                enc_message+=ch;
                continue;
            }  
            int castAscii_key = (int) key.charAt(keyind)-64;
            int cryp_Ascii=castAscii-castAscii_key;            
            enc_message+=(char)cryp_Ascii;
            keyind++;
            if(key.length()==keyind)
                keyind=0;
        }
        System.out.println("Message : "+message);  
        System.out.println("key : "+low_Case(key,true)); 
        System.out.println("encrypted Message : "+enc_message);
        System.out.println("---------------------"); 
    }

    public static void decrypt(String encypted_message, String key){
        String dec_message="";
        key=key.toUpperCase();
        int keyind=0;
        for(int i=0;i<encypted_message.length();i++){            
            char ch=encypted_message.charAt(i);
            int castAscii = (int) ch;
            if(ch==' '||castAscii<71){
                dec_message+=ch;
                continue;
            }  
            int castAscii_key = (int) key.charAt(keyind)-64;
            int cryp_Ascii=castAscii+castAscii_key;            
            dec_message+=(char)cryp_Ascii;
            keyind++;
            if(key.length()==keyind)
                keyind=0;
        }
        System.out.println("encrypted Message : "+encypted_message);  
        System.out.println("key : "+low_Case(key,true)); 
        System.out.println("decrypted Message : "+dec_message);
        System.out.println("---------------------"); 
    
    }
    public static void main(String [] args){
        Scanner inp =  new Scanner(System.in);
        String message="meet me at elephant lake, 11 am";        
        String key="snake";   
        encrypt(message,key);  

        String encypted_message="ZWdi hR Ss ZgRbgVia ^```, 11 N_";
        decrypt(encypted_message,key);   
        
        key="privatekey";
        decrypt(encypted_message,key); 
        while(true){
            System.out.print("Encrption or Decription (e/d) : ");
            char choice = inp.next().charAt(0);
            String skip = inp.nextLine();
            if(choice=='e'||choice=='E'){
                System.out.print("Enter Message : ");
                message=inp.nextLine();
                System.out.print("Enter Key (use minimum 8 characters): ");
                key=inp.nextLine();
                System.out.println("***"); 
                encrypt(message,key);  
            }
            else if(choice=='d'||choice=='D'){
                System.out.print("Enter Encrpted Message : ");
                encypted_message=inp.nextLine();
                System.out.print("Enter Key (use minimum 8 characters): ");
                key=inp.nextLine();
                System.out.println("***"); 
                decrypt(encypted_message,key);   
            }
            else
                System.out.println("Incorrect input");

            System.out.print("Do you want to run another operation (y/n) : ");
            choice = inp.next().charAt(0);
            if(choice=='n'||choice=='N')
                break;            
            else if(choice!='y'&& choice!='Y')
                System.out.println("Incorrect input");            
                
        }
        
    }
}