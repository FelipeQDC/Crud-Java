
import java.util.HashMap;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MauricioAsenjo
 */
public class LivroBLL {


public static void  ValidaDadosDeleta(String id){
     Erro.setErro(false);
     if (id.equals(""))
        {Erro.setErro("O campo ID é de preenchimento obrigatório..."); return;}
     
    try {
            LivroDAL.deletaLivro("Livro",String.valueOf(id));
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null,"Erro ao Deletar");
    }
}

public static void validaDadosInseri( Livro _umlivro)
{
 Erro.setErro(false);
 if (_umlivro.getTitulo().equals(""))
   {Erro.setErro("O campo TITULO é de preenchimento obrigatório..."); return;}
 if (_umlivro.getAutor().equals(""))
   {Erro.setErro("O campo AUTOR é de preenchimento obrigatório..."); return;}
 if (_umlivro.getEditora().equals(""))
   {Erro.setErro("O campo EDITORA é de preenchimento obrigatório..."); return;}
 if (_umlivro.getAnoEdicao().equals(""))
   {Erro.setErro("O campo ANO EDICAO é de preenchimento obrigatório..."); return;}
 else
   try
     {
     Integer.parseInt(_umlivro.getAnoEdicao());
     }
   catch (Exception e)
     {
     Erro.setErro("O campo ANO EDICAO deve ser numerico!"); return;
     }
 if (_umlivro.getLocalizacao().equals(""))
   {Erro.setErro("O campo LOCALIZACAO é de preenchimento obrigatório..."); return;}
 
 int id = (int) ( Math.random() * 100000);
 
    try {
        Map<String,Object> dados = new  HashMap<>();
        dados.put("Titulo", _umlivro.getTitulo());
        dados.put("Autor", _umlivro.getAutor());
        dados.put("Editora", _umlivro.getEditora());
        dados.put("Ano Edicao", _umlivro.getAnoEdicao());
        dados.put("Localizacao", _umlivro.getLocalizacao());
        if (Erro.getErro()) return;
       LivroDAL.inseriLivro("Livro",String.valueOf(id),dados);
        
 
    } catch (Exception e) {
        System.out.println("Error" + e.getMessage());
         javax.swing.JOptionPane.showMessageDialog(null,"Erro ao inserir");
    }
 
 
}

public static void validaDadosEditar( Livro _umlivro,String id)
{
 Erro.setErro(false);
 if (_umlivro.getTitulo().equals(""))
   {Erro.setErro("O campo TITULO é de preenchimento obrigatório..."); return;}
 if (_umlivro.getAutor().equals(""))
   {Erro.setErro("O campo AUTOR é de preenchimento obrigatório..."); return;}
 if (_umlivro.getEditora().equals(""))
   {Erro.setErro("O campo EDITORA é de preenchimento obrigatório..."); return;}
 if (_umlivro.getAnoEdicao().equals(""))
   {Erro.setErro("O campo ANO EDICAO é de preenchimento obrigatório..."); return;}
 else
   try
     {
     Integer.parseInt(_umlivro.getAnoEdicao());
     }
   catch (Exception e)
     {
     Erro.setErro("O campo ANO EDICAO deve ser numerico!"); return;
     }
 if (_umlivro.getLocalizacao().equals(""))
   {Erro.setErro("O campo LOCALIZACAO é de preenchimento obrigatório..."); return;}
 
 if (id.equals(""))
   {Erro.setErro("O campo ID é de preenchimento obrigatório..."); return;}
    try {
        Map<String,Object> dados = new  HashMap<>();
        dados.put("Titulo", _umlivro.getTitulo());
        dados.put("Autor", _umlivro.getAutor());
        dados.put("Editora", _umlivro.getEditora());
        dados.put("Ano Edicao", _umlivro.getAnoEdicao());
        dados.put("Localizacao", _umlivro.getLocalizacao());
        if (Erro.getErro()) return;
       LivroDAL.alteraLivro("Livro",String.valueOf(id),dados);
        
 
    } catch (Exception e) {
        System.out.println("Error" + e.getMessage());
        javax.swing.JOptionPane.showMessageDialog(null,"Erro ao Editar");
    }
 
 
}

}

