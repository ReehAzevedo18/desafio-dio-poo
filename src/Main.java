import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Curso curso = new Curso();
        Curso curso2 = new Curso();
        curso.setTitulo("Java");
        curso.setDescricao("Linguagem de programação");
        curso.setCargaHoraria(8);

        curso2.setTitulo("JS");
        curso2.setDescricao("Linguagem de programação");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria da Camile - Java");
        mentoria.setDescricao("Descrição mentoria da Camile");
        mentoria.setData(LocalDate.now());

        System.out.println("\n*****CURSOS*****\n"+curso+"\n"+curso2+"\n*****MENTORIA*****\n"+mentoria);
    }
}
