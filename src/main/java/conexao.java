/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.auth.oauth2.GoogleCredentials;
import  com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import  java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author Professor
 */
public class conexao {
    public static Firestore db;
    
    public static void ConectarFirebase() throws IOException
    {
        try {
             FileInputStream sa = new FileInputStream("Chave.json");
             
             FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(sa))
            .build();
             
            FirebaseApp.initializeApp(options);
            
            db = FirestoreClient.getFirestore();
            System.out.println("Conectou");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }
       
    }
}
