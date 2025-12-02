package com.example;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @GetMapping // Mapeia exatamente para /api/quiz
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Endpoint base do Quiz API. Tente /api/quiz/questionario ou /api/quiz/calcular-perfil.");
    }

    @GetMapping("/questionario")
    public List<Pergunta> getQuestionario() {
        return quizService.getQuestionario();
    }

    @PostMapping("/calcular-perfil")
    public ResponseEntity<Map<String, String>> calcularPerfil(@RequestBody List<RespostaDTO> respostas){
        if (respostas == null || respostas.size() != 12) {
            return ResponseEntity.badRequest().body(Map.of("Erro", "É necessário responder a todas as 12 perguntas."));
        }
        String perfil = quizService.calcularPerfil(respostas);

        return ResponseEntity.ok(Map.of("perfil_do_investidor", perfil));
    }
}



