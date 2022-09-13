<h1> Stream Exercicie 2</h1>
<h2>Exercício de fixação sobre Stream, Predicados e Pipelinas.</h2>
<h3>Descrição: </h3>
<p>"Fazer um programa para ler os dados (nome, email e salário)
de funcionários a partir de um arquivo em formato .csv.
Em seguida mostrar, em ordem alfabética, o email dos
funcionários cujo salário seja superior a um dado valor
fornecido pelo usuário.
Mostrar também a soma dos salários dos funcionários cujo
nome começa com a letra 'M'."</p>

<h3>Arquivo de entrada:</h3>
<p>Maria,maria@gmail.com,3200.00</p>
<p>Alex,alex@gmail.com,1900.00</p>
<p>Marco,marco@gmail.com,1700.00</p>
<p>Bob,bob@gmail.com,3500.00</p>
<p>Anna,anna@gmail.com,2800.00</p>
</br>
<h3>Execução:</h3>
<p>Enter full file path: "employee.txt"</p>
<p>Employee's: </p>
<p>Maria, maria@gmail.com, R$3200.00</p>
<p>Alex, alex@gmail.com, R$1900.00</p>
<p>Marco, marco@gmail.com, R$1700.00</p>
<p>Bob, bob@gmail.com, R$3500.00</p>
<p>Anna, anna@gmail.com, R$2800.00</p>
</br>
<p>Enter salary: 2000</p>
</br>
<p>Filtred Salary: </p>
<p>Anna, anna@gmail.com, R$2800.00</p>
<p>Bob, bob@gmail.com, R$3500.00</p>
<p>Maria, maria@gmail.com, R$3200.00</p>
</br>
<h3>Streams Utilizadas: </h3>
<p>List<Employee> filtredSalary = empList.stream().filter(x -> x.getSalary() >= minValue)
					.collect(Collectors.toList()); Filtra os empregados com o salário maior que o informado</p>
</br>
filtredSalary.sort((p1, p2) -> p1.getEmail().compareTo(p2.getEmail())); Ordena os funcionários com base no email
</br>
<p>double sum = empList.stream().filter(x -> x.getName().charAt(0) == 'M').map(p -> p.getSalary())
					.reduce((double) 0, (p1, p2) -> p1 + p2); Soma o salário dos funcionários que iniciem com a letra 'M'</p>
