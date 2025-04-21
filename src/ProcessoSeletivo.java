import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main (String[] args){
        imprimirSelecionados();
    }

    //metodo auxiliar / Simula 3 tentativas de contato.
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String[] candidatos = {
                "Ana Souza",
                "Bruno Lima",
                "Carlos Alberto",
                "Daniela Rocha",
                "Eduardo Melo"
        };
        /*
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for(int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de n° " + indice + " é " + candidatos[indice] );
        }
        */
        //forEach Java
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi: " + candidato);
            entrandoEmContato(candidato);
        }

    }
    static void entrandoEmContato (String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }else
                System.out.println("Contato Realizado com Sucesso!");
        }while(continuarTentando && tentativasRealizadas < 3);
        if (atendeu){
            System.out.println("Conseguimos contato com "+ candidato + " na " + tentativasRealizadas + " tentativa.");
        }else
            System.out.println("Não conseguimos contato com " + candidato + ", numero maximo tentativas " + tentativasRealizadas + " realizadas.");
    }


    static void selecaoCandidatos(){
        String[] candidatos = {
                "Ana Souza",
                "Bruno Lima",
                "Carlos Alberto",
                "Daniela Rocha",
                "Eduardo Melo",
                "Fernanda Castro",
                "Gabriel Nunes",
                "Helena Martins",
                "Igor Ferreira",
                "Juliana Alves"
        };
        int candidatosSelecionados = 0;
        int candidatoAtual =0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase > salarioPretendido){
                System.out.println("O candidato " +candidato+ " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }

    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar Candidato");

        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta.");
        }else {
            System.out.println("Aguardardando o resultado dos demais candidatos");
        }
    }
}
