# Correção

| Questão     | Legibilidade | Diagramas | P1 | P2 | P3 | Total |
|-------------|--------------|-----------|----|----|----|-------|
| Nota máxima | 10           | 10        | 20 | 25 | 35 | 100   |
| Nota        | 10           | 0         | 20 | 23 | 32 |       |

## Diagramas

- sem diagramas

## P1

- a lógica de ignorar maiusculas está no Gerenciador... eu acredito que seja correto deixar no Usuario.

### Requisitos Funcionais
- [x] Cadastrar novos usuários
- [x] Remover usuários
- [x] Listar os logins
- [x] Autenticar usuários

## P2

- boa solução para categorias. quando vermos enumerações, vai ficar mais fácil
- a distribuição percentual era por categoria, não estado de espera

### Requisitos Funcionais
- [x] Registrar novas solicitações
- [x] Listar os telefones dos clientes registrados
- [x] Imprimir o nome do próximo cliente
- [x] Atender o próximo cliente
- [x] Listar os nomes dos clientes já atendidos
- [x] Listar os telefones dos clientes em espera
- [x] Gerar um relatório estatístico
- [x] ... total de solicitações registradas, atendidas, em espera
- [ ] ... distribuição percentual das solicitações por categoria

## P3

- Gerenciador
  - atributos package-private?
- Leitor
  - id aleatório não é uma boa ideia! e se cair duas vezes no mesmo valor?
  - igualdade baseada no nome, e não no id que (deveria ser) é único.
- Acervo
  - é como um mapa manual, que vincula um Livro com dois inteiros. interessante.
  - contudo, como usas um Set<Acervo> no Gerenciador, deveria definir a igualdade de objetos Acervo (provavelmente baseado no Livro)
- Livro
  - igualdade baseada no nome, e não no isbn que é único.

### Requisitos Funcionais
- [x] Cadastrar autores
- [x] Cadastrar livros
- [x] Cadastrar leitores
- [x] Registrar empréstimos de livros para leitores
- [x] ... pelo menos uma cópia
- [x] ... leitor não tenha esse livro
- [x] ... leitor possua no máximo 5 livros emprestados
- [x] Listar autores em ordem alfabética
- [x] Listar leitores em ordem alfabética
- [x] Listar leitores por id
- [x] Listar livros por título
- [x] Listar livros por autor
- [x] Listar livros por ISBN
- [x] Listar empréstimos por data
- [x] Listar empréstimos de um leitor, por data