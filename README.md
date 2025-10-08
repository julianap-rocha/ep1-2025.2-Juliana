# 🏥 Trabalho Prático – Sistema de Gerenciamento Hospitalar  

### 🎯 Objetivo  
Implementar um *Sistema de Gerenciamento Hospitalar* em *Java, aplicando conceitos avançados de **Programação Orientada a Objetos (POO), com foco em **herança, polimorfismo, encapsulamento, persistência de dados* e *regras de negócio mais complexas*.  

---
## Descrição do Projeto

Desenvolvimento de um sistema de gerenciamento hospitalar utilizando os conceitos de orientação a objetos (herança, polimorfismo e encapsulamento) e persistência de dados em arquivos.

## Diagrama do Projeto

<img width="931" height="602" alt="Diagrama do Projeto" src="https://github.com/user-attachments/assets/7fc2359c-6dcd-4682-ab62-54ff618e864a" />


## Dados do Aluno

- **Nome completo:** [Juliana Pereira da Rocha]
- **Matrícula:** [251037125]
- **Curso:** [Engenharias]
- **Turma:** [06]

---

## Instruções para Compilação e Execução

1. **Compilação:**  
   [No diretório src da pasta Sistema Hospitalar, execute o script `javac app/*.java model/*.java util/*.java`]

2. **Execução:**  
   [No mesmo diretório src da pasta Sistema Hospitalar, execute o script `java app.Main`]

3. **Estrutura de Pastas:**  
   [No projeto existem 3 pastas principais:
   
   `model:` Contém toda a base do sistema, `Consulta, DadoPersistente, Internacao, Medico, Paciente, Paciente Comum, Paciente Especial, Pessoa, Plano de Saúde`
   
   `util:`Contém todas as classes de utilidade do sistema, `Persistencia, Relatorios`
   
   `app:` Contém a classe main que é responsável pela execução, `Main`]

3. **Versão do JAVA utilizada:**  
   [O projeto foi desenvolvido utilizando o `java 21`]

---

## Vídeo de Demonstração

