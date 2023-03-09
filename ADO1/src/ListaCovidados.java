import java.util.Arrays;

public class ListaCovidados {
    private String[] convidados;
    private int tamanho;

    public ListaCovidados(int capacidade){
        this.convidados = new String[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(String convidado)throws Exception{
        this.aumentaCapacidade();
        if (this.tamanho < this.convidados.length){
            this.convidados[this.tamanho] = convidado;
            this.tamanho++;
        } else {
            throw new Exception("A lista já está cheia, "
                    + "não é possível adicionar novos convidados");
        }  
  
    }

    public int tamanho(){
        return this.tamanho;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        
        for(int i=0; i<this.tamanho-1; i++){
            s.append(this.convidados[i]);
            s.append(", ");
        }
        
        if(this.tamanho> 0){
            s.append(this.convidados[this.tamanho-1]);
        }
        
        s.append("]");
                
        return s.toString();
    }

    public String busca(int posicao)throws Exception{
        if(posicao >=0 && posicao < tamanho){
            return convidados[posicao];
        } else {
            throw new Exception("Posição Inválida");
        }  
    }

    private void aumentaCapacidade(){
        if (this.tamanho == this.convidados.length){
            String[] convidadosNovos = new String[this.convidados.length * 2];
            for (int i=0; i<this.convidados.length; i++){
                convidadosNovos[i] = this.convidados[i];
            }
            this.convidados = convidadosNovos;
        }
    }

}