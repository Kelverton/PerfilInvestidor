package com.example;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {
    private final List<Pergunta> questionario = new ArrayList<>();

    private static final Map<String, Integer> PONTUACAO;
    static {
        PONTUACAO = new HashMap<>();
        PONTUACAO.put("A", 1);
        PONTUACAO.put("B", 2);
        PONTUACAO.put("C", 3);
        PONTUACAO.put("D", 4);
        PONTUACAO.put("E", 5);
    }
    @PostConstruct
    public void inicializarQuestionario() {
        Map<String, String> opções1 = Map.of(
                "A", "Preservar meu capital, com foco na segurança.",
                "B", "Proteger o poder de compra do meu dinheiro contra a inflação.",
                "C", "Obter um crescimento moderado do meu patrimônio a médio prazo.",
                "D", "Buscar alto crescimento e valorização do capital a longo prazo.",
                "E", "Maximizar o retorno, mesmo que isso envolva grande risco de perda."

        );
        questionario.add(new Pergunta(1, " Qual é o seu objetivo principal ao investir?", opções1));
        Map<String, String> opções2 = Map.of(
                "A", "Curto prazo (até 1 ano).",
                "B", "Médio prazo (1 a 3 anos).",
                "C", " Médio a longo prazo (3 a 5 anos).",
                "D", "Longo prazo (acima de 5 anos).",
                "E", "Indeterminado, sem necessidade de resgate em um horizonte previsível."

        );
        questionario.add(new Pergunta(2, "Por quanto tempo você pretende manter seus investimentos?", opções2));
        Map<String, String> opções3 = Map.of(
                "A", "Ficaria muito preocupado(a) e resgataria todos os meus investimentos. ",
                "B", "Ficaria preocupado(a), mas apenas resgataria uma parte.",
                "C", "Ficaria observando, sem tomar nenhuma atitude imediata.",
                "D", "Manteria o investimento e talvez faria novos aportes.",
                "E", "Encararia como uma oportunidade para investir ainda mais, comprando ativos a preços menores."

        );
        questionario.add(new Pergunta(3, "Como você reagiria a uma oscilação negativa de 10% no valor total da sua carteira em um mês?", opções3));
        Map<String, String> opções4 = Map.of(
                "A", "Iniciante. Prefiro investimentos simples e de baixo risco.",
                "B", "Básico. Tenho alguma familiaridade com investimentos de renda fixa.",
                "C", " Intermediário. Conheço diversos produtos de renda fixa e alguns de renda variável.",
                "D", "Avançado. Tenho conhecimento sobre diferentes tipos de ativos e estratégias de investimento.",
                "E", "Especialista. Sou um investidor experiente e acompanho o mercado ativamente."

        );
        questionario.add(new Pergunta(4, "Qual é o seu nível de conhecimento sobre o mercado financeiro e seus produtos?", opções4));
        Map<String, String> opções5 = Map.of(
                "A", "Praticamente nenhuma.",
                "B", "Menos de 10%.",
                "C", "Entre 10% e 20%.",
                "D", "Entre 20% e 40%.",
                "E", "Mais de 40%."

        );
        questionario.add(new Pergunta(5, "Qual a parcela da sua renda mensal você consegue poupar?", opções5));
        Map<String, String> opções6 = Map.of(
                "A", "Não tenho e não considero importante.",
                "B", "Tenho, mas o valor é inferior ao ideal.",
                "C", "Tenho um valor equivalente a 3 meses dos meus gastos.",
                "D", "Tenho um valor equivalente a 6 meses dos meus gastos.",
                "E", "Tenho um valor equivalente a 12 meses ou mais dos meus gastos."

        );
        questionario.add(new Pergunta(6, "Você tem reserva de emergência?", opções6));
        Map<String, String> opções7 = Map.of(
                "A", "Poupança e renda fixa de baixo risco, como CDBs.",
                "B", "Renda fixa de maior rentabilidade, como títulos privados e Tesouro Direto.",
                "C", "Fundos de investimento multimercado com exposição moderada em renda variável.",
                "D", "Ações, fundos de ações e fundos de investimento com alto risco.",
                "E", "Futuros, opções e outros derivativos de alto risco."

        );
        questionario.add(new Pergunta(7, "Em qual tipo de investimento você se sente mais confortável?", opções7));
        Map<String, String> opções8 = Map.of(
                "A", "Preciso de acesso imediato, ou em poucos dias.",
                "B", "Posso esperar até 30 dias.",
                "C", "Posso esperar entre 30 e 90 dias.",
                "D", "Posso esperar mais de 90 dias.",
                "E", "Não me preocupo com a liquidez a curto prazo."


        );
        questionario.add(new Pergunta(8, "Quando você precisa de dinheiro, quanto tempo pode esperar para resgatar seus investimentos?", opções8));
        Map<String, String> opções9 = Map.of(
                "A", "Segurança >> Rentabilidade e Liquidez.",
                "B", "Segurança > Rentabilidade e Liquidez.",
                "C", "Equilíbrio entre Segurança, Rentabilidade e Liquidez.",
                "D", "Rentabilidade > Segurança e Liquidez.",
                "E", "Rentabilidade >> Segurança e Liquidez."

        );
        questionario.add(new Pergunta(9, "Para você, qual a prioridade entre segurança, rentabilidade e liquidez?", opções9));
        Map<String, String> opções10 = Map.of(
                "A", "Menos de 25 anos.",
                "B", "De 25 a 35 anos.",
                "C", "De 36 a 50 anos.",
                "D", "De 51 a 65 anos.",
                "E", "Acima de 65 anos."

        );
        questionario.add(new Pergunta(10, "Qual é a sua idade?", opções10));
        Map<String, String> opções11 = Map.of(
                "A", "Acima de 65 anos.",
                "B", "De 51 a 65 anos.",
                "C", "De 36 a 50 anos.",
                "D", "De 25 a 35 anos.",
                "E", "Menos de 25 anos."


        );
        questionario.add(new Pergunta(11, "Qual das frases abaixo mais se aproxima do seu pensamento sobre o futuro dos seus investimentos?", opções1));
        Map<String, String> opções12 = Map.of(
                "A", "Aposentadoria, pensão ou renda passiva de baixo risco.",
                "B", "Renda de trabalho formal, com estabilidade razoável.",
                "C", "Renda de trabalho liberal, com certa instabilidade.",
                "D", "Renda variável de negócios próprios ou investimentos.",
                "E", "Minha renda depende totalmente de resultados no mercado financeiro."


        );
        questionario.add(new Pergunta(12, "Qual é a sua principal fonte de renda?", opções12));
    }
    public String calcularPerfil(List<RespostaDTO> respostas) {
        int pontuacaoTotal = 0;

        // Itera sobre as respostas do usuário e soma os pontos
        for (RespostaDTO resposta : respostas) {
            String opcao = resposta.getOpcaoSelecionada().toUpperCase();
            if (PONTUACAO.containsKey(opcao)) {
                pontuacaoTotal += PONTUACAO.get(opcao);
            }
        }

        // Lógica de classificação baseada nos limites de pontuação (exemplo)
        // O número máximo de pontos é 12 perguntas * 5 pontos/resp = 60 pontos.
        // O número mínimo é 12 perguntas * 1 ponto/resp = 12 pontos.

        if (pontuacaoTotal <= 24) {
            return "Perfil Conservador";
        } else if (pontuacaoTotal <= 40) {
            return "Perfil Moderado";
        } else {
            return "Perfil Arrojado/Agressivo";
        }
    }

    public List<Pergunta> getQuestionario() {
        return this.questionario;
    }
}

