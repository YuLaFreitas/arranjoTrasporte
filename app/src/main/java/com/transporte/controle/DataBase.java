package com.transporte.controle;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    int id;
    String nome, sobrenome, telefone, valor, dia, carro, acento, data, valorRec, ponto, idade;

    private static final String dataBaseName = "dadosArranjo";

    private static final int versao = 1;

    private static final String tabelaPassageiros =
            "CREATE TABLE " + dataBaseName + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT," +
                    "sobrnome TEXT," +
                    "telefone INTEGER," +
                    "idade INTEGER," +
                    "valor REAL" +
                    ");";
    //A tabelaVeiculo sera carregada com valores automaticamente
    private static final String tabelaVeiculo =
            "CREATE TABLE " + dataBaseName + " (" +
                    "dia INTEGER not null," +
                    "carro INTEGER not null," +
                    "acento INTEGER not null," +

                    "ocupanteKEY INTEGER," +
                    "PRIMARY KEY(dia, carro, acento)" +
                    ");";

    static String dataTR="data", valorTR="valor";
    private static final String tabelaRelatorio =
            "CREATE TABLE " + dataBaseName + " (" +
                    dataTR +" INTEGER,"
                    + valorTR +" REAL" +
                    //futuramente quero colocar fotos do raltorio aqui também
                    ");";

    DataBase(Context context) {
        super(context, dataBaseName, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(tabelaPassageiros);
       //db.execSQL(tabelaVeiculo);
        db.execSQL(tabelaRelatorio);

        //gerarAcento(1, 1, db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + dataBaseName);
    onCreate(db);
    }

    @Override //serve para retoceder a verão do banco de dados
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
/*
    public void InserirDados(ContentValues cv, SQLiteDatabase db, int a){

        String nomeTabela = null;

        switch(a){
            case 1: nomeTabela = tabelaPassageiros;break;

            case 2: nomeTabela = tabelaVeiculo; break;
            case 3: nomeTabela = tabelaRelatorio; break;
        }
        db.insert(nomeTabela, null, cv);
    }

    public List<ContentValues>PesuisarAll(int a) {

        String nomeTabela = null;

        switch(a){
            case 1: nomeTabela = tabelaPassageiros;break;

            case 2: nomeTabela = tabelaVeiculo; break;
            case 3: nomeTabela = tabelaRelatorio; break;
        }
        String sql = "SELECT * FROM '" + nomeTabela;
        return pesquisa(sql, null, a);
    }

    public List<ContentValues>PesuisarId(int a){

        String nomeTabela = null;

        switch(a){
            case 1: nomeTabela = tabelaPassageiros;break;
            case 2: nomeTabela = tabelaVeiculo; break;
            case 3: nomeTabela = tabelaRelatorio; break;
        }
        String sql = "SELECT id FROM '" + nomeTabela;
        return pesquisa(sql, null, a);
    }

    /*public void upDate(SQLiteDatabase db, int a){
        String nomeTabela;
        switch (a) {
            case 1:
                nomeTabela = tabelaPassageiros;
                break;
            case 2:
                nomeTabela = tabelaVeiculo;
                break;
            case 3:
                nomeTabela = tabelaRelatorio;
                break;
        }

        ContentValues cv = new ContentValues();
        cv.put();

        db.update(nomeTabela,,null);
    }

    public List<ContentValues>PesquisarWord(String key, int a, int bd){

        String nomeTabela = tabelaPassageiros;

        String sql = "SELECT '"+ key +"'FROM '" + nomeTabela + "' WHERE id = " + a +"";
        return pesquisa(sql, null, bd);
    }

    private List<ContentValues> pesquisa(String sql, String where[], int a){
        List<ContentValues> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        DadosPassageiros dadosPassageiros = null;

    Cursor cursor =db.rawQuery(sql, where);
        switch (a) {
            case 1://TABELA DAS PESSOAS
                if (cursor.moveToFirst()) {
                    do {

                        ContentValues cv = new ContentValues();

                        cv.put("id", cursor.getColumnIndex("id"));
                        id = 1;//(int) cv.get("id");
                        cv.put("nome", cursor.getColumnIndex("nome"));
                        nome = "fernanda";//cv.get("nome").toString();
                        cv.put("sobrenome", cursor.getColumnIndex("sobrenome"));
                        sobrenome = cv.get("sobrenome").toString();
                        cv.put("tel", cursor.getColumnIndex("tel"));
                        telefone = cv.get("tel").toString();
                        cv.put("idade", cursor.getColumnIndex("idade"));
                        idade = cv.get("idade").toString();
                        cv.put("valor", cursor.getColumnIndex("valor"));
                        valor = cv.get("valor").toString();

                        list.add(cv);

                    } while (cursor.moveToNext());
                }

            case 2://TABELA DO VEICULO
                if (cursor.moveToFirst()) {
                    do {
                        ContentValues cv = new ContentValues();

                        cv.put("id", cursor.getColumnIndex("id"));
                        id = 1;//(int) cv.get("id");
                        cv.put("dia", cursor.getColumnIndex("dia"));
                        dia = "1";//cv.get("dia").toString();
                        cv.put("carro", cursor.getColumnIndex("carro"));
                        carro = "1";//cv.get("carro").toString();
                        cv.put("acento", cursor.getColumnIndex("acento"));
                        acento = "1";//cv.get("acento").toString();

                        list.add(cv);

                    } while (cursor.moveToNext());
                }

            case 3:// TABELA DO RELATORIO
                if (cursor.moveToFirst()) {
                    do {
                        ContentValues cv = new ContentValues();

                        cv.put("id", cursor.getColumnIndex("id"));
                        cv.put("valor", cursor.getColumnIndex("valor"));
                        cv.put("data", cursor.getColumnIndex("data"));

                        list.add(cv);

                    } while (cursor.moveToNext());
                }
                default:
                 if(cursor.moveToFirst()) {
                     do {

                         dadosPassageiros.setLugar(id, nome,sobrenome, telefone,
                                 idade, valor, carro, ponto, acento);
                         //new DadosPassageiros(id, nome,sobrenome, telefone,
                                //idade, valor, carro, ponto, acento);
                     } while (cursor.moveToNext());
                 }
        }
        return list;
    }

    //ele vai gerar os dias carros e acentos segundo comando
    public void gerarAcento(int carros,int dias, SQLiteDatabase db){

        Cursor cursor =
                db.rawQuery("SELECT COUNT(*) from '" + tabelaVeiculo + "';", null);

        String sql;
        if(cursor == null) {
            int dia = dias;

            for (int car = 1; car >= carros; car++) {
                for (int acento = 1; acento >= 50; acento++) {

                    sql = "Insert INTO '" + tabelaVeiculo +
                            "' (carro, acento, dia, ocupado) " +
                            "VALUES (" + dia + "," + car + "," + acento + ", 0);";

                    db.execSQL(sql);
                }
            }
        }
    }*/

    }
