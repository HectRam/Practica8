/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Hector
 */
public class Ordenamiento extends Operando{
    
    
    public String[] ReContLoc(String codop,String Mdir,String Operando){
    String[] Resultado =new String[]{"null","null"};
                 System.out.println("Entro a busqueda... Codop: "+codop+" Mdir: "+Mdir+"Operando: "+Operando);
                 
                 if(Mdir.equals("IMM8")||Mdir.equals("IMM16")){
                              Mdir="INM";
                          }
                          if(Mdir.equals("REL8")||Mdir.equals("REL16")){
                              Mdir="REL";
                          }
                         String TABOP="TABOP";
                         String mayus, exCod,codop2;
                         String compare="null",comparecod="null";
                         String maux;
                         int BanOrg=0,BanContLoc=0;
                         try{
                             FileInputStream fsaux = new FileInputStream(TABOP+".asm");
                             DataInputStream dsaux = new DataInputStream(fsaux);
                             BufferedReader  braux = new BufferedReader(new InputStreamReader(dsaux));
                             
                             String linaux;
                             //System.out.println("Tab lin "+linToken);
                             
                             while((linaux = braux.readLine())!= null){
                                 
                                 StringTokenizer aucod = new StringTokenizer(linaux,"|");
                                        mayus=codop;
                                   exCod=aucod.nextToken();
                                   
                                 
                                   if(exCod.trim().equals(mayus.trim().toUpperCase())){
                                       
                                       
                                       if(codop!="null"&&codop!=null&&codop!=" "){
                                           
                                       
                                   //     System.out.println("Codop comparado "+codop);
                                    
                                     //  System.out.println("Auxiliar "+linaux);
                                       String sioperS=aucod.nextToken("|");    //Vrifica si lleva operando
                                       int sioperI=Integer.parseInt(sioperS); //convierte de String a Cadena
                                       String moddir=aucod.nextToken("|");   //Modo de direccionamiento  
                                       String codcal=aucod.nextToken("|");  //Codigo Maquina calculado
                                       String bytescal=aucod.nextToken("|"); //Bytes calculados
                                       String bytesxcal=aucod.nextToken("|");  //Bytes por calcular
                                       String totbytes=aucod.nextToken("|");  //Total de bytes

        if(codop.equals("ORG")){
                  int ORG=0; 
                  if(BanOrg!=1){
                  if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$")){
                      //Entra Hexadecimal
                      if(Operando.matches("^\\$.*")){
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           ORG=Integer.parseInt(Hexa,16);
                          if(ORG<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              Resultado[1]=Integer.toHexString(ORG).toUpperCase();
                              BanOrg=1;
                              Mdir="DTV";
                              }
                             }//termina Hexadecimal
                            //Empieza Octal
                      if(Operando.matches("^\\@.*")){
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           ORG=Integer.parseInt(Hexa,8);
                          if(ORG<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              Resultado[1]=Integer.toHexString(ORG).toUpperCase();
                              BanOrg=1;
                              Mdir="DTV";
                              }
                             }//termina Octal
                            //Empieza Binario
                       if(Operando.matches("^\\%.*")){
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           ORG=Integer.parseInt(Hexa,2);
                          if(ORG<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              Resultado[1]=Integer.toHexString(ORG).toUpperCase(); 
                              BanOrg=1;
                              }
                             }//termina Binario
                               }else{//sin base
                                  if(Operando.matches("^[0-9]*")){
                                   ORG=Integer.parseInt(Operando);
                                   if(ORG<=65535){
                                   Resultado[1]=Integer.toHexString(ORG).toUpperCase();
                                  Mdir="DTV";
                                     BanOrg=1; 
                                   }
                                  }
                              
                          }
              }
                  BanContLoc=1;
              }////////////////////////////////////////////////////////////Termina ORG
        
                        /////////////////////EQU
              if(codop.equals("EQU")){
                  int EQU=0;
                  
                  if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$")){
                      
                  //Entra Hexa
                  if(Operando.matches("^\\$.*")){
                      
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           EQU=Integer.parseInt(Hexa,16);
                          if(EQU<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              Resultado[1]=Integer.toHexString(EQU).toUpperCase();
                              Mdir="DTV";
                              }
                             }//termina hexadecimal
                  
                  //Inicia Octal
                  if(Operando.matches("^\\@.*")){
                      
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           EQU=Integer.parseInt(Hexa,8);
                          if(EQU<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              Resultado[1]=Integer.toHexString(EQU).toUpperCase();
                              Mdir="DTV";
                              }
                             }//Termina Octal
                  //Inicia Binario
                   if(Operando.matches("^\\%.*")){
                      
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           EQU=Integer.parseInt(Hexa,2);
                          if(EQU<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              Resultado[1]=Integer.toHexString(EQU).toUpperCase();
                              Mdir="DTV";
                              }
                             }//Termina Binario
                             }else{//sin base
                                  if(Operando.matches("^[0-9]?[0-9]*")){
                                   EQU=Integer.parseInt(Operando);
                                   if(EQU<=65535){
                                   Resultado[1]=Integer.toHexString(EQU).toUpperCase();
                                    Mdir="DTV"; 
                                   }
                                  }
                              
                          }
                  
                  BanContLoc=1;
              }////////////////////////////////////////////Termina EQU
              ///Entra FCC
              if(codop.equals("FCC")){
               int DiCons=0;
               if(codop.equals("FCC")){
                      
                         //int siz=Operando.length();
                         int siz=Operando.length();
                        String FCC2=Operando.substring(1,siz-1);
                        
                       // StringTokenizer FCCx = new StringTokenizer(FCC2,"\\\"");
                           //  String FCC3=FCCx.nextToken();
                             
                            DiCons =FCC2.length();
                          //  System.out.println("FCC: "+FCC+" FCC2: "+FCC2+" TamFCC2: "+DiCons);
                         //   System.out.println("FCC2"+FCC2+"Tam "+DiCons);
                            Resultado[0]=Integer.toString(DiCons);
                           Mdir="DTV";
                      
                  }
                  BanContLoc=1;
              }///////////////////////////////////////////Termina FCC
              
              /////////////////////////////DS, DS.B, DS.W, RMB, RMW
              if(codop.equals("DS")||codop.equals("DS.B")||codop.equals("DS.W")||codop.equals("RMB")||codop.equals("RMW")){
                  int DiMem=0;
                  //De un byte
                  if(codop.equals("DS")||codop.equals("DS.B")||codop.equals("RMB")){
                      
                      if(Operando.matches("\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$"))
                      {
                          //entra Hexadecimal
                      if(Operando.matches("^\\$.*"))
                       {
                         int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Hexa,16);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando con ContLoc
                               Resultado[0]=Integer.toString(DiMem);
                               Mdir="DTV";
                           }
                       }//termina Hexadecimal
                      //entra Octal
                      if(Operando.matches("^\\@.*"))
                       {
                         int siz=Operando.length();
                        String Oct=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Oct,8);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando con ContLoc
                               Resultado[0]=Integer.toString(DiMem); 
                               Mdir="DTV";
                           }
                       }//entra Binario
                      if(Operando.matches("^\\%.*"))
                       {
                         int siz=Operando.length();
                        String Bin=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Bin,2);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando con ContLoc
                               Resultado[0]=Integer.toString(DiMem); 
                               Mdir="DTV";
                           }
                       }
                      }else{//sin base 
                          if(Operando.matches("^[0-9]?[0-9]*")){
                          DiMem=Integer.parseInt(Operando,10);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando con ContLoc
                               Resultado[0]=Integer.toString(DiMem); 
                               Mdir="DTV";
                           }
                          }
                      }
                      
                      
                  }//termina de un Byte
                  //entra de dos Bytes
                  if(codop.equals("DS.W")||codop.equals("RMW")){
                      
                      if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$"))
                      {
                          //entra Hexadecimal
                      if(Operando.matches("^\\$.*"))
                       {
                         int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Hexa,16);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando*2 con ContLoc
                               DiMem=DiMem*2;
                               Resultado[0]=Integer.toString(DiMem); 
                               Mdir="DTV";
                           }
                       }//termina Hexadecimal
                      //entra Octal
                      if(Operando.matches("^\\@.*"))
                       {
                         int siz=Operando.length();
                        String Oct=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Oct,8);
                           if(DiMem<=65535&&DiMem>=0){
                               
                               
                               //suma resultado de operando*2 con ContLoc
                               
                               DiMem=DiMem*2;
                               Resultado[0]=Integer.toString(DiMem); 
                               
                               Mdir="DTV";
                           }
                       }//entra Binario
                      if(Operando.matches("^\\%.*"))
                       {
                         int siz=Operando.length();
                        String Bin=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Bin,2);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando*2 con ContLoc
                               
                               DiMem=DiMem*2;
                               int cont=DiMem;
                               Resultado[0]=Integer.toString(DiMem); 
                               Mdir="DTV";
                           }
                       }
                      }else{//sin base 
                          if(Operando.matches("^[0-9]?[0-9]*")){
                          DiMem=Integer.parseInt(Operando,10);
                           if(DiMem<=65535&&DiMem>=0){
                               // toma el resultado
                               
                               DiMem=DiMem*2;
                                Resultado[0]=Integer.toString(DiMem);
                               Mdir="DTV";
                           }
                          }
                      }
                      
                      
                  }//Termina de dos Bytes
                  BanContLoc=1;
                  
              }//Termina Directivas  de Reserva de espacio de Memoria 
              
              
                                                                   //ContLoc/////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             // System.out.println("moddir: "+moddir+" Mdir: "+Mdir+"BancontLoc"+BanContLoc);
                                       if(moddir.equals(Mdir)&&BanContLoc!=1){
                                              
                                               Resultado[0]=bytesxcal;
                                              // System.out.println("Entro...moddir: "+moddir+" Mdir: "+Mdir+"BancontLoc"+BanContLoc);
                                           }
        
                                       }
                                   }
                             }
                         }catch(Exception r){
                             System.err.println("Hubo un error en el metodo ReContLoc "+r);
                         }
                         
                         System.out.println("Sale con... ContLoc: "+Resultado[0]+" ContLoc2: "+Resultado[1]);
         return Resultado;
    }
    
    
}
