package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

/*
 * =========================================================================================
 * CLASSES ANÔNIMAS (ANONYMOUS CLASSES)
 * =========================================================================================
 *
 * O QUE É:
 * É uma classe local sem nome, declarada e instanciada simultaneamente em uma única instrução.
 *
 * PARA QUE SERVE E ONDE USAR:
 * Serve para sobrescrever comportamentos de uma classe existente (concreta ou abstrata) ou
 * implementar uma interface de forma rápida e pontual, quando a lógica só será utilizada
 * uma única vez naquele ponto do código (ex: Comparator, Runnable, tratação de eventos).
 *
 * REGRAS E FUNCIONAMENTO:
 * 1. Instanciação e Declaração Conjuntas: Criada diretamente com o operador 'new' seguido do
 *    nome da superclasse ou interface, abrindo o bloco de código: new Interface() { ... };
 * 2. Sem Construtor: Não pode declarar construtores próprios, pois não possui nome.
 * 3. Regra do Effectively Final: Acessa variáveis locais do método apenas se forem 'final'
 *    ou 'effectively final' (valores não alterados após inicialização).
 * 4. Escopo Único: Por não ter nome, não pode ser reutilizada ou instanciada novamente em
 *    outro ponto do sistema.
 * =========================================================================================
 */

class Animal {
    public void walk(){
        System.out.println("Animal walking...");
    }
}

public class AnonymousClassesTest01 {
    public static void main(String[] args) {
        Animal animal = new Animal();

        Animal animal1 = new Animal(){
            @Override
            public void walk() {
                System.out.println("Walking in the shadows...");
            }
        };

        animal.walk();
        animal1.walk();
    }
}
