package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;

    //Escolhido tipo Set pois conforme for criando será sendo salvo na ordem
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }


    public void inscreverBootcamp(Bootcamp bootcamp){
        //Add os conteudos
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        //Add o dev que está inscrito no bootcamp
        bootcamp.getDevsInscritos().add(this);
    }

    public void progedirXP(){
        //Optional aceita valores nulos
        Optional<Conteudo> optionalConteudo = conteudosInscritos.stream().findFirst();
        if(optionalConteudo.isPresent()){
            this.conteudosConcluidos.add(optionalConteudo.get()); //conteudos concluidos
            this.conteudosInscritos.remove(optionalConteudo.get()); //remove o conteudo da lista de inscritos
        }else{
            System.err.println("Você não está matriculado em nenhum contéudo.");
        }
    }

    public double calcularTotalXP(){
        return this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXP()).sum();
    }

    //Foi necessário criar pois estamos utilizando Hash
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
