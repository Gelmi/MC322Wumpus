# Lab05 - Mundo de Wumpus
## MC322Wumpus
### Arquivos Java sobre Mundo de Wumpus

[Arquivos](src/pt/c40task/l05wumpus/)

### Recortes de código
#### Sobrecarga de método:
```java
public class Controle { ...
	Controle() { ... }
	Controle(String nome) { ... }
	public Boolean pegarComandos() { ... }
	public Boolean pegarComandos(String comando) {...}
    ...}
```
O uso da sobrecarga de método para o controle tornou possivel a utilização do mesmo controle de modo coeso tanto para a utilização interativa da aplicação, quanto para a utilização automatizada.

#### Polimorfismo:
```java
public class Sala {
	...
	private Componente componentes[] = new Componente[7];
    ...
}
```
Em cada sala só conseguimos guardar as diferentes instancias de Componentes herdeiros utilizando do polimorfismo. Além disso, caso precisemos adicionar novos componentes a adição é simples devido a implementação dos principais atributos e metodos dentro da superclasse Componente.

#### Responsabilidades da Sala:
```java
public class Sala {
	...
	public Boolean conecta(Componente componente) { ... }
    ...
}
```
A sala é responsável pela manutenção correta de seus componentes assim como pela "interação" entre os componentes. O metodo conecta trata cada caso de insersão e "interação", se comunicando com os componentes de forma adequada após a tomada de decisão. Resolvemos abordar essa arquitetura para que não houvesse redundancia de chamada na caverna sempre que 2 componentes "interagissem". A palavra interação é usada entre aspas pois os componentes não sabem que estão interagindo, apenas a sala sabe.