package org.loiz.jdbc.test;
import java.sql.* ;
 import java.io.* ;
 import com.microsoft.sqlserver.jdbc.SQLServerDriver;

 public  class testjdbc {

    public  static  void main (String[] args) {
       try {
    	   System.out.println("d�but") ;
          // chargement de la classe par son nom
         Class c = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
         Driver pilote = (Driver)c.newInstance() ;
          // enregistrement du pilote aupr�s du DriverManager
         DriverManager.registerDriver(pilote);
          // Protocole de connexion
         String protocole =  "jdbc:sqlserver:" ;
          // Adresse IP de l�h�te de la base et port
         String ip =  "localhost\\SQLEXPRESS" ;  // d�pend du contexte
         String port =  "" ;  // port MySQL par d�faut
          // Nom de la base ;
         String nomBase =  "maBase" ;  // d�pend du contexte
          // Cha�ne de connexion         
         //jdbc:sqlserver://localhost\SQLEXPRESS;databaseName=AFER
         String conString = protocole +  "//" + ip  + ";databaseName=" + nomBase ;
         //String conString = protocole +  "//" + ip  + ";" + nomBase ;
         System.out.println("conString : " + conString) ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "sa" ;  // d�pend du contexte
         String motDePasse =  "P@ssword01" ;  // d�pend du contexte
          // Connexion
         Connection con = DriverManager.getConnection(conString, nomConnexion, motDePasse) ;

          // Envoi d�un requ�te g�n�rique
         String sql =  "SELECT * FROM LISTECOURSES" ;
         Statement smt = con.createStatement() ;
         ResultSet rs = smt.executeQuery(sql) ;
          while (rs.next()) {
            System.out.println(rs.getString("LIBELLE")) ;
         }
      }  catch (Exception e) {
    	   System.out.println(e.getMessage()) ;
      }
   }
}