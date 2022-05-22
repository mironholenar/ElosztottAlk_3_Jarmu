package com.jarmuvek;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ////
    //Ember Hozzáadása
    ////
    @FXML
    private TextField eh_nev;

    @FXML
    private Spinner eh_kor;

    @FXML
    private Button eh_hozzaad;

    ////
    //Tableview
    ////
    @FXML
    private TableView<Ember> emberek_tableview;

    @FXML
    private TableColumn<Ember, String> emberek_tableview_nev;

    @FXML
    private TableColumn<Ember, Integer> emberek_tableview_kor;

    @FXML
    private TableColumn<Ember, String> emberek_tableview_jogositvany;

    @FXML
    private TableView<Jarmu> jarmuvek_tableview;

    @FXML
    private TableColumn<Jarmu,String> jarmuvek_tableview_nev;

    @FXML
    private TableColumn<Jarmu,String> jarmuvek_tableview_tipus;

    @FXML
    private TableColumn<Jarmu,Jarmu.Szin> jarmuvek_tableview_szin;

    @FXML
    private TableColumn<Jarmu,Ember> jarmuvek_tableview_tulajdonos;

    @FXML
    private TableColumn<Jarmu,Ember> jarmuvek_tableview_sofor;

    @FXML
    private TableColumn<Jarmu, Uzemanyag> jarmuvek_tableview_uzemanyag;

    @FXML
    private TableColumn<Jarmu, Integer> jarmuvek_tableview_uzemanyagmennyiseg;

    @FXML
    private TableColumn<Jarmu, Jarmu.MotorStatusz> jarmuvek_tableview_motorstatusz;


    ////
    //Ember Módosítása
    ////
    @FXML
    private TextField em_nev;

    @FXML
    private Spinner em_kor;

    @FXML
    private Button em_modosit;

    @FXML
    private Button em_torles;

    ////
    //Jogositvány Szerzése
    ////

    @FXML
    private Button js_jogositvanyszerzese;

    //Jármű Hozzáadása
    @FXML
    private TextField jh_nev;

    @FXML
    private ChoiceBox<String> jh_tipus;

    @FXML
    private ChoiceBox<Uzemanyag.Tipus> jh_uzemanyag;

    @FXML
    private ChoiceBox<Jarmu.Szin> jh_szin;

    private final String[] tipusok = {"Autó", "Motor"};

    @FXML
    private Spinner jh_uzemanyagmennyiseg;

    //Jármű módosítása

    @FXML
    private TextField jm_nev;

    @FXML
    private ChoiceBox<Jarmu.Szin> jm_szin;

    @FXML
    private ChoiceBox<Ember> jm_tulajdonos;

    @FXML
    private ChoiceBox<Ember> jm_sofor;

    @FXML
    private Spinner jm_uzemanyagmennyiseg;

    //Jármú beindítása

    @FXML
    private ChoiceBox<Ember> jb_tulajdonos;

    @FXML
    private ChoiceBox<Ember> jb_sofor;

    @FXML
    private Button jb_beindit;

    @FXML
    private Button jb_leallit;




    //Initialize

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Spinner

        SpinnerValueFactory<Integer> spinner_eh = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,120,18);
        SpinnerValueFactory<Integer> spinner_em = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,120,18);
        SpinnerValueFactory<Integer> spinner_uzemanyag = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,30);
        SpinnerValueFactory<Integer> spinner_uzemanyag2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,30);
        eh_kor.setValueFactory(spinner_eh);
        em_kor.setValueFactory(spinner_em);
        jh_uzemanyagmennyiseg.setValueFactory(spinner_uzemanyag);
        jm_uzemanyagmennyiseg.setValueFactory(spinner_uzemanyag2);


        //TableView
        emberek_tableview_nev.setCellValueFactory(new PropertyValueFactory<Ember,String>("Nev"));
        emberek_tableview_kor.setCellValueFactory(new PropertyValueFactory<Ember,Integer>("Kor"));
        emberek_tableview_jogositvany.setCellValueFactory(jogositvany -> new SimpleStringProperty(jogositvany.getValue().getJogositvanyValidity()));

        jarmuvek_tableview_nev.setCellValueFactory(new PropertyValueFactory<Jarmu,String>("Nev"));
        jarmuvek_tableview_tipus.setCellValueFactory(tipus -> new SimpleStringProperty(tipus.getValue().getTipus()));
        jarmuvek_tableview_szin.setCellValueFactory(new PropertyValueFactory<Jarmu,Jarmu.Szin>("Szin"));
        jarmuvek_tableview_tulajdonos.setCellValueFactory(new PropertyValueFactory<Jarmu,Ember>("Tulajdonos"));
        jarmuvek_tableview_sofor.setCellValueFactory(new PropertyValueFactory<Jarmu,Ember>("Sofor"));
        jarmuvek_tableview_uzemanyag.setCellValueFactory(new PropertyValueFactory<Jarmu,Uzemanyag>("Uzemanyag"));
        jarmuvek_tableview_uzemanyagmennyiseg.setCellValueFactory(uzemanyagmennyiseg -> new SimpleIntegerProperty(uzemanyagmennyiseg.getValue().getUzemanyag().getMennyiseg()).asObject());
        jarmuvek_tableview_motorstatusz.setCellValueFactory(new PropertyValueFactory<Jarmu,Jarmu.MotorStatusz>("Motorstatusz"));

        //ChoiceBox
        jh_tipus.getItems().addAll(tipusok);
        jh_tipus.setValue(tipusok[0]);

        jh_uzemanyag.getItems().addAll(Uzemanyag.Tipus.values());
        jh_uzemanyag.setValue(Uzemanyag.Tipus.values()[0]);

        jh_szin.getItems().addAll(Jarmu.Szin.values());
        jh_szin.setValue(Jarmu.Szin.values()[0]);

        refreshTableViewContent();

    }

    //WindowAlert - Létrehoz egy Alert ablakot
    public void windowAlert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Figyelem!");
        alert.setHeaderText(message);
        alert.show();
    }

    public void refreshTableViewContent()
    {
        emberek_tableview.setItems(FXCollections.observableArrayList(Main.Emberek));
        emberek_tableview.refresh();

        jarmuvek_tableview.setItems(FXCollections.observableArrayList(Main.Jarmuvek));
        jarmuvek_tableview.refresh();

        jm_tulajdonos.getItems().clear();
        jm_tulajdonos.getItems().addAll(Main.Emberek);
        jm_tulajdonos.setValue(Main.Emberek.get(0));

        jm_sofor.getItems().clear();
        jm_sofor.getItems().addAll(Main.Emberek);
        jm_sofor.setValue(Main.Emberek.get(0));

        jb_tulajdonos.getItems().clear();
        jb_tulajdonos.getItems().addAll(Main.Emberek);
        jb_tulajdonos.setValue(Main.Emberek.get(0));

        jb_sofor.getItems().clear();
        jb_sofor.getItems().addAll(Main.Emberek);
        jb_tulajdonos.setValue(Main.Emberek.get(0));

    }

    @FXML
    protected void eh_hozzad_onaction()
    {
        if(eh_nev.getText() != null && eh_nev.getText() != "")
        {
            Ember ember = new Ember(eh_nev.getText(), Integer.parseInt(eh_kor.getValue().toString()));
            Main.Emberek.add(ember);
            refreshTableViewContent();
        }
        else{
            windowAlert("A név mező nem lehet üres!");
        }

    }

    @FXML
    protected void em_modosit_onaction()
    {

        Ember ember = emberek_tableview.getSelectionModel().getSelectedItem();

        if(ember != null)
        {
            if(em_nev.getText() != null && em_nev.getText() != "")
            {
                Ember emberm = Main.Emberek.get(Main.Emberek.indexOf(ember));
                emberm.setNev(em_nev.getText());
                emberm.setKor(Integer.parseInt(em_kor.getValue().toString()));
                Main.Emberek.set(Main.Emberek.indexOf(ember),emberm);
                refreshTableViewContent();
            }
            else
            {
                windowAlert("A név mező nem lehet üres!");
            }
        }
        else{
            windowAlert("Nincs kiválasztva ember!");
        }
    }

    @FXML
    protected void em_torles_onaction()
    {
        Ember ember = emberek_tableview.getSelectionModel().getSelectedItem();

        if(ember != null)
        {
            Main.Emberek.remove(ember);
            refreshTableViewContent();
        }
        else
        {
            windowAlert("Nincs kiválasztva Ember!");
        }

    }

    @FXML
    protected void js_jogositvanyszerzese_onaction()
    {
        Ember ember = emberek_tableview.getSelectionModel().getSelectedItem();

        if(ember != null)
        {
            if(ember.getJogositvany().jogositvanyKod != -1)
            {
                if(ember.getKor() >= 18)
                {
                    Main.Emberek.get(Main.Emberek.indexOf(ember)).getJogositvany();
                }
                else
                {
                    windowAlert("A kiválasztott Ember még nem szerezhet jogosítványt, mert nem múlt el 18 éves.");
                }
            }
            else
            {
                windowAlert("A kiválasztott embernek már van jogosítványa!");
            }



        }
        else
        {
            windowAlert("Nincs kiválasztva ember!");
        }
    }

    @FXML
    protected void jh_hozzaad_onaction()
    {
        if(jh_nev.getText() != null && jh_nev.getText() != "")
        {
            if(jh_tipus.getValue() == "Autó")
            {
                Auto auto = new Auto(jh_nev.getText(), jh_szin.getValue(), new Uzemanyag(jh_uzemanyag.getValue(),Integer.parseInt(jh_uzemanyagmennyiseg.getValue().toString())));
                Main.Jarmuvek.add(auto);
            }
            if(jh_tipus.getValue() == "Motor")
            {
                Motor motor = new Motor(jh_nev.getText(), jh_szin.getValue(), new Uzemanyag(jh_uzemanyag.getValue(),Integer.parseInt(jh_uzemanyagmennyiseg.getValue().toString())));
                Main.Jarmuvek.add(motor);
            }

            refreshTableViewContent();

        }
        else{
            windowAlert("A név mező nem lehet üres!");
        }
    }

    @FXML
    protected void jm_modosit_onaction()
    {
        Jarmu jarmu = jarmuvek_tableview.getSelectionModel().getSelectedItem();

        if(jm_nev.getText() != null && jm_nev.getText() != "")
        {
            if(jm_sofor.getValue() != null && jm_tulajdonos.getValue() != null)
            {
                if(jarmu.getClass() == Auto.class)
                {
                    Main.Jarmuvek.set(Main.Jarmuvek.indexOf(jarmu), new Auto(jm_nev.getText(), jarmu.getSzin(), new Uzemanyag(jarmu.getUzemanyag().getTipus(), Integer.parseInt(jm_uzemanyagmennyiseg.getValue().toString())), jm_tulajdonos.getValue(), jm_sofor.getValue()));
                }
                if(jarmu.getClass() == Motor.class)
                {
                    windowAlert("Motor");
                }

                refreshTableViewContent();
            }
            else
            {
                windowAlert("A tulajdonos vagy a sofőr nem lehet üres!");
            }
        }
        else
        {
            windowAlert("A név mező nem lehet üres!");
        }

    }

     @FXML
    protected void jm_torles_onaction()
     {
        Jarmu jarmu = jarmuvek_tableview.getSelectionModel().getSelectedItem();

        if(jarmu != null)
        {
            Main.Jarmuvek.remove(jarmu);
            refreshTableViewContent();
        }
        else
        {
            windowAlert("Nincs kiválasztva Jármű!");
        }


     }

    @FXML
    protected void jb_beindit_onaction()
    {
        Jarmu jarmu = jarmuvek_tableview.getSelectionModel().getSelectedItem();

        if(jarmu != null)
        {
            if(jarmu.getTulajdonos() != null && jarmu.getSofor() != null && jarmu.getTulajdonos().getNev() != "Nincs" && jarmu.getSofor().getNev() != "Nincs")
            {
                Main.Jarmuvek.get(Main.Jarmuvek.indexOf(jarmu)).beinditas();
            }
            else
            {
                if(jb_tulajdonos.getValue() != null && jb_sofor.getValue() != null)
                {
                    if(Main.Jarmuvek.get(Main.Jarmuvek.indexOf(jarmu)).getSofor().getJogositvany().jogositvanyKod != -1)
                    {
                        Main.Jarmuvek.get(Main.Jarmuvek.indexOf(jarmu)).setSofor(jb_sofor.getValue());
                        Main.Jarmuvek.get(Main.Jarmuvek.indexOf(jarmu)).setTulajdonos(jb_tulajdonos.getValue());
                        Main.Jarmuvek.get(Main.Jarmuvek.indexOf(jarmu)).beinditas();
                    }
                    else
                    {
                        windowAlert("A kiválaszott jármű sofőrjének nincs érvényes jogosítványa!");
                    }
                }
                else
                {
                    windowAlert("A kiválaszott járműnek nincs tulajdonosa, ezért beinditáskor kötelező megadni!");
                }

            }

            refreshTableViewContent();

        }
        else
        {
            windowAlert("Nincs kiválasztva Jármú!");
        }
    }

    @FXML
    protected void jb_leallit_onaction()
    {
        Jarmu jarmu = jarmuvek_tableview.getSelectionModel().getSelectedItem();

        if(jarmu != null)
        {
            Main.Jarmuvek.get(Main.Jarmuvek.indexOf(jarmu)).leallitas();
        }
        else
        {
            windowAlert("Nincs kiválasztva Jármű!");
        }

        refreshTableViewContent();

    }


}
