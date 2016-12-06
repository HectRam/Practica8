/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8;

/**
 *
 * @author Hector
 */
import java.io.*;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.FileReader;
public class Practica8 {
    
    /**
     * @param args the command line arguments
     */
    
    public void leer()
    {
        
        Scanner s = new Scanner(System.in);
        String thisLine,dir,a=".asm",b=".err",i=".inst",ax=null,l=".tds";
        String[] Resultado = new String[] {"null","null","null","0000","0000","null","0000","null"};
        String[] Busqueda  = new String[] {"null","null"};
        String[] Linea = new String[]{" "," "," "," "," "," "};
        thisLine = null;
        String ContLoc="null", ContLoc2="null",FCC3="null",contador="0000",ContLocFCC="null",RelRes="null";
        int poslin=0,c=0,pos=0,banbuffer=0,banCod=0,sioperI=2,operval=0,BanOrg=0,compara=0,tam2=0;
                
        espacio es;
        Operando op;
        String CodMaq="null";
        String etiqueta = null, codop = null, operando = null, comentario=null,linToken=null,codoplin=null,sioperS=null,codopprue=null,Mdir=null,FCC="";
        String exEt=null,exCod=null,moddir=null,codcal=null,bytescal=null,bytesxcal=null,totbytes=null,samecod=null,dircod=null,samecod2=null,Res="null";
        String moddir2="null",bits="null",moddir3="null";
        Vector<String> cadena;
        cadena = new Vector<>();
        System.out.print("Ruta del archivo? ");
          dir= s.nextLine();
         /**
          * System.out.print(dir);
          */
                try{
             FileInputStream fstr = new FileInputStream(dir+a);
             DataInputStream input = new DataInputStream(fstr);
            BufferedReader lectb = new BufferedReader(new InputStreamReader(input));
            //escribe en el archivo inst
            /*File ins =new File(dir+i);
            FileWriter fwins=new FileWriter(ins,true);
            BufferedWriter instrucciones=new BufferedWriter(fwins);*/
            //escribe en el archivo errores
            File f =new File(dir+b);
            FileWriter fw=new FileWriter(f,true);
            BufferedWriter error=new BufferedWriter(fw);
            //escribe en el archivo comentarios
            File f2com =new File(dir+"comentarios"+a);
            FileWriter fwcom=new FileWriter(f2com,true);
            BufferedWriter comentarios=new BufferedWriter(fwcom);
            
           // StringTokenizer Token = new StringTokenizer(dir+a);
            boolean banEnd,espacio,banCom,banderalim,errBan,banEt,errtab=false;
            banEnd = false;
            espacio = false;
            banCom= false;
            errBan=false;
            banderalim=false;
            banEt=false;
            //System.out.println("Linea---ETQ-----CODOP-----OPER---");
            if(0==0){
            File ins =new File(dir+i);
            FileWriter fwins=new FileWriter(ins,true);
            BufferedWriter instrucciones=new BufferedWriter(fwins);
            instrucciones.write("Line        Cont        ETQ       CODOP     OPER     ModDir        CodiMaq");
            instrucciones.newLine();
            instrucciones.close();
            }
           // tabsim.write("Etiqueta|Valor");
           // tabsim.newLine();
             while((thisLine = lectb.readLine()) != null && banEnd != true){ //empieza a leer las lineas en loop
                        es = new espacio();
                        op = new Operando();
                        
                        codop=" ";
	            	operando=" ";
	            	etiqueta=" ";
	                c++;
                       comentario=" ";    
                       
                   System.out.println("Linea :"+c+" \n"+thisLine);
                   StringTokenizer Token = new StringTokenizer(thisLine);
                   
                   while(Token.hasMoreTokens())
                   {
                       
                   linToken=Token.nextToken();
                    //System.out.println("Lintoken "+linToken);
                    //FCC
                   if(thisLine.matches(".*\\\"$")){
                       
                       int line=thisLine.indexOf('"');
                       FCC=thisLine.substring(line+1);
                       FCC=thisLine.substring(line+1);
                     //  System.out.println("FCC "+FCC);
                        tam2=FCC.length();
                       //System.out.println("Tam2: "+tam2);
                      /* if(tam2>0){
                           //StringTokenizer FCCx = new StringTokenizer(FCC,"\\\"");
                       String FCC2=FCC.substring(0,tam2-1);
                       int tam3=FCC2.length();
                       //String FCC2=FCC.substring(0,tam3);
                           System.out.println("FCC2 "+FCC2+" tam "+tam3);
                       }*/
                        }
                   //manda a la clase publica espacio
                     espacio = es.spacio(thisLine);
                 /* if(thisLine.charAt(0) == ' ' || thisLine.charAt(0) == '\t'){
                             
                            
                            espacio = true; 
                            
                       
                         }
                  else{
                      espacio = false;
                  }*/
                 /**
                  * comentario (empiezan con ; puede ir seguido de cualquier digito  del cero al nueve, cualquier caracter de la 'a' a la 'z' incluyendo mayusculas )
                  */
                    if(linToken.matches(".*[;].*")){

                         poslin=thisLine.indexOf(';');
                         
                      // System.out.println("Posicion linea del comentario   "+poslin+1);
                         comentario=thisLine.substring(poslin+1);
                         
                         StringTokenizer at = new StringTokenizer(comentario);
                         linToken=" ";
                         while(at.hasMoreTokens()){
                             ax=at.nextToken();
                           //System.out.println("Ax    "+ax);
                            cadena.add(ax);
                           comentarios.write(ax+" ");
                         }
                         comentarios.newLine();
                         linToken=" ";
                         banCom= true;
                     }
                      /**
                       * EntraEtiqueta
                       */
                       
                         if(linToken.matches("^[a-zA-Z]{1,8}[^;]{0,1}[\\w]$")&&espacio==false&&banCom==false)
                         {
                           
                             
                         }
                         /**
                         * Entra Codop
                         */
                                if(linToken.matches("[a-zA-Z]{1,4}(?!\\d )[/.]{0,1}[a-zA-Z]$")&&banCom==false){
                         /**
                          *Inicia practica 2
                          */
                       //  System.out.println("Lintok "+linToken);
                
                         
                         
                         String TABOP="TABOP";
                         String mayus,maux="null",maux2="null",maux3="null",maux4="null";
                         String compare="null",comparecod="null";
                         try{
                             FileInputStream fsaux = new FileInputStream(TABOP+a);
                             DataInputStream dsaux = new DataInputStream(fsaux);
                             BufferedReader  braux = new BufferedReader(new InputStreamReader(dsaux));
                             
                             String linaux;
                             //System.out.println("Tab lin "+linToken);
                             
                             while((linaux = braux.readLine())!= null){
                                 
                                 StringTokenizer aucod = new StringTokenizer(linaux,"|");
                                        mayus=linToken;
                                   exCod=aucod.nextToken();
                                   
                                 //  System.out.println("Tabop: "+exCod);
                                   errtab=true;
                                  // System.out.println("excod "+exCod+" mayus"+mayus);
                                  //System.out.println("Compara: "+mayus+" tabop: "+exCod);
                                   if(exCod.trim().equals(mayus.trim().toUpperCase())/*&&mayus!="null"&&mayus!=null&&mayus!=" "*/){
                                       errtab=false;
                                       codop=linToken.toUpperCase();
                                       
                                       if(codop!="null"&&codop!=null&&codop!=" "){
                                           
                                       
                                   //     System.out.println("Codop comparado "+codop);
                                       banCod=1;
                                       
                                     //  System.out.println("Auxiliar "+linaux);
                                           sioperS=aucod.nextToken("|");    //Vrifica si lleva operando
                                        sioperI=Integer.parseInt(sioperS); //convierte de String a Cadena
                                       moddir=aucod.nextToken("|");   //Modo de direccionamiento  
                                       codcal=aucod.nextToken("|");  //Codigo Maquina calculado
                                       bytescal=aucod.nextToken("|"); //Bytes calculados
                                       bytesxcal=aucod.nextToken("|");  //Bytes por calcular
                                       totbytes=aucod.nextToken("|");  //Total de bytes
                                     /*/// Tabop2
                                       moddir=aucod.nextToken("|");   //Modo de direccionamiento  
                                       codcal=aucod.nextToken("|");  //Codigo maquina calculado
                                      totbytes=aucod.nextToken("|"); //Total de bytes
                                       bytescal=aucod.nextToken("|"); //Bytes calculados
                                       bytesxcal=aucod.nextToken("|");  //Bytes por calcular 
                                     */
                            /*           System.out.print("Codop: "+codop);
                                       System.out.print(" Modo de direccionamiento: "+moddir);
                                       System.out.print(" Codigo calculado: "+codcal);
                                       System.out.print(" Bytes calculados: "+bytescal);
                                       System.out.print(" Bytes por calcular: "+bytesxcal);
                                       System.out.println(" Total de bytes: "+totbytes);
                              */       
                                     //  System.out.println("Codop "+codop+" Operando"+moddir);
                                     
                                           dircod=codop+a;
                                           if(dircod!="null.asm")
                                           {
                                           File fcod =new File(dircod);
                                           FileWriter fwcod=new FileWriter(fcod,true);
                                           BufferedWriter modosdir=new BufferedWriter(fwcod);
                                           if(moddir.equals("INH")){
                                               modosdir.write(moddir+" ");
                                               operval=1;
                                               maux3=bytesxcal;
                                               CodMaq=codcal;//codigo maquina
                                              // System.out.println("Codop "+codop+" Operando"+moddir);
                                              maux4=moddir;
                                           }
                                           if(moddir.equals("INM")&&sioperI==0){
                                               modosdir.write(moddir+" ");
                                               operval=1;
                                               moddir="INM";
                                               maux3=bytesxcal;
                                               CodMaq=codcal;//codigo maquina
                                           }
                                           if(moddir.equals("INM")||moddir.equals("REL")){
                                              
                                               maux=moddir;
                                           }
                                           if(moddir.equals("DIR")){
                                               compare=moddir;
                                               comparecod=codop;
                                           }
                                           if(moddir.equals("EXT")){
                                              maux2=codop; 
                                           }
                                           if(comparecod.equals(codop)&&moddir.equals("EXT")){
                                               maux2="null";
                                           }
                                           
                                           
                                               //System.out.println("Codop "+codop+" moddir ");
                                               moddir="null";
                                           
                                           
                                           modosdir.close();
                                           }
                                       }
                                       
                                   }
                                   
                                   
                                   
                             }
                             dsaux.close(); 
                            // System.out.println("Tapop ORG? "+codop+"Operando "+moddir);
                         }catch(Exception r){
                             System.out.println("Hubo un error en el Tabop "+r);
                         }
                         //Etiqueta alterna
                         
                         //etiqueta="null";
                        // codopprue=linToken;
                         if(linToken.matches("^[a-z]{0,4}")&&!"equ".equals(linToken)&&espacio==false&&linToken!=codop){
                             
                            //etiqueta=linToken;
                            //System.out.println("Alterna linToken"+linToken);
                           // System.out.println("Eticod: "+codopprue);
                              //codopprue="null";
                              banEt=true;
                        }
                         if(maux!="null"){
                             moddir=maux;
                         //System.out.println("moddir: "+moddir+" "+maux);
                         }
                         if(maux2!="null"){
                             moddir2=maux2;
                         //System.out.println("moddir: "+moddir+" "+maux);
                         }
                         if(maux3!="null"){
                             ContLoc=maux3;
                         //System.out.println("moddir: "+moddir+" "+maux);
                         }
                         if(maux4!="null"){
                             moddir3=maux4;
                         //System.out.println("moddir: "+moddir+" "+maux);
                         }
                         }//termina practica 2
                                
                                /**
                                  * Entra Operando
                                  */  
                             else{
                                 
                     /**
                       
                      if(linToken.matches("^[a-z](?!\\d ){0,}[/.]{0,1}.{1,5}")){
                        
                        
                             System.out.println("residuo cod "+linToken);
                             
                                      }
                      */               
                                /**
                                  * Entra Operando
                                  */  
                                 if(codop!=" "&&linToken!=codop&&banCom==false){
                                  
                                     operando=linToken;
                                 //    System.out.println("Operando  "+operando);
                                    if(!moddir3.equals("INH")){
                                    Resultado = op.Direccion(operando,dir,c,moddir,codop,BanOrg,FCC,moddir2,FCC3);
                                    Mdir=Resultado[0];
                                    Res=Resultado[1];
                                    BanOrg=Integer.parseInt(Resultado[2]);
                                    ContLoc=Resultado[3];//Codigo por calcular
                                    CodMaq=Resultado[4];
                                    FCC3=Resultado[5];
                                    ContLoc2=Resultado[6];///Org y Equ
                                    RelRes=Resultado[7];
                                    // System.out.println("Modo de direccion "+Mdir);
                                     }
                                     if(codop.equals(" ")){
                                         
                                         codop=linToken;
                                         
                                         
                                       // System.err.println("Error Linea: "+c+"Hubo un error en el operando "+codop);
                                        error.write("Error Linea: "+c+" Hubo un error en el operando "+codop);
                                        error.newLine();
                                         operando=" ";
                                         errBan=true;
                                     }
                                     /**
                                      * Cierra Operando
                                      */
                                 }
                                 else
                                 {
                                     /**
                                      * Espacio
                                      */
                                     
                                   //  thisLine.split("\\s");
                                     //entra a etiqueta
                                     if(espacio==false)
                                     {     
                                           // thisLine.split(";");
                                        
                                         pos=0;
                                         exEt=" "; 
                                         int p=0;
                                        // System.out.println("Print linToken "+linToken);
                                       /*  pos=linToken.trim().indexOf(' ');
                                        exEt=thisLine.substring(0,pos);
                                        System.out.println("Pos "+pos+"exEt"+exEt);*/
                                         if(linToken.matches("^[a-zA-Z]{0,8}[\\w]{1,8}$")&&linToken.matches(".*[^,].*")&&banCom==false&&codop!=linToken)
                                         {
                                            p=linToken.trim().length();
                                            //System.out.println("Print linToken inside"+linToken);
                                            
                                            //System.out.println("Lin token eti: "+linToken+" Pos  "+poslin+"P"+p);
                                            /*if(p<=7){
                                             
                                           // etiqueta=linToken;
                                           if(poslin!=0&&thisLine.charAt(poslin)!=' '&&poslin>2)
                                            {
                                              System.out.println("com pos"+thisLine.charAt(poslin)+"Npos "+poslin);
                                               exEt=thisLine.trim().substring(0,poslin);
                                              System.out.println("Etiqueta "+exEt);
                                            }
                                            }*/
                                            //System.out.println("Et despues! "+exEt);
                                           //if(linToken.equals(exEt)){
                                               
                                               etiqueta=linToken.trim();
                                               etiqueta=etiqueta.toUpperCase();
                                              // System.out.println("Print etiqueta  "+etiqueta);
                                               /*System.out.println("Print linToken "+linToken);
                                               System.out.println("Print etiqueta  "+etiqueta);*/
                                              //System.out.println("TRIM  "+etiqueta);
  
                                          //}      

                                     }
                                      
                                     }
                                     
                                     cadena.clear();
                                     
                                     
                                 }
                                     
                                     
                                     
                             }
                         
                             
                     
                        
                        
                        
                        
                   }
                   
                   
                   
                   if(codop==" "){
                       codop="null";
                   }
                   if(etiqueta==" ")
                   {
                       etiqueta="null";
                   }
                   if(operando==" "){
                     operando="null";
                     }
                  
                  
                  if(sioperI==1&&operando=="null"){
                      error.write("Linea: "+c+" Error la instruccion del codop debe de tener operando");
                      error.newLine();
                      errBan=true;
                  }
                  if(sioperI==0&&operando!="null"){
                      error.write("Linea: "+c+" Error la instruccion del codop no debe de tener operando");
                      error.newLine();
                      errBan=true;
                  }
                  if(operando!="null"&&codop=="null"&&etiqueta!="null")
                  {
                     // System.out.println("Linea: "+c+" Error no se puede tener tener etiqueta u operando sin codop");
                      error.write("Linea: "+c+" Error no se puede tener tener etiqueta y operando sin codop ");
                      error.newLine();
                      errBan=true;
                      
                  }
                  if(operando=="null"&&codop=="null"&&etiqueta!="null"){
                     error.write("Linea: "+c+" Error no se puede tener tener etiqueta sin codop");
                     error.newLine();
                     errBan=true;
                  }
                  if(operando!="null"&&codop=="null"&&etiqueta=="null")
                  {
                      error.write("Linea: "+c+" Error no se puede tener tener operando sin codop");
                      error.newLine();
                      errBan=true;
                  }
                  if(banCod==0){
                      error.write("Linea: "+c+" Error codigo no encontrado");
                      error.newLine();
                      errBan=true;
                      banderalim=true;
                  }
                  if(errtab!=false&&etiqueta=="null"&&banCod==0&&banderalim==false){
                                 error.write("Error Linea: "+c+" Operando no valido");
                                 error.newLine();
                                 errBan=true;
                             }
                  
                  /////////registro de etiqueta en Tabsim
                  if(etiqueta!="null"){
                      
                  }
                  /*
                  if(bits!="null"&&operando=="null"){
                      String cadby=bits;
                  int byt=Integer.parseInt(cadby);
                  int cont=Integer.parseInt(ContLoc,16);
                  cont=cont+byt;
                  ContLoc=Integer.toHexString(cont).toUpperCase();
                  }*/
                          
                     ////////////////Inserta datos
                     if(banCod==1&&errBan==false/*&&compara==0*/){
                      
                     samecod2=codop+a;
                     //System.out.println("codop arch: "+samecod2);
                    
                         
                      File f2 =new File(samecod2);
                      FileInputStream fcod2 = new FileInputStream(samecod2);
                      DataInputStream inputcod2 = new DataInputStream(fcod2);
                      BufferedReader brcod2 = new BufferedReader(new InputStreamReader(inputcod2));
                      codoplin=brcod2.readLine();//imprime los modos de direccionamiento
                     // System.out.println("Modo de direccion "+Mdir);
                      if(Mdir!=null){
                          codoplin=Mdir;
                      }
                      
                      if(codoplin!="null"){
                          /*if(codop.equals("FCC")){
                              int d=FCC3.length();
                              System.out.println("d: "+d);
                              d=d-2;
                              ContLoc=Integer.toString(d);
                           System.out.println("d: "+d+" ContLoc: "+ContLoc);
                       
                          */
                      String contador3=contador; 
                      if(ContLoc2.equals("null")){
                          if(ContLoc.equals("null")){
                              String MaqDir="null",et="null";
                          Busqueda =op.Bytes(codop,Mdir,MaqDir,et);
                          ContLoc=Busqueda[0];
                      }
                  int byt=Integer.parseInt(ContLoc);
                  int cont=Integer.parseInt(contador3,16);
                  cont=cont+byt;
                  contador3=Integer.toHexString(cont).toUpperCase();
                          }else{
                              contador=ContLoc2;
                              contador3=ContLoc2;
                              System.out.println("ContLoc2: "+ContLoc2);
                          }
                      contador3=op.fillContLoc(contador3);
                          ///Entra Tabsim
                        if(codop!="null"&&etiqueta!="null"){
                       //escribe en el archivo tabsim
                       File tab =new File(dir+l);
                       FileWriter fwtab=new FileWriter(tab,true);
                       BufferedWriter tabsim=new BufferedWriter(fwtab);
                     // System.out.println("Codop Equ: tronador04"+codop);
                      compara= op.TabsimCheck(dir,etiqueta);
                      if(compara==0){
                      tabsim.write(etiqueta.toUpperCase()+"|"+contador);
                      tabsim.newLine();
                      }else{//Entra a ordenar y borrar etiqueta 
                          System.out.println("Entro a ordenar");
                          op.Ordena(dir,etiqueta,i);
                      }
                       tabsim.close();
                      }//Termina Tabsim
                      //Entra busqueda de codigo maquina Extendido
                      if(codoplin.equals("EXT")&&operando.matches("^[a-zA-Z]{0,8}[\\w]$")&&operando.matches(".*[^,].*")){
                          
                          String Con=op.TabsimCheck2(dir,operando);
                          System.out.println("ConTab: "+Con);
                          if(Con!="null"&&Con!=null){
                          Busqueda =op.Bytes(codop, codoplin, Con, operando);
                          //System.out.println("Entro extendido: "+operando+" CodMaq: "+Busqueda[1]+" ConTab: "+Con);
                          CodMaq=Busqueda[1];
                          }else{
                              
                              
                              error.write("Error Linea: "+c+" No se encontro la etiqueta en Tabsim para: "+operando);
                              error.newLine();
                              compara=1;
                              contador3=contador;
                              
                          }
                         }///Termina
                      //Entra busqueda de codigo maquina REL8 && REL16
                      if(codoplin.equals("REL8")&&operando.matches("^[a-zA-Z]{1,8}[\\w]$")&&operando.matches(".*[^,].*")||codoplin.equals("REL16")&&operando.matches("^[a-zA-Z]{1,8}[\\w]$")&&operando.matches(".*[^,].*")){ 
                        
                           String Con=op.TabsimCheck2(dir,operando);
                        //  System.out.println("ConTab: "+Con);
                          if(Con!="null"&&Con!=null){
                          Busqueda =op.Bytes(codop, codoplin, Con, contador3);
                          //System.out.println("Entro extendido: "+operando+" CodMaq: "+Busqueda[1]+" ConTab: "+Con);
                          CodMaq=Busqueda[1];
                          }else{
                              
                              
                              error.write("Error Linea: "+c+" No se encontro la etiqueta en Tabsim para: "+operando);
                              error.newLine();
                              compara=1;
                              contador3=contador;
                              
                          }
                         }///Termina REL
                        if(compara==0){
                            File ins =new File(dir+i);
                            FileWriter fwins=new FileWriter(ins,true);
                             BufferedWriter instrucciones=new BufferedWriter(fwins);
                      if(Res!="null"){
                     //inserta resultado de Operando 
                      operando=Res;
                      String nu=Integer.toString(c);
                      Linea=op.fillline(nu, contador, etiqueta, codop, operando, codoplin,CodMaq);
                  System.out.println(Linea[0]+"  co  "+Linea[1]+"  ee  "+Linea[2]+"  cc  "+Linea[3]+"  oo  "+Linea[4]+"  op  "+Linea[5]+"  cm  "+CodMaq);
                  instrucciones.write(Linea[0]+"        "+Linea[1]+"        "+Linea[2]+"        "+Linea[3]+"        "+Linea[4]+"        "+Linea[5]+"        "+CodMaq);
                  instrucciones.newLine();
                            contador=contador3;
                  
                      }else{
                          String nu=Integer.toString(c);
                      Linea=op.fillline(nu, contador, etiqueta, codop, operando, codoplin,CodMaq);
                  System.out.println(Linea[0]+"  co  "+Linea[1]+"  ee  "+Linea[2]+"  cc  "+Linea[3]+"  oo  "+Linea[4]+"  op  "+Linea[5]+"  cm  "+CodMaq);
                  instrucciones.write(Linea[0]+"        "+Linea[1]+"        "+Linea[2]+"        "+Linea[3]+"        "+Linea[4]+"        "+Linea[5]+"        "+CodMaq);
                  instrucciones.newLine();      
                       contador=contador3;
                      }
                      instrucciones.close();
                      fwins.close();
                       }
                      }
                      
                      
                      
                  brcod2.close();
                  f2.delete();
                 
                       
                       }//fin de insercion de datos
                     if(errBan==true)
                     {
                         if(codop!="null"){
                             
                         
                         samecod2=codop+a;
                    // System.out.println("codop arch: "+samecod2);
                     if(samecod2!="null.asm")
                     {
                      File f2 =new File(samecod2);
                      FileInputStream fcod2 = new FileInputStream(samecod2);
                      DataInputStream inputcod2 = new DataInputStream(fcod2);
                      BufferedReader brcod2 = new BufferedReader(new InputStreamReader(inputcod2));
                      codoplin=brcod2.readLine();
    
                      brcod2.close();
                      f2.delete();
                     }
                         }
                     }
                     //  System.out.println(thisLine);//muestra temporal
                     errtab=false;
                     banCom=false;
                     errBan=false;
                     banderalim=false;
                     banCod=0;
                     sioperI=2;
                     Mdir=null;
                     operval=0;
                     compara=0;
                     CodMaq=" ";
                     moddir2="null";
                     moddir3="null";
                     RelRes="null";
                     ContLoc2="null";
                     
                     if(linToken.matches(".*END.*")||linToken.matches(".*End.*")||linToken.matches(".*end.*")){//verifica si tiene End
                         File ins =new File(dir+i);
                         FileWriter fwins=new FileWriter(ins,true);
                         BufferedWriter instrucciones=new BufferedWriter(fwins);
                           banEnd = true;
                           System.out.println("Entro End");
                           String nu=Integer.toString(c);
                           nu=op.fillContLoc(nu);
                           instrucciones.write(nu+"            "+contador+"             "+"null"+"                "+"END"+"               "+"null"+"                      "+"null"+"                 "+"null");
                           instrucciones.newLine();
                           instrucciones.close();
                       }
                      
                    }
                    if(banEnd==false)
                       {
                         //  System.err.println("Linea: "+c+"Error: no se encontro el final del archivo(End)");
                          error.write("Error: no se encontro el final del archivo(End)");
                           error.newLine();
                       }
                //System.out.println("Fin del recorrido");   
             //  fw.close();
            
             comentarios.close();
               error.close();
               
            //   comentarios.close();
                }catch(Exception e){
                    System.err.println("Hubo un error en el codigo\n"+e);
                    
    }
        
        
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Practica8 H = new Practica8();
         H.leer();
        
    }
    
    
}
