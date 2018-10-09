package org.loiz.jdbc.test;
import java.sql.* ;
 import java.io.* ;
 import com.microsoft.sqlserver.jdbc.SQLServerDriver;

 public  class testjdbc {

    public  static  void main (String[] args) {
       try {
    	   System.out.println("début") ;
          // chargement de la classe par son nom
         Class c = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
         Driver pilote = (Driver)c.newInstance() ;
          // enregistrement du pilote auprès du DriverManager
         DriverManager.registerDriver(pilote);
          // Protocole de connexion
         String protocole =  "jdbc:sqlserver:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "localhost\\SQLEXPRESS" ;  // dépend du contexte
         String port =  "" ;  // port MySQL par défaut
          // Nom de la base ;
         String nomBase =  "maBase" ;  // dépend du contexte
          // Chaîne de connexion         
         //jdbc:sqlserver://localhost\SQLEXPRESS;databaseName=AFER
         String conString = protocole +  "//" + ip  + ";databaseName=" + nomBase ;
         //String conString = protocole +  "//" + ip  + ";" + nomBase ;
         System.out.println("conString : " + conString) ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "sa" ;  // dépend du contexte
         String motDePasse =  "P@ssword01" ;  // dépend du contexte
          // Connexion
         Connection con = DriverManager.getConnection(conString, nomConnexion, motDePasse) ;

          // Envoi d’un requête générique
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