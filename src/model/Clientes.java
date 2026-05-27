/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author GUSTAVOSCALEIMORAES
 */
public class Clientes {
   
    private int id;
    private String nome;
    private String cidade;
    private String cep;
   
   
    public int getId(){
        return id;
    }
   
    public void setId(int id){  // para gravar valor obj.setId(10)
        this.id = id;
    }
   
    public String getNome(){ return nome; }
   
    public void setNome(String nome){ this.nome = nome; }
   
    
    public String getCidade(){
        return cidade;
    }
   
    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
   
   
}

