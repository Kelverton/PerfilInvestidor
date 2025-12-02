// URLs do seu backend Spring Boot
const API_BASE_URL = 'http://localhost:8080/api/quiz';
const API_QUESTIONS_URL = `${API_BASE_URL}/questionario`;
const API_CALC_URL = `${API_BASE_URL}/calcular-perfil`;

const quizContainer = document.getElementById('quiz-container');

let questions = [];
let currentQuestionIndex = 0;
// Lista para armazenar as respostas no formato DTO exigido pelo backend
let userResponses = [];

// Função principal para carregar os dados da API
async function loadQuiz() {
    try {
        const response = await fetch(API_QUESTIONS_URL);
        if (!response.ok) throw new Error('Falha ao carregar as perguntas da API.');

        questions = await response.json();
        questions.sort((a, b) => a.id - b.id);
        
        if (questions.length === 0) throw new Error('Nenhuma pergunta recebida.');

        displayCurrentQuestion();

    } catch (error) {
        console.error("Erro:", error);
        quizContainer.innerHTML = `<p>Erro ao carregar o quiz. Tente novamente mais tarde.</p>`;
    }
}

// Função para exibir a pergunta atual
function displayCurrentQuestion() {
    const questionData = questions[currentQuestionIndex];

    let htmlContent = `
        <h2>Pergunta ${questionData.id} de ${questions.length}</h2>
        <p>${questionData.enunciado || 'Texto da pergunta não disponível'}</p>
        <form id="question-form">
    `;

    // Itera sobre as opções (A, B, C, D, E)
    for (const optionKey in questionData.opções) {
        const optionValue = questionData.opções[optionKey];
        htmlContent += `
            <div>
                <input type="radio" id="option-${optionKey}" name="resposta" value="${optionKey}" required>
                <label for="option-${optionKey}">${optionKey}) ${optionValue}</label>
            </div>
        `;
    }

    htmlContent += `
            <button type="submit">${currentQuestionIndex === questions.length - 1 ? 'Ver Resultado' : 'Próxima'}</button>
        </form>
    `;

    quizContainer.innerHTML = htmlContent;

    // Adiciona o listener para o formulário recém-criado
    document.getElementById('question-form').addEventListener('submit', handleFormSubmit);
}

// Função para lidar com o envio do formulário de uma única pergunta
function handleFormSubmit(event) {
    event.preventDefault(); // Impede o recarregamento da página

    const selectedOption = document.querySelector('input[name="resposta"]:checked').value;
    const currentQuestionId = questions[currentQuestionIndex].id;

    // Salva a resposta no formato DTO que o backend espera
    userResponses.push({
        id: currentQuestionId,
        opcaoSelecionada: selectedOption
    });

    // Avança para a próxima pergunta ou termina o quiz
    currentQuestionIndex++;

    if (currentQuestionIndex < questions.length) {
        displayCurrentQuestion();
    } else {
        submitQuizResults();
    }
}

// Função para enviar todas as respostas para o backend Spring Boot API
async function submitQuizResults() {
    quizContainer.innerHTML = "<h1>Calculando seu perfil...</h1>";

    try {
        const response = await fetch(API_CALC_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userResponses) // Envia a lista completa de DTOs
        });

        if (!response.ok) throw new Error('Falha ao calcular o perfil.');

        const resultData = await response.json();
        // Assume que o backend retorna algo como: {"perfil_do_investidor": "Perfil Conservador"}

        displayResult(resultData.perfil_do_investidor);

    } catch (error) {
        console.error("Erro:", error);
        quizContainer.innerHTML = `<p>Erro ao finalizar o quiz.</p>`;
    }
}

// Função para mostrar o resultado final
function displayResult(perfil) {
    quizContainer.innerHTML = `
        <h1>Resultado do Quiz</h1>
        <p>Seu perfil de investidor é: <strong>${perfil}</strong></p>
        <button onclick="window.location.reload()">Fazer novamente</button>
    `;
}

// Inicia o quiz quando o script carrega
loadQuiz();
