
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MauricioAsenjo
 */


public class LivroDAL {
    
        CollectionReference reference;
    
 static Firestore db;



public static boolean inseriLivro(
        String colecao,
        String documento,
       Map<String,Object> data)
{
db = FirestoreClient.getFirestore();

    try {
        DocumentReference docRef = db.collection(colecao).document(documento);
        ApiFuture<WriteResult> result = docRef.set(data);
        return true;
    } catch (Exception e) {
         javax.swing.JOptionPane.showMessageDialog(null,"Erro ao Deletar" + e.getMessage());
    }
     return false;
}


public static boolean deletaLivro(
        String colecao,
        String documento)
{
    db = FirestoreClient.getFirestore();

    try {
        DocumentReference docRef = db.collection(colecao).document(documento);
        ApiFuture<WriteResult> result = docRef.delete(Precondition.NONE);
        return true;
    } catch (Exception e) {
          javax.swing.JOptionPane.showMessageDialog(null,"Erro ao Deletar" + e.getMessage());
    }
    return false;
}

public static boolean alteraLivro(   
        String colecao,
        String documento,
       Map<String,Object> data)
{
db = FirestoreClient.getFirestore();

    try {
        DocumentReference docRef = db.collection(colecao).document(documento);
        ApiFuture<WriteResult> result = docRef.update(data);
        return true;
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null,"Erro ao Editar" + e.getMessage());
    }
      return false;
} 

public static void CarregarTable(JTable Tabela){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Titulo");
    model.addColumn("Autor");
    model.addColumn("Editora");
    model.addColumn("Ano de edição");
    model.addColumn("Localização");
    
    try {
        CollectionReference Livros = conexao.db.collection("Livro");
        ApiFuture<QuerySnapshot> querySnap = Livros.get();
        
        for(DocumentSnapshot document: querySnap.get().getDocuments()){
            model.addRow(new Object[]{
                document.getId(),
                document.getString("Titulo"),
                document.getString("Autor"),
                document.getString("Editora"),
                document.getString("Ano Edicao"),
                document.getString("Localizacao")
            });
        }
    } catch (Exception e) {
          javax.swing.JOptionPane.showMessageDialog(null,"Erro ao Carregar Tabela:  " + e.getMessage());
    }
    
    Tabela.setModel(model);
}

}
