import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class ReverseClient {
    public static void main(String[] args) {
        try {
        	if(System.getSecurityManager()==null) System.setSecurityManager(new RMISecurityManager());
            // Obtenir la référence de l'objet fabrique distant
            FabInterface fabrique = (FabInterface) Naming.lookup("Fabrique");

            // Créez une instance d'objet distant
            AppInterface reverseInstance = fabrique.newReverse();

            // Appelez la méthode distante pour inverser une chaine
            String result = reverseInstance.reverseString("Hello, World!");
            System.out.println("Chaine inversée : " + result);
        } catch (Exception e) {
            System.out.println("Erreur d'accés à l'objet distant.");
            System.out.println(e.toString());
        }
    }
}
