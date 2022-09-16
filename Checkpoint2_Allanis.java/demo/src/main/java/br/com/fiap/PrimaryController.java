package br.com.fiap;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.model.Receita;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;

public class PrimaryController implements Initializable{

    @FXML TextField textFieldIdTitulo;
    @FXML TextField textFieldIdIngredientes;
    @FXML TextField textFieldIdPreparo;
    @FXML TextField textFieldIdCusto;
    @FXML ChoiceBox<String> choiceBoxCategoria;
    @FXML CheckBox checkBoxFavorito;
    @FXML Button buttonSalvar;
    @FXML Button buttonTitulo;
    @FXML Button buttonCusto;

    @FXML ListView<Receita> listView;
    @FXML ListView<Receita> listView2;

    private List<Receita> lista = new ArrayList<>();
    private List<Receita> listaFav = new ArrayList<>();

    public void salvar(){

        if(checkBoxFavorito.isSelected()){
            var receita = setarFormulario();
            lista.add(receita);  
            listaFav.add(receita);
    
            alerta("Receita cadastrada!!");  
    
            limparFormulario();
            
            listView.getItems().add(receita);
            listView2.getItems().add(receita);
        }else{
            var receita = setarFormulario();
            lista.add(receita); 
    
            alerta("Receita cadastrada!!");  
    
            limparFormulario();
            
            listView.getItems().add(receita);
        }               
    }
    
    
    private Receita setarFormulario(){
        
        String titulo = textFieldIdTitulo.getText();
        String ingredientes = textFieldIdIngredientes.getText();
        String preparo = textFieldIdPreparo.getText();
        String custo = textFieldIdCusto.getText();
        String categoria = choiceBoxCategoria.getValue();
        
        Receita receita = new Receita(titulo, ingredientes, preparo, custo, categoria);
        
        return receita;
        
    }
    
    private void alerta(String mensagem){
        
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setContentText(mensagem);
        alerta.show();

    }
    
    private void limparFormulario(){
        
        textFieldIdTitulo.setText("");
        textFieldIdIngredientes.setText("");
        textFieldIdPreparo.setText("");
        textFieldIdCusto.setText("");
        choiceBoxCategoria.setValue("");
        
    }
    public void titulo(){
        lista.sort((o1,o2) -> { return Integer.compare(Integer.valueOf(o1.getTitulo()),Integer.valueOf(o2.getTitulo())); });
        atualizarLista();
    }

    public void custo(){
        lista.sort((o1, o2) -> o1.getCusto().compareTo(o2.getCusto()));
        atualizarLista();        
    }

    public void atualizarLista(){

        listView.getItems().clear();
        listView.getItems().addAll(lista);
        listView2.getItems().clear();
        listView2.getItems().addAll(lista);

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<String>  categoria = new  ArrayList<>();
        categoria.add("Salgado");
        categoria.add("Doce");
        categoria.add("Bebidas e drinks");


        choiceBoxCategoria.getItems().addAll(categoria);
        
    }
}