- [https://www.youtube.com/watch?v=NjoJeGp4vrM]

---

## Prints da Execução

1. Menu Principal:  
   <img width="341" height="157" alt="MenuPrincipal" src="https://github.com/user-attachments/assets/4a99020e-9d59-40e4-8a18-ad860cbe225b" />


2. Cadastro de Médico:  
   <img width="360" height="162" alt="CadastroDeMedico" src="https://github.com/user-attachments/assets/e264f846-0d41-4e33-88d2-50012f2527eb" />


3. Relatório de Pacientes Cadastrados:  
   <img width="497" height="198" alt="RelatorioPacientesCadastrados" src="https://github.com/user-attachments/assets/a710fa00-0ecf-434e-b131-97465ef0483e" />


---

---

## Observações (Extras ou Dificuldades)

- [O desenvolvimento desse projeto foi uma experiência complicada, mas com um grande aprendizado. Desde o início, o mais importante pra mim foi o planejamento para saber como começar, e por conta disso eu criei um diagrama para guiar na implementação. Um dos principais desafios foi interações com muitas classes, listas e funcionalidades diferentes, e eu precisei ver muitos vídeos para resolver minhas dúvidas. Além disso, me adaptar a trabalhar com o Git, tendo que realizar commits de forma consistente, foi um novo aprendizado. Apesar de todos esses desafios, a experiência de aplicar esses conceitos na prática, como comentários nos códigos, resolver bugs, foi muito gratificante e me deixou motivada para o próximo projeto.]

---

## Contato

- [julianapereirarocha2007@gmail.com]

---

### 🖥️ Descrição do Sistema  

O sistema deve simular o funcionamento de um hospital com cadastro de *pacientes, médicos, especialidades, consultas e internações*.  

1. *Cadastro de Pacientes*  
   - Pacientes comuns e pacientes especiais (ex: com plano de saúde).  
   - Cada paciente deve ter: nome, CPF, idade, histórico de consultas e internações.  

2. *Cadastro de Médicos*  
   - Médicos podem ter especialidades (ex: cardiologia, pediatria, ortopedia).  
   - Cada médico deve ter: nome, CRM, especialidade, custo da consulta e agenda de horários.  

3. *Agendamento de Consultas*  
   - Um paciente pode agendar uma consulta com um médico disponível.  
   - Consultas devem registrar: paciente, médico, data/hora, local, status (agendada, concluída, cancelada).  
   - Pacientes especiais (plano de saúde) podem ter *vantagens*, como desconto.  
   - Duas consultas não podem estar agendadas com o mesmo médico na mesma hora, ou no mesmo local e hora

4. *Consultas e Diagnósticos*  
   - Ao concluir uma consulta, o médico pode registrar *diagnóstico* e/ou *prescrição de medicamentos*.  
   - Cada consulta deve ser registrada no *histórico do paciente*.  

5. *Internações*  
   - Pacientes podem ser internados.  
   - Registrar: paciente, médico responsável, data de entrada, data de saída (se já liberado), quarto e custo da internação.  
   - Deve existir controle de *ocupação dos quartos* (não permitir duas internações no mesmo quarto simultaneamente).  
   - Internações devem poder ser canceladas, quando isso ocorrer, o sistema deve ser atualizado automaticamente.

6. *Planos de saúde*    
   -  Planos de saude podem ser cadastrados.
   -  Cada plano pode oferecer *descontos* para *especializações* diferentes, com possibilidade de descontos variados.
   -  Um paciente que tenha o plano de saúde deve ter o desconto aplicado.
   -  Deve existir a possibilidade de um plano *especial* que torna internação de menos de uma semana de duração gratuita.
   -  Pacientes com 60+ anos de idade devem ter descontos diferentes.

7. *Relatórios*  
   - Pacientes cadastrados (com histórico de consultas e internações).  
   - Médicos cadastrados (com agenda e número de consultas realizadas).  
   - Consultas futuras e passadas (com filtros por paciente, médico ou especialidade).  
   - Pacientes internados no momento (com tempo de internação).  
   - Estatísticas gerais (ex: médico que mais atendeu, especialidade mais procurada).  
   - Quantidade de pessoas em um determinado plano de saúde e quanto aquele plano *economizou* das pessoas que o usam.  


---

### ⚙️ Requisitos Técnicos  
- O sistema deve ser implementado em *Java*.  
- Interface via *terminal (linha de comando)*.  
- Os dados devem ser persistidos em *arquivos* (.txt ou .csv).  
- Deve existir *menu interativo*, permitindo navegar entre as opções principais.  

---

### 📊 Critérios de Avaliação  

1. *Modos da Aplicação (1,5)* → Cadastro de pacientes, médicos, planos de saúde, consultas e internações.  
2. *Armazenamento em arquivo (1,0)* → Dados persistidos corretamente, leitura e escrita funcional.  
3. *Herança (1,0)* → Ex.: Paciente e PacienteEspecial, Consulta e ConsultaEspecial, Médico e subclasses por especialidade.  
4. *Polimorfismo (1,0)* → Ex.: regras diferentes para agendamento, preços de consultas.
5. *Encapsulamento (1,0)* → Atributos privados, getters e setters adequados.  
6. *Modelagem (1,0)* → Estrutura de classes clara, bem planejada e com relacionamentos consistentes.  
7. *Execução (0,5)* → Sistema compila, roda sem erros e possui menus funcionais.  
8. *Qualidade do Código (1,0)* → Código limpo, organizado, nomes adequados e boas práticas.  
9. *Repositório (1,0)* → Uso adequado de versionamento, commits frequentes com mensagens claras.  
10. *README (1,0)* → Vídeo curto (máx. 5 min) demonstrando as funcionalidades + prints de execução + explicação da modelagem.  

🔹 *Total = 10 pontos*  
🔹 *Pontuação extra (até 1,5)* → Melhorias relevantes, como:  
- Sistema de triagem automática com fila de prioridade.  
- Estatísticas avançadas (tempo médio de internação, taxa de ocupação por especialidade).  
- Exportação de relatórios em formato .csv ou .pdf.  
- Implementação de testes unitários para classes principais.  
- Menu visual.
