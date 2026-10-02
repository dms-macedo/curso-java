package academy.devdojo.maratonajava.javacore.zzClambdas.test;

public class LambdasTest01 {
    /*
     * Expressões Lambda são funções anônimas (sem nome, modificadores de acesso ou tipo de retorno explícito) que fornecem uma forma concisa de passar comportamento por parâmetro no Java. Elas funcionam como implementações diretas de Interfaces Funcionais, que são interfaces marcadas com a anotação @FunctionalInterface contendo exatamente um único método abstrato (como a interface CarPredicate e seu método boolean test(Car car)).
     * A sintaxe é composta pelos parâmetros de entrada, o operador seta (->) e o corpo da execução, seguindo o padrão: (parâmetros) -> <expressão ou bloco de código>. A tipagem dos parâmetros e o retorno são inferidos automaticamente pelo compilador com base no método abstrato da interface. Como exemplo prático, em vez de instanciar uma classe anônima inteira para filtrar um objeto Car, utiliza-se a lambda no formato: (Car car) -> car.getColor().equals("green") ou de forma ainda mais enxuta: car -> "green".equals(car.getColor()).
     */
}
