import br.com.dio.desafio.dominio.*;

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

        //System.out.println("\n*****CURSOS*****\n"+curso+"\n"+curso2+"\n*****MENTORIA*****\n"+mentoria);

        //POLIMORFISMO
        //Conteudo conteudo = new Curso();

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcampo Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos da Camila: "+devCamila.getConteudosInscritos());
        devCamila.progedirXP();
        devCamila.progedirXP();
        System.out.println("Conteudos concluidos da Camila: "+devCamila.getConteudosInscritos());

        System.out.println("Valor total do XP: "+devCamila.calcularTotalXP());

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos do João: "+devJoao.getConteudosInscritos());
        devJoao.progedirXP();
        System.out.println("Conteudos concluidos do João: "+devJoao.getConteudosInscritos());
        System.out.println("Valor total do XP: "+devJoao.calcularTotalXP());
    }
}
