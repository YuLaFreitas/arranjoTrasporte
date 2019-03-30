package com.transporte.controle;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import java.util.ArrayList;

public class DadosPassageiros<i> {

    private String nome;
    //ver se há necessidade de alterar atributo das variaveis
    private String sobrnome;
    private String telefone;
    private String idade;
    private String valor;
    private String carro;
    private String ponto;
    private String acento;
    private String id;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrnome(String sobrnome) {
        this.sobrnome = sobrnome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public void setPonto(String ponto) {
        this.ponto = ponto;
    }

    public void setAcento(String acento) {
        this.acento = acento;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static DadosPassageiros[] getLugar() {
        return lugar;
    }

    public DadosPassageiros(String nome, String sobrnome, String telefone, String idade,
                            String valor, String carro, String ponto, String acento) {

        this.nome = nome;
        this.sobrnome = sobrnome;
        this.telefone = telefone;
        this.idade = idade;
        this.valor = valor;
        this.carro = carro;
        this.ponto = ponto;
        this.acento = acento;
        this.id = String.valueOf(id);
    }

    /*@Override
    public String toString() {
        return this.nome;
    }*/
    public static String getIdLugar(int a){
        String[] idLugar = null;

        for(int i=0; i>50; i++)  {

            idLugar[i] = "" + i;
        }

        String idLugarAx = idLugar[a];

        return idLugarAx;
    }
    public String getNome() {
        return nome;
    }

    public String getSobrnome(){
        return sobrnome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getIdade() {
        return idade;
    }

    public String getValor() {
        return valor;
    }

    public String getCarro(){
        return carro;
    }

    public String getPonto() {
        return ponto;
    }

    public String getAcento() {
        return acento;
    }



    public void setLugar(int id, String nome,String sobrnome, String telefone, String idade,
                         String valor, String carro,String ponto, String acento){

        lugar[id] = new DadosPassageiros(nome, sobrnome,telefone, idade,
                        valor,carro,ponto,acento);
    }

    public static final DadosPassageiros[] lugar = {

            new DadosPassageiros( "pessoa","seu nome é pessoa",
                    "75985","58","25,5","1","asdasasd",
            "142"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "1"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "2"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "3"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "4"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "5"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "6"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "7"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "08"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "09"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "10"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "11"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "12"),
            new DadosPassageiros( "","",
                    "","","","","",
                    "13"),



 };

}