package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Contribuinte;
import entity.PessoaFisica;
import entity.PessoaJuridica;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais
		 * podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um,
		 * bem como o total de imposto arrecadado.
		 * Os dados de pessoa física são: nome, renda anual e gastos com saúde. Os dados de pessoa jurídica
		 * são nome, renda anual e número de funcionários. As regras para cálculo de imposto são as
		 * seguintes:
		 * Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
		 * renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50%
		 * destes gastos são abatidos no imposto.
		 * Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
		 * fica: (50000 * 25%) - (2000 * 50%) = 11500.00
		 * Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10
		 * funcionários, ela paga 14% de imposto.
		 * Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica:
		 * 400000 * 14% = 56000.00
		 * 
		 * Enter the number of tax payers: 3
		 * Tax payer #1 data:
		 * Individual or company (i/c)? i
		 * Name: Alex
		 * Anual income: 50000.00
		 * Health expenditures: 2000.00
		 * Tax payer #2 data:
		 * Individual or company (i/c)? c
		 * Name: SoftTech
		 * Anual income: 400000.00
		 * Number of employees: 25
		 * Tax payer #3 data:
		 * Individual or company (i/c)? i
		 * Name: Bob
		 * Anual income: 120000.00
		 * Health expenditures: 1000.00
		 * TAXES PAID:
		 * Alex: $ 11500.00
		 * SoftTech: $ 56000.00
		 * Bob: $ 29500.00
		 * TOTAL TAXES: $ 97000.00
		 */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<Contribuinte>();
		
		double somaTaxa = 0;
		
		
		System.out.print("Entre com o número de Contribuintes: ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			System.out.println("Contribuinte #" + i + " data:");
			sc.nextLine();
			
			System.out.print("Pessoa Física ou Juridica (f/j)? ");
			String contribuinte = sc.nextLine();
			
			if(contribuinte.equals("f")) {
				System.out.print("Nome : ");
				String nome = sc.nextLine();
				
				System.out.print("Renda Anual: ");
				double rendaAnual = sc.nextDouble();
				
				System.out.print("Gastos com saúde: ");
				double gastosSaude = sc.nextDouble();
				
				PessoaFisica pf = new PessoaFisica(nome, rendaAnual, gastosSaude);
				
				list.add(pf);
			}else {
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				
				System.out.print("Renda Anual: ");
				double rendaAnual = sc.nextDouble();
				
				System.out.print("Número de Funcionários: ");
				int numFuncionarios = sc.nextInt();
				
				PessoaJuridica pj = new PessoaJuridica(nome, rendaAnual, numFuncionarios);
				
				list.add(pj);
			}
			
		}
		
		System.out.println();
		System.out.println("Impostos Pagos: ");
		
		for (Contribuinte contribuinte : list) {
			System.out.println(contribuinte.getNome() + ": $ " + String.format("%.2f", contribuinte.taxa()));
			somaTaxa += contribuinte.taxa();
		}
		
		System.out.println();
		System.out.println("Total de Taxas: $ " + String.format("%.2f", somaTaxa));

	}

}
