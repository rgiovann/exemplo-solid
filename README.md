

## Projeto Java: Aplicando SOLID em Comunicação Cliente-Servidor com Sockets

Este projeto demonstra como aplicar os princípios SOLID em uma aplicação simples de comunicação cliente-servidor utilizando **Java Sockets**. Ele foi desenvolvido com fins educacionais para reforçar conceitos de design orientado a objetos e boas práticas de arquitetura de software.

## Objetivos

- Demonstrar a aplicação prática dos princípios **SOLID** em projetos educacionais.
- Permitir múltiplas conexões simultâneas ao servidor.
- Permitir que o cliente envie texto e receba respostas processadas (ex: texto em maiúsculas, hash, reverso etc).
- Facilitar extensões futuras sem modificar o código existente.

## Princípios SOLID Aplicados

| Princípio | Aplicação no Projeto |
|-----------|-----------------------|
| SRP | Cada classe tem uma única responsabilidade (ex: processamento, entrada, conexão). |
| OCP | Novas operações podem ser adicionadas sem modificar código existente. |
| LSP | Todos os processadores implementam uma mesma interface e podem ser trocados livremente. |
| ISP | Interfaces específicas com métodos únicos e bem definidos. |
| DIP | O sistema depende de abstrações, nunca de implementações concretas. |

## Como Executar o Projeto

1. Clone este repositório:
```bash
git clone https://github.com/seuusuario/socket-solid-java.git
cd socket-solid-java
````

2. Compile com sua IDE Java favorita (Eclipse, IntelliJ, VS Code) ou via terminal:

```bash
javac -d bin $(find . -name "*.java")
```

3. Inicie o servidor:

```bash
java -cp bin application.ServerMain
```

4. Em outro terminal, execute o cliente:

```bash
java -cp bin application.ClientMain
```

***

##  Exemplo de Interação

```bash
Servidor iniciado na porta 52000.
Cliente conectado.
Digite uma mensagem: Olá mundo!
Resposta do servidor: operação: [UPPERCASE] : OLÁ MUNDO!
```

***

##  Extensibilidade

Você pode criar um novo tipo de processamento implementando a interface `TextProcessor`, como neste exemplo:

```java
public class RemoveVogaisProcessor implements TextProcessor {
    @Override
    public String process(String input) {
        return input.replaceAll("[aeiouAEIOU]", "");
    }
}
```

Depois, é só instanciar no `ServerMain`:

```java
TextProcessor processor = new RemoveVogaisProcessor();
```

***

##  Artigo

Este projeto é acompanhado do artigo técnico (arquivo pdf):

📄 [Aplicando SOLID em Projetos Educacionais com Sockets em Java (PDF)](./solid-connection.pdf)

***

##  Autor

Giovanni L. Rozza\
🔗 [LinkedIn](https://www.linkedin.com/in/giovannirozza)

***

##  Licença

Este projeto está licenciado sob a licença MIT. Sinta-se livre para estudar, modificar e compartilhar com atribuição.

```

Se quiser que eu personalize o link do repositório, nome do projeto ou o link direto do PDF/artigo, é só me avisar!
```
