package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import models.entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> empList = new ArrayList<Employee>();
		System.out.print("Enter full file path: ");

		try {
			FileReader fr = new FileReader(sc.next());
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				String[] aux = line.split(",");
				Employee emp = new Employee(aux[0], aux[1], Double.parseDouble(aux[2]));
				empList.add(emp);
				line = br.readLine();
			}
			System.out.println("Employee's: ");
			empList.forEach(System.out::println);

			System.out.print("\nEnter salary: ");
			double minValue = sc.nextDouble();
			List<Employee> filtredSalary = empList.stream().filter(x -> x.getSalary() >= minValue)
					.collect(Collectors.toList());
			filtredSalary.sort((p1, p2) -> p1.getEmail().compareTo(p2.getEmail()));
			System.out.println("\nFiltred Salary: ");
			filtredSalary.forEach(System.out::println);

			double sum = empList.stream().filter(x -> x.getName().charAt(0) == 'M').map(p -> p.getSalary())
					.reduce((double) 0, (p1, p2) -> p1 + p2);
			System.out.println("Sum of salary of people whose name starts with 'M': R$" + String.format("%.2f", sum));
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error! File is not found " + e.getMessage());
		}
		sc.close();
	}

}
