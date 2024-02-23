package org.example.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

public abstract class Arquivos {

    public static final File DIRETORIO = new File("cache");
    public static final String EXTENSAO = ".kv";

    public static File gerarArquivo(String nomearquivo) {

        if (!DIRETORIO.exists())
            DIRETORIO.mkdir();
        File arquivo = new File(DIRETORIO.getName() + "/" + nomearquivo + EXTENSAO);

        if (!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                return null;
            }
        }
        return arquivo;
    }

    public static <V> HashMap<String, V> consultarArquivoMap(File file){
        HashMap<String, V> map;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            map = (HashMap<String, V>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            map = new HashMap<>();
        }
        return map;
    }

    public static <V> List<V> consultarArquivoList(File file){
        List<V> list;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<V>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            list = new ArrayList<>();
        }
        return list;
    }


    public static boolean sobreescreverArquivo(File arquivo, Map map){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(map);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void apagarConteudoArquivo(File arquivo) {
        try {
            new FileOutputStream(arquivo).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}